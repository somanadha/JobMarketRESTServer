package com.bst.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobMarketRESTServer {

	public static void main(String[] args) {
		var context = SpringApplication.run(JobMarketRESTServer.class, args);
		System.out.println("Hello World!");
	}
}
