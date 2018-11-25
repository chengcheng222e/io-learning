package com.cyblogs.io.learn.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("BIOServer has started,listening on port:" + serverSocket.getLocalSocketAddress());

        RequestHandler requestHandler = new RequestHandler();// 为了让多线程去切换
        while (true) {
            Socket clientSocket = null;
            clientSocket = serverSocket.accept(); //等待被接受
            System.out.println("Conection from " + clientSocket.getRemoteSocketAddress());
            // 多线程处理
            executor.submit(new ClientHandler(clientSocket, requestHandler));
        }
    }
}
