package com.codingdojo.javierulloa.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.javierulloa.modelos.Libro;


public interface RepositorioLibros extends CrudRepository<Libro, Long>{
	
	List<Libro> findAll();
}
