package ru.itis.servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatMultiServer {
    // список клиентов
    private List<ClientHandler> clients;
    public HashSet<String> cities;
    private String previousCity;
    private int queue = 0;

    public ChatMultiServer() {
        // Список для работы с многопоточностью
        clients = new CopyOnWriteArrayList<>();
        cities = new HashSet<>();
        previousCity = "";
    }

    public void start(int port) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        // запускаем бесконечный цикл
        while (true) {
            try {
                // запускаем обработчик сообщений для каждого подключаемого клиента
                new ClientHandler(serverSocket.accept()).start();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private class ClientHandler extends Thread {
        // связь с одним клиентом
        private Socket clientSocket;
        // информация, поступающая от клиента
        private BufferedReader in;
        private PrintWriter out;


        ClientHandler(Socket socket) {
            this.clientSocket = socket;
            // добавляем текущее подключение в список
            clients.add(this);
            try {
                out = new PrintWriter(this.clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.println("New client " + socket.getPort());
        }

        private boolean findCity(String SearchedCity) {
            if(cities.isEmpty()) {
                return false;
            }

            for (String city: cities) {
                if(city.equals(SearchedCity)) {
                    out.println("This city was used");
                    return true;
                }
            }
            return false;
        }

        private boolean checkLastLetter (String city) {
            if (previousCity.equals("")) {
                return true;
            }
            if(city.charAt(0) == previousCity.charAt(previousCity.length()-1)) {
                return true;
            } else {
                out.println("You need to write the city which beginning in " + previousCity.charAt(previousCity.length()-1));
                return false;
            }
        }

        private void sendAllUsers(String text) throws IOException {
            for (ClientHandler client : clients) {
                PrintWriter out = new PrintWriter(client.clientSocket.getOutputStream(), true);
                out.println(text);
            }
        }

        public void run() {
            try {
                // получем входной поток для конкретного клиента
                in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if(clients.get(queue).equals(this)) {
                        if (".".equals(inputLine)) {
                            // бегаем по всем клиентам и обовещаем их о событии
                            for (ClientHandler client : clients) {
                                PrintWriter out = new PrintWriter(client.clientSocket.getOutputStream(), true);
                                out.println("You win!");
                            }
                            break;
                        } else {
                            if(!findCity(inputLine) && checkLastLetter(inputLine)) {
                                cities.add(inputLine);
                                previousCity = inputLine;
                                sendAllUsers("Player " + clientSocket.getPort() + ": " + inputLine);
                                if(queue == clients.size() - 1) {
                                    queue = 0;
                                } else {
                                    queue++;
                                }
                            }

                        }
                    } else {
                        out.println("Wait...");
                    }
                }
                in.close();
                clientSocket.close();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
