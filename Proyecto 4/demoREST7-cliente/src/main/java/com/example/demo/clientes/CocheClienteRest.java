package com.example.demo.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.models.Coche;

// Esta interfaz indica el servicio REST del cual consume la aplicación y los métodos que utiliza
@FeignClient(name="servicio-coche") // Se establece el nombre del servicio que se consume (aparece en el properties de ese servicio)
public interface CocheClienteRest {

	@GetMapping("/listar") // url de donde se consume ese servicio
	public List<Coche> listar();
	
	@GetMapping("/listar/{id}") // url de donde se consume ese servicio
	public Coche devolverCoche(@PathVariable Long id);
	
}
