package com.cyblogs.io.learn.biocase;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with io-learn
 * Description：
 * User：chenyuan
 * Date：2018/12/6
 * Time：10:08 AM
 */
public class ClientHandler implements Runnable {

    private Socket clientSocket;
    private RequestHandler requestHandler;

    public ClientHandler(Socket clientSocket, RequestHandler requestHandler) {
        this.clientSocket = clientSocket;
        this.requestHandler = requestHandler;
    }

    @Override
    public void run() {
        try {
            System.out.println("Connection form" + clientSocket.getRemoteSocketAddress());
            Scanner input = new Scanner(clientSocket.getInputStream());
            while (true) {
                if (input.hasNext()) {
                    String request = input.nextLine();
                    if ("quit".equals(request)) {
                        break;
                    }
                    System.out.println(clientSocket.getRemoteSocketAddress() + " → " + request);
                    String response = requestHandler.handle(request);
                    clientSocket.getOutputStream().write(response.getBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
