package com.cyblogs.io.learn.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {

    private Socket clientSocket;
    private RequestHandler requestHandler;

    public ClientHandler(Socket clientSocket, RequestHandler requestHandler) {
        this.clientSocket = clientSocket;
        this.requestHandler = requestHandler;
    }


    public void run() {
        try {
            Scanner input = new Scanner(clientSocket.getInputStream());
            while (true) {
                if (input.hasNext()) {
                    String request = input.nextLine();
                    if ("quit".equals(request)) {
                        break;
                    }
                    System.out.println(request);
                    String response = requestHandler.handler(request);
                    clientSocket.getOutputStream().write(response.getBytes());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}
