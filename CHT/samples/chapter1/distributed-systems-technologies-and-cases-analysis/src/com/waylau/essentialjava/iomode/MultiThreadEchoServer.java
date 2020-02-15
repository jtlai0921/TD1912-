/**
 * 
 */
package com.waylau.essentialjava.iomode;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ������I/O+�h��������Ҧ��C�ϥΦh������Ӥ䴩�h�ӥΤ�ݦs�����A��
 * 
 * @author <a href="https://waylau.com">waylau.com</a>
 * @date 2016�~7��29��
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

				// �h�����
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
