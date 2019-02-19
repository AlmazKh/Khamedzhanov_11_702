package ru.itis.programs.servers;

import ru.itis.servers.ChatMultiServer;

public class ProgramChatMultiServerStart {
    public static void main(String[] args) {
        ChatMultiServer server = new ChatMultiServer();
        server.start(6666);
    }
}
