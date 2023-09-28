package com.codingdojo.javierulloa.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.javierulloa.modelos.Dormitorio;

public interface RepositorioDormitorios extends CrudRepository<Dormitorio,Long>{
	
	List<Dormitorio> findAll();

}
