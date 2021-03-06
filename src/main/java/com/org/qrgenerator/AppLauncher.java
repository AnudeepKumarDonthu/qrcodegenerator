package com.org.qrgenerator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * QR Code Generator
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.org" })
public class AppLauncher /*extends SpringBootServletInitializer */ {

	@Value("server.port")
	private static String serverPort;

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(AppLauncher.class);
		application.run(args);

	}

	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder builder) { return
	 * builder.sources(App.class); }
	 */

}
