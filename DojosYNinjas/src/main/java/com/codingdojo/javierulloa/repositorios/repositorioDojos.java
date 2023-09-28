package com.codingdojo.javierulloa.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.javierulloa.modelos.Dojo;

public interface repositorioDojos extends CrudRepository<Dojo, Long>{
	
	List<Dojo> findAll();

}
