package com.waylau.essentialjava.iomode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 處理器類別
 * 
 * @author <a href="https://waylau.com">waylau.com</a>
 * @date 2016年7月29日
 */
public class EchoServerHandler implements Runnable {
	private Socket clientSocket;

    public EchoServerHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (
        		PrintWriter out = new PrintWriter(clientSocket.getOutputStream()
        		, true);
                BufferedReader in = new BufferedReader(
                		new InputStreamReader(clientSocket.getInputStream()));) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println(inputLine);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
