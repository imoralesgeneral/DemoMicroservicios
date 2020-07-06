package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

// Habilito Zuul como puerta de enlace para el resto de servicios
@EnableZuulProxy
@SpringBootApplication
public class DemoRest9ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRest9ZuulApplication.class, args);
	}

}
