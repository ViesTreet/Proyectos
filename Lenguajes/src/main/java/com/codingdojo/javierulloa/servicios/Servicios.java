package com.codingdojo.javierulloa.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.javierulloa.modelos.Lenguaje;
import com.codingdojo.javierulloa.repositorios.RepositorioLenguajes;


@Service
public class Servicios {

	
	@Autowired
	private RepositorioLenguajes repoLenguaje;
	
	
	public List<Lenguaje> todosLenguajes(){
		return repoLenguaje.findAll();
	}
	
	public Lenguaje guardaLenguajes(Lenguaje nuevoLenguaje) {
		return repoLenguaje.save(nuevoLenguaje);
	}
	
	public Lenguaje buscarLenguaje(Long id) {
		return repoLenguaje.findById(id).orElse(null);
	}
	
	public void borrarLenguaje(Long id) {
		repoLenguaje.deleteById(id);
	}
	
	public Lenguaje editarLenguaje(Long id, Lenguaje lenguajeActualizado) {
        Optional<Lenguaje> lenguajeExistente = repoLenguaje.findById(id);
        
        if (lenguajeExistente.isPresent()) {
            Lenguaje lenguaje = lenguajeExistente.get();
            lenguaje.setNombre(lenguajeActualizado.getNombre());
            lenguaje.setCreador(lenguajeActualizado.getCreador());
            lenguaje.setVersion(lenguajeActualizado.getVersion());
            
            return repoLenguaje.save(lenguaje);
        }
        
        return null;
	}
}
