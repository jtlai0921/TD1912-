package com.waylau.rest;

//import org.glassfish.grizzly.http.server.HttpServer;
//import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
//import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
//import org.glassfish.jersey.simple.SimpleContainerFactory;

import java.io.IOException;
import java.net.URI;

import org.glassfish.jersey.jetty.JettyHttpContainerFactory;

/**
 * �D�M��
 *
 */
public class App {
	// HTTP server �ҭn��ť�� uri
	public static final String BASE_URI = "http://192.168.11.125:8081/";

	/**
	 * Main ��k.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// �Y�ϥ� Jdk Http Server�Хh���U�����`��
		// JdkHttpServerFactory.createHttpServer(URI.create(BASE_URI), new
		// RestApplication());

		// �Y�ϥ� Grizzly Http Server�Хh���U�����`��
		// GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), new
		// RestApplication());

		// �Y�ϥ� Simple Http Server�Хh���U�����`��
		// SimpleContainerFactory.create(URI.create(BASE_URI), new
		// RestApplication());
		// �Y�ϥ� Jetty Http Server�Хh���U�����`��
		JettyHttpContainerFactory.createServer(URI.create(BASE_URI),
				new RestApplication());
	}
}
