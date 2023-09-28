package com.codingdojo.javierulloa.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.javierulloa.modelos.Pregunta;

public interface repositorioPreguntas extends CrudRepository<Pregunta,Long>{
	
	List<Pregunta> findAll();
	
	List<Pregunta> findByEtiquetasTemaContaining(String tema);
}
