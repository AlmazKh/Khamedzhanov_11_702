package ru.itis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatPanelController {

    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;

    @FXML
    public void initialize() {
//        Scanner scanner = new Scanner(System.in);
//        ClientTask client = new ClientTask(new ChatPanelController());
//        client.startConnection("127.0.0.1", 6666);
//        while (true) {
//            String message = scanner.nextLine();
//            client.sendMessage(message);
//        }
        try {
            Socket clientSocket = new Socket("127.0.0.1", 6666);
            ClientTask task = new ClientTask(this, clientSocket, textField);
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            executorService.execute(task);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @FXML
    public void sendMessage( String text) {
        textArea.appendText(text + "\n");
        textField.clear();

    }
}
