package com.cyblogs.io.learn.biocase;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with io-learn
 * <p>
 * Description：建一个链接，打印出链接信息
 * User：chenyuan
 * Date：2018/12/3
 * Time：7:32 PM
 */
public class CreateConnectionBIOServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket socket = new ServerSocket(port);
        System.out.println("FirstBIOServer has start, listening on port:" + port);
        Socket clientSocket = socket.accept();
        System.out.println("Connection form" + clientSocket.getRemoteSocketAddress());
    }

}
