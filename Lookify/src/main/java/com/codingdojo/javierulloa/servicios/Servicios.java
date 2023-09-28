package com.codingdojo.javierulloa.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.javierulloa.modelos.Musica;
import com.codingdojo.javierulloa.repositorios.RepositorioMusicas;

@Service
public class Servicios {

	
	@Autowired
	private RepositorioMusicas repoMusica;
	
	
	public List<Musica> todoMusica(){
		return repoMusica.findAll();
	}
	
	public Musica MusicaId(Long id){
		return repoMusica.findById(id).orElse(null);
	}
	
	public Musica guardarMusica(Musica nuevaMusica){
		return repoMusica.save(nuevaMusica);
	}
	
	public void eliminarMusica(Long id) {
		repoMusica.deleteById(id);
	}
	
	public Musica editarMusica(Long id , Musica musicaActualizada) {
		Optional<Musica> MusicaExiste = repoMusica.findById(id);
		
		if(MusicaExiste.isPresent()) {
			Musica musica = MusicaExiste.get();
			musica.setNombre(musicaActualizada.getNombre());
			musica.setAutor(musicaActualizada.getAutor());
			musica.setCalificacion(musicaActualizada.getCalificacion());
			return repoMusica.save(musica);
		}
		
		return null;
	}
	
	public List<Musica> BuscarPorAutor(String autor){
		return repoMusica.findByAutorContaining(autor);
	}
	
	public List<Musica> topTen(){
		return repoMusica.findTop10ByOrderByCalificacionDesc();
	}
}
