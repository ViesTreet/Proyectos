package com.codingdojo.javierulloa.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.javierulloa.modelos.Lenguaje;

public interface RepositorioLenguajes extends CrudRepository<Lenguaje, Long>{

	List<Lenguaje> findAll();
	
}
