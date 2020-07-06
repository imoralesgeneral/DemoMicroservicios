package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// Clase principal. Arranca la aplicación.
@EnableFeignClients // Habilito que se pueda utiliza Feign para consumir otros servicios REST
@SpringBootApplication
public class DemoRest5ClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRest5ClienteApplication.class, args);
	}

}
