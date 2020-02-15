package com.waylau.essentialjava.iomode;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ������I/O+����������Ҧ�
 * 
 * @author <a href="https://waylau.com">waylau.com</a>
 * @date 2016�~7��29��
 */
public class ThreadPoolEchoServer {

	public static int DEFAULT_PORT = 7;

    public static void main(String[] args) throws IOException {

        int port;

        try {
            port = Integer.parseInt(args[0]);
        } catch (RuntimeException ex) {
            port = DEFAULT_PORT;
        }
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        Socket clientSocket = null;
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            while (true) {
                clientSocket = serverSocket.accept();
                
                // �������
                threadPool.submit(new Thread(new EchoServerHandler(clientSocket)));
            }
        } catch (IOException e) {
            System.out.println(
                    "Exception caught when trying to listen on port " 
                    + port + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
