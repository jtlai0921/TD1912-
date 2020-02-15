package com.waylau.rest;

//import org.glassfish.grizzly.http.server.HttpServer;
//import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
//import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
//import org.glassfish.jersey.simple.SimpleContainerFactory;

import java.io.IOException;
import java.net.URI;

import org.glassfish.jersey.jetty.JettyHttpContainerFactory;

/**
 * 主套用
 *
 */
public class App {
	// HTTP server 所要監聽的 uri
	public static final String BASE_URI = "http://192.168.11.125:8081/";

	/**
	 * Main 方法.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// 若使用 Jdk Http Server請去掉下面的注解
		// JdkHttpServerFactory.createHttpServer(URI.create(BASE_URI), new
		// RestApplication());

		// 若使用 Grizzly Http Server請去掉下面的注解
		// GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), new
		// RestApplication());

		// 若使用 Simple Http Server請去掉下面的注解
		// SimpleContainerFactory.create(URI.create(BASE_URI), new
		// RestApplication());
		// 若使用 Jetty Http Server請去掉下面的注解
		JettyHttpContainerFactory.createServer(URI.create(BASE_URI),
				new RestApplication());
	}
}
