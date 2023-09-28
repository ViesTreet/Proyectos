package com.codingdojo.javierulloa.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.javierulloa.modelos.Libro;
import com.codingdojo.javierulloa.repositorios.RepositorioLibros;


@Service
public class Servicios {
	
	@Autowired
	private RepositorioLibros repoLibros;
	
	
	public List<Libro> todosLibros(){
		return repoLibros.findAll();
	}
	
	public Libro guardaLibro(Libro nuevoLibro) {
		return repoLibros.save(nuevoLibro);
	}
	
	public Libro buscarLibro(Long id) {
		return repoLibros.findById(id).orElse(null);
	}
	
	public void borrarLibro(Long id) {
		repoLibros.deleteById(id);
	}
	
	public Libro editarLibro(Long id, Libro libroActualizado) {
        Optional<Libro> libroExistente = repoLibros.findById(id);
        
        if (libroExistente.isPresent()) {
            Libro libro = libroExistente.get();
            libro.setNombre(libroActualizado.getNombre());
            libro.setDescripcion(libroActualizado.getDescripcion());
            libro.setLenguaje(libroActualizado.getLenguaje());
            libro.setPaginas(libroActualizado.getPaginas());
            
            return repoLibros.save(libro);
        }
        
        return null;
	}
}
