package com.codingdojo.javierulloa.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.javierulloa.modelos.Musica;

public interface RepositorioMusicas extends CrudRepository<Musica, Long>{
	
	
	List<Musica> findAll();
	
	List<Musica> findByAutorContaining(String autor);
	
	List<Musica> findTop10ByOrderByCalificacionDesc();
}
