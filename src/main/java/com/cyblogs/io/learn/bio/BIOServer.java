package com.cyblogs.io.learn.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class BIOServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8080);
        System.out.println("BIOServer has started,listening on port:" + serverSocket.getLocalSocketAddress());

        Socket clientSocket = serverSocket.accept(); //等待被接受
        System.out.println("Conection from " + clientSocket.getRemoteSocketAddress());

        Scanner input=new Scanner(clientSocket.getInputStream());
        String request=input.nextLine();
        System.out.println(request);

        String response="From BIOServer response： " + request + "\n";
        clientSocket.getOutputStream().write(response.getBytes());
    }
}
