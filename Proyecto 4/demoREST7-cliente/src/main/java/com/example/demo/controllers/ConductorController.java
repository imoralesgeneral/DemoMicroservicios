package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Coche;
import com.example.demo.models.Conductor;
import com.example.demo.models.services.ConductorService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

// Clase que publica la info en los servicios
@RestController
public class ConductorController {

	@Autowired
	@Qualifier("conductorServiceFeign")
	private ConductorService conductorService;  // En este objeto se ha indicado la lógica para obtener la información que luego se publicará
	
	/**
	 * Este método devolvera toda la información que exista de los conductores
	 * @return
	 */
	@GetMapping("/listar")
	public List<Conductor> listar() {
		return conductorService.findAll();
	}
	
	/**
	 * Este devolverá la info del conductor que pertenezca al coche del que se pase el id
	 * @param id
	 * @return
	 */
	@HystrixCommand(fallbackMethod="metodoAlternativo") // Esta etiqueta sirve para que si se produce algun fallo se ejecute el método indicado
	@GetMapping("/listar/{id}")
	public Conductor devolverConductor(@PathVariable Long id) {
		return conductorService.findById(id);
	}
	
	/**
	 * Este método será el ejecutado si falla el primario
	 * @param id
	 * @return
	 */
	public Conductor metodoAlternativo(@PathVariable Long id) {
		Coche coche = new Coche();
		coche.setId(4L);
		coche.setMarca("Marca Error");
		coche.setModelo("Modelo Error");
		return new Conductor("Pepe", coche);
	}
	
}
