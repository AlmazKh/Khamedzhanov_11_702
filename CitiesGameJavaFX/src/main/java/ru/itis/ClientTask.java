package ru.itis;

import javafx.application.Platform;
import javafx.concurrent.Task;

public class ClientTask extends Task<Void> {

    private ChatPanelController chatPanelController;

    public ClientTask(ChatPanelController chatPanelController) {
        this.chatPanelController = chatPanelController;
    }
    @Override
    protected Void call() throws Exception {
        // бесконечный цикл
//        while (true) {
//            //...
//            // рисуем на форме
//            if (someCondition) {
//                Platform.runLater(() -> {
//                    controller. ...
//
//                });
//            }
//        }
        return null;
    }
}
