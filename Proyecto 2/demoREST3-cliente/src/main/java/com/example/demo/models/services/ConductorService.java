package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.Conductor;

// En esta clase se indican los métodos que se van a utilizar para proporcionar información en los servicios
public interface ConductorService {

	public List<Conductor> findAll();
	public Conductor findById(Long id);
	
}
