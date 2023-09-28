package com.codingdojo.javierulloa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.javierulloa.modelos.Dojo;
import com.codingdojo.javierulloa.modelos.Ninja;
import com.codingdojo.javierulloa.repositorios.repositorioDojos;
import com.codingdojo.javierulloa.repositorios.repositorioNinjas;

@Service
public class Servicios {

	
	@Autowired
	private repositorioNinjas repoNinja;
	
	@Autowired
	private repositorioDojos repoDojo;
	
	public List<Dojo> todosLosDojos(){
		return repoDojo.findAll();
	}
	
	public List<Ninja> todosLosNinjas(){
		return repoNinja.findAll();
	}
	
	public Dojo dojoPorId(Long id) {
		return repoDojo.findById(id).orElse(null);
	}
	
	public Ninja ninjaPorId(Long id) {
		return repoNinja.findById(id).orElse(null);
	}
	
	public Dojo guardarDojo(Dojo nuevoDojo) {
		return repoDojo.save(nuevoDojo);
	}
	
	public Ninja guardarNinja(Ninja nuevoNinja) {
		return repoNinja.save(nuevoNinja);
	}
}
