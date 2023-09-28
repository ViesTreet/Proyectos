package com.codingdojo.javierulloa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.javierulloa.modelos.Etiqueta;
import com.codingdojo.javierulloa.modelos.Pregunta;
import com.codingdojo.javierulloa.modelos.Respuesta;
import com.codingdojo.javierulloa.repositorios.repositorioEtiquetas;
import com.codingdojo.javierulloa.repositorios.repositorioPreguntas;
import com.codingdojo.javierulloa.repositorios.repositorioRespuestas;

@Service
public class Servicios {
	
	@Autowired
	private repositorioEtiquetas repoEtiqueta;
	
	@Autowired
	private repositorioPreguntas repoPregunta;
	
	@Autowired
	private repositorioRespuestas repoRespuesta;
	
	
	
	public List<Pregunta> todasLasPreguntas(){
		
		return repoPregunta.findAll();
	}
	
	public Pregunta guardarPregunta(Pregunta nuevaPregunta) {
		
		return repoPregunta.save(nuevaPregunta);
	}
	
	public Respuesta guardarRespuesta(Respuesta nuevaRespuesta) {
		
		return repoRespuesta.save(nuevaRespuesta);
	}
	
	public Etiqueta buscarEtiquetaPorTema(String tema) {
		
		return repoEtiqueta.findByTema(tema);
	}
	
	public Etiqueta guardarEtiqueta(Etiqueta nuevaEtiqueta) {
		
		return repoEtiqueta.save(nuevaEtiqueta);
	}
	
	public Pregunta buscarPreguntaPorId(Long id) {
		
		return repoPregunta.findById(id).orElse(null);
	}
}
