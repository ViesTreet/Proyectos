package com.codingdojo.javierulloa.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.javierulloa.modelos.Usuario;

public interface RepositorioUsuarios extends CrudRepository<Usuario,Long>{

	List<Usuario> findAll();
	
	Usuario findByEmail(String email);
}
