package com.codingdojo.javierulloa.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.javierulloa.modelos.Tarea;

public interface RepositorioTareas extends CrudRepository<Tarea,Long>{

	List<Tarea> findAll();
	
	List<Tarea> findAllByOrderByPrioridadDesc();
	
	List<Tarea> findAllByOrderByPrioridadAsc();
}
