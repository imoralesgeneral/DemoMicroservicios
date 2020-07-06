package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// Clase de cfg de spring. Donde se crean los Beans para que se almacenen en el contenedor.
@Configuration
public class AppConfig {

	@Bean("clienteRest")
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
	
}
