package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// Esta clase arranca el servidor de nombres EUREKA
@EnableEurekaServer
@SpringBootApplication
public class DemoRest8EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRest8EurekaApplication.class, args);
	}

}
