package com.codingdojo.javierulloa.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.javierulloa.modelos.Proyecto;
import com.codingdojo.javierulloa.modelos.Usuario;

public interface RepositorioProyectos extends CrudRepository<Proyecto,Long>{
	
	List<Proyecto> findAll();
	
	List<Proyecto> findByUsuarioUnidosContains(Usuario usuario);
	
	List<Proyecto> findByUsuarioUnidosNotContains(Usuario usuario);
}
