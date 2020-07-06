package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Coche;

//esta clase implementa a JpaRepository y permite utilizar sus métodos (se le pasa el tipo de objeto y el tipo de la primary key)
//si quisieramos que realizase alguna query específica debería incluirse el método aquí
public interface CocheRepository extends JpaRepository<Coche, Long>{

}
