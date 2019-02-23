package ru.itis;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatPanelController {

    @FXML
    private Button btn;
    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;

    @FXML
    public void initialize() {
        ClientTask task = new ClientTask(this);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(task);
    }

    @FXML
    private void click(ActionEvent event) {
        btn.setText("You've clicked!");
    }

    @FXML
    private void sendMessage(ActionEvent event) {
        textArea.setText(textField.getText() + "\n\r");
        textField.clear();

    }
}
