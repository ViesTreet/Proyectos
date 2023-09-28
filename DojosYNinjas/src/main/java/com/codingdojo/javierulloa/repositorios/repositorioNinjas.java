package com.codingdojo.javierulloa.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.javierulloa.modelos.Ninja;

public interface repositorioNinjas extends CrudRepository<Ninja, Long>{

	List<Ninja> findAll();
	
}
