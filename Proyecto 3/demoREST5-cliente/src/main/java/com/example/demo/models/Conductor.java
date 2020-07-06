package com.example.demo.models;

public class Conductor {

	private String nombre;
	private Coche coche;
	
	public Conductor() {
		super();
	}
	
	public Conductor(String nombre, Coche coche) {
		super();
		this.nombre = nombre;
		this.coche = coche;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Coche getCoche() {
		return coche;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
	}

	@Override
	public String toString() {
		return "Conductor [nombre=" + nombre + ", coche=" + coche + "]";
	}
	
}
