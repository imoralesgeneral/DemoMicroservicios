package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Conductor;
import com.example.demo.models.services.ConductorService;

// Clase que publica la info en los servicios
@RestController
public class ConductorController {

	@Autowired
	private ConductorService conductorService; 
	
	/**
	 * Este método devolvera toda la información que exista de los conductores
	 * @return
	 */
	@GetMapping("/conductores")
	public List<Conductor> listar() {
		return conductorService.findAll();
	}
	
	/**
	 * Este devolverá la info del conductor que pertenezca al coche del que se pase el id
	 * @param id
	 * @return
	 */
	@GetMapping("/coches/{id}")
	public Conductor devolverConductor(@PathVariable Long id) {
		return conductorService.findById(id);
	}
	
}
