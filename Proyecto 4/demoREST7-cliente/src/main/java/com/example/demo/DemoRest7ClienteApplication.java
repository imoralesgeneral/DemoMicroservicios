package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

// Clase principal. Arranca la aplicación.
@EnableCircuitBreaker // Esta etiqueta sirve para habilitar la tolerancia a fallos con Hystrix
@EnableFeignClients   // Habilita el consumo de servicios REST con Feign
@SpringBootApplication
public class DemoRest7ClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRest7ClienteApplication.class, args);
	}

}
