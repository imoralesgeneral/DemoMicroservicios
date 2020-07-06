package com.example.demo.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.clientes.CocheClienteRest;
import com.example.demo.models.Coche;
import com.example.demo.models.Conductor;

// En esta clase se establece como se obtiene la información para publicarla en los servicios
@Service("conductorServiceFeign")
@Primary
public class ConductorServiceFeign implements ConductorService {
	
	@Autowired
	private CocheClienteRest clienteFeign;// Como para la publicación de estos servicios se necesita a su vez consumir de otro se carga este obj

	/**
	 * Este método primero recoge la info de todos los coches que hay en el servicio (demoREST6) y les asigna un conductor
	 */
	@Override
	public List<Conductor> findAll() {
		return clienteFeign.listar().stream()
				.map(p -> new Conductor(devolverNombreConductorAleatorio(p.getModelo()),p))
				.collect(Collectors.toList());
	}

	/**
	 * Este método recoge la info del coche indicado (por el id) y le asigna un conductor
	 */
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
