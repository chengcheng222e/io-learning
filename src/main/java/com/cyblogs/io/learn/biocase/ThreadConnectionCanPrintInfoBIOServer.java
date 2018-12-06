package com.cyblogs.io.learn.biocase;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with io-learn
 * Description：
 * User：chenyuan
 * Date：2018/12/6
 * Time：8:55 AM
 */
public class ThreadConnectionCanPrintInfoBIOServer {

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        int port = 8080;
        ServerSocket socket = new ServerSocket(port);
        System.out.println("ThreadConnectionCanPrintInfoBIOServer has start, listening on port:" + port);
        RequestHandler requestHandler = new RequestHandler();
        while (true) {
            Socket clientSocket = socket.accept();
            executor.submit(new ClientHandler(clientSocket, requestHandler));
        }
    }
}
