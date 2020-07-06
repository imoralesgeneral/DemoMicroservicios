package com.example.demo.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.clientes.CocheClienteRest;
import com.example.demo.models.Coche;
import com.example.demo.models.Conductor;

@Service("conductorServiceFeign")
@Primary // Se pone la etiqueta primary para que en caso de que se haga autowired sobre la clase padre y tenga más de una implementación, sea esta la que se escoja
public class ConductorServiceFeign implements ConductorService {
	
	@Autowired
	private CocheClienteRest clienteFeign;

	@Override
	public List<Conductor> findAll() {
		return clienteFeign.listar().stream()
				.map(p -> new Conductor(devolverNombreConductorAleatorio(p.getModelo()),p))
				.collect(Collectors.toList());
	}

	@Override
	public Conductor findById(Long id) {
		Coche coche = clienteFeign.devolverCoche(id);
		return new Conductor(devolverNombreConductorAleatorio(coche.getModelo()), coche);
	}
	
	/**
	 * Este metodo me lo he inventado para asignar un nombre al conductor en funcion de la longitud del modelo del coche
	 * @param modelo
	 * @return
	 */
	private String devolverNombreConductorAleatorio(String modelo) {
		String[] nombre = {"Ramón", "Capo"};
		if(modelo.length() > 4) {
			return nombre[0];
		}
		return nombre[1];
	}

}
