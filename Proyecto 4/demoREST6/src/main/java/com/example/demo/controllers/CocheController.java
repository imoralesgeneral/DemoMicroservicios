package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Coche;
import com.example.demo.repository.CocheRepository;

//Controlador para el servicio. Se encarga de devolver la info a las urls definidas en los Mapping
@RestController
public class CocheController {
	
	@Autowired
	private CocheRepository repository; // Hay que importar un objeto de esta clase que implementa a JpaRepository y permite utilizar sus métodos
	
	/**
	 * Este método hace que al incluir /listar en la url de la aplicación, nos devuelva un json
	 * en el que vienen todos los datos (objetos Coche) que tenemos almacenados en la BBDD
	 * @return
	 */
    @RequestMapping(value="/listar", method=RequestMethod.GET)
    public List<Coche> getCoches() {
    	return repository.findAll(); // Este método recupera todo lo que hay en la tabla Coche de la BBDD
    }
    
    /**
     * Este método hace que al incluir /listar/{id} en la url de la aplicación, nos devuelva un json
	 * en el que viene el objetos Coche que tenemos almacenados en la BBDD con ese id (primary key)
     * @param id
     * @return
     * @throws Exception 
     */
    @GetMapping(value="/listar/{id}")
    public Optional<Coche> getCoche(@PathVariable Long id) throws Exception {
    	//Simulo error para comprobar Hystrix al lanzar el /listar/id para los conductores que consume este servicio
    	/*boolean ok = false;
    	if(!ok) {
    		throw new Exception("Error de prueba");
    	}*/
    	return repository.findById(id); // Este método recupera el objeto con ese id de la tabla Coche de la BBDD
    }
    
}
