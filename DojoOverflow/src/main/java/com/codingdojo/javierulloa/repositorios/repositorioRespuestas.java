package com.codingdojo.javierulloa.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.javierulloa.modelos.Respuesta;

public interface repositorioRespuestas extends CrudRepository<Respuesta,Long>{
	List<Respuesta> findAll();
}
