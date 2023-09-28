package com.codingdojo.javierulloa.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.javierulloa.modelos.Contacto;

public interface repositoriosContactos extends CrudRepository<Contacto, Long>{
	
	List<Contacto> findAll();

}
