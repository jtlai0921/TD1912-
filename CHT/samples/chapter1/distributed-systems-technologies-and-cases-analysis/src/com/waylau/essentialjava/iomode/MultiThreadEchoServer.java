/**
 * 
 */
package com.waylau.essentialjava.iomode;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * “阻塞I/O+多執行緒”模式。使用多執行緒來支援多個用戶端存取伺服器
 * 
 * @author <a href="https://waylau.com">waylau.com</a>
 * @date 2016年7月29日
 */
public class MultiThreadEchoServer {
	public static int DEFAULT_PORT = 7;

	public static void main(String[] args) throws IOException {

		int port;

		try {
			port = Integer.parseInt(args[0]);
		} catch (RuntimeException ex) {
			port = DEFAULT_PORT;
		}
		Socket clientSocket = null;
		try (ServerSocket serverSocket = new ServerSocket(port);) {
			while (true) {
				clientSocket = serverSocket.accept();

				// 多執行緒
				new Thread(new EchoServerHandler(clientSocket)).start();
			}
		} catch (IOException e) {
			System.out.println(
					"Exception caught when trying to listen on port " 
			+ port + " or listening for a connection");
			System.out.println(e.getMessage());
		}
	}
}
