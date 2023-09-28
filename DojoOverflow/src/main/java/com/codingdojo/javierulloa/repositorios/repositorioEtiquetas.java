package com.codingdojo.javierulloa.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.javierulloa.modelos.Etiqueta;

public interface repositorioEtiquetas extends CrudRepository<Etiqueta,Long>{
	List<Etiqueta> findAll();
	
	Etiqueta findByTema(String tema);
}
