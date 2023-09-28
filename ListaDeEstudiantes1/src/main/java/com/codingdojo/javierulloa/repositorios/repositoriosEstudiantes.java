package com.codingdojo.javierulloa.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.javierulloa.modelos.Estudiante;

public interface repositoriosEstudiantes extends CrudRepository<Estudiante, Long>{
	
	List<Estudiante> findAll();
	
	List<Estudiante> findByContactoIdIsNull();

}
