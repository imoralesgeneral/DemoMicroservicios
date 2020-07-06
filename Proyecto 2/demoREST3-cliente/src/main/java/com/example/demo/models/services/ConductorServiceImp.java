package com.example.demo.models.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.Coche;
import com.example.demo.models.Conductor;

@Service
public class ConductorServiceImp implements ConductorService {

	@Autowired
	private RestTemplate clienteRest;
	
	/**
	 * Este método consume el servicio de coches y devuelve los conductores a los que se ha asociado ese coche
	 * para que se pueda publicar en el servicio de conductores
	 */
	@Override
	public List<Conductor> findAll() {
		List<Coche> coches = Arrays.asList(clienteRest.getForObject("http://localhost:8001/coches", Coche[].class));
		return coches.stream()
				.map(p -> new Conductor(devolverNombreConductorAleatorio(p.getModelo()),p))
				.collect(Collectors.toList());
	}

	/**
	 * Este método consume el servicio de coches (se le pasa un id y devuelve el coche correspondiente)
	 * y devuelve el conductor al que se ha asociado ese cochepara que se pueda publicar en el servicio de conductores
	 */
	@Override
	public Conductor findById(Long id) {
		Map<String, String> pathVariables = new HashMap<String,String>();
		pathVariables.put("id", id.toString());
		Coche coche = clienteRest.getForObject("http://localhost:8001/coches/{id}", Coche.class, pathVariables);
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
