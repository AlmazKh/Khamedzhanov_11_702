package ru.itis;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientTask extends Task<Void> {

    private ChatPanelController chatPanelController;
    private PrintWriter out;
    private BufferedReader in;

    public ClientTask(ChatPanelController chatPanelController, Socket clientSocket, TextField textField) {
        this.chatPanelController = chatPanelController;
        startConnection(clientSocket);
        textField.addEventHandler(ActionEvent.ACTION, event -> sendMessage(textField.getText()));
    }

    public void startConnection(Socket clientSocket) {
        try {
            // получили выходной поток
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            // входной поток
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public synchronized void sendMessage(String message) {
        this.out.println(message);
    }

    @Override
    protected Void call() {
        while (true) {
            try {
                String response = in.readLine();
                if (response != null) {
                    System.out.println(response);
                    Platform.runLater(() -> this.chatPanelController.sendMessage(response));
                }
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
