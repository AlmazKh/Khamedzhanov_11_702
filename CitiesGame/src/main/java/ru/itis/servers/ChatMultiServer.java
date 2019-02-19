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

        ClientHandler(Socket socket) {
            this.clientSocket = socket;
            // добавляем текущее подключение в список
            clients.add(this);
            System.out.println("New client " + socket.getPort());
        }
        public boolean findCity(String SerchedCity) {
            if(!cities.isEmpty()) {
                return false;
            }
            for (String city: cities) {
                if(city.equals(SerchedCity)) {
                    System.out.println("This city was used");
                    return true;
                }
            }
            return false;
        }

        public boolean checkLastLetter (String city) {
            if (previousCity.equals("")) {
                return true;
            }
            if(city.charAt(0) == previousCity.charAt(previousCity.length()-1)) {
                return true;
            } else {
                System.out.println("You need to write the city which ending in " + previousCity.charAt(previousCity.length()-1));
                return false;
            }
        }
        public void run() {
            try {
                // получем входной поток для конкретного клиента
                in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
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
                            for (ClientHandler client : clients) {
                                PrintWriter out = new PrintWriter(client.clientSocket.getOutputStream(), true);
                                out.println(inputLine);
                            }
                        }

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