package com.example.demo.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.models.Coche;

// Clase que indica el servicio y métodos que se van a consumir
@FeignClient(name="servicio-coche", url="localhost:8001")
public interface CocheClienteRest {

	@GetMapping("/coches")
	public List<Coche> listar();
	
	@GetMapping("/coches/{id}")
	public Coche devolverCoche(@PathVariable Long id);
	
}
