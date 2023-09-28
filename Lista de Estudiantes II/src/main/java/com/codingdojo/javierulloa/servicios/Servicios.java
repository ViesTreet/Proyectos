package com.codingdojo.javierulloa.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.javierulloa.modelos.Dormitorio;
import com.codingdojo.javierulloa.modelos.Estudiante;
import com.codingdojo.javierulloa.repositorios.RepositorioDormitorios;
import com.codingdojo.javierulloa.repositorios.RepositorioEstudiantes;

@Service
public class Servicios {

	@Autowired
	private RepositorioEstudiantes repoEstudiante;
	
	@Autowired
	private RepositorioDormitorios repoDormitorio;
	
	private List<Estudiante> nuevaListaEstudiante;
	
	public List<Dormitorio> todosLosDormitorios(){
		return repoDormitorio.findAll();
	}
	
	public List<Estudiante> todosLosEstudiantes(){
		return repoEstudiante.findAll();
	}
	
	public Dormitorio dormitorioPorId(Long id) {
		return repoDormitorio.findById(id).orElse(null);
	}
	
	public Estudiante estudiantePorId(Long id) {
		return repoEstudiante.findById(id).orElse(null);
	}
	
	public List<Estudiante> estudianteSinDormitorio(){
		return repoEstudiante.findByDormitorioIdIsNull();
	}
	
	public void eliminarEstudianteDeDormitorio(Long estudianteId , Long dormitorioId) {
		Optional<Estudiante> existeEstudiante = repoEstudiante.findById(estudianteId);
		Optional<Dormitorio> existeDormitorio = repoDormitorio.findById(dormitorioId);
		
		if(existeEstudiante.isPresent()&& existeDormitorio.isPresent()) {
			Estudiante estudiante = existeEstudiante.get();
			Dormitorio dormitorio = existeDormitorio.get();
			
			estudiante.setDormitorio(null);
			dormitorio.getEstudiantes().remove(estudiante);
			
			repoEstudiante.save(estudiante);
			repoDormitorio.save(dormitorio);
		} else {
			return;
		}
	}
	
	public Dormitorio guardarDormitorio(Dormitorio nuevoDormitorio) {
		return repoDormitorio.save(nuevoDormitorio);
	}
	
	public Estudiante guardarEstudiante(Estudiante nuevoEstudiante) {
		return repoEstudiante.save(nuevoEstudiante);
	}
	
	public Estudiante crearEstudianteAPI(String nombre) {
		Estudiante nuevoEstudiante = new Estudiante(nombre);
		return repoEstudiante.save(nuevoEstudiante);
	}
	
	public void asignarEstudianteADormitorio(Long idDormitorio,Long idEstudiante) {
		Optional<Estudiante> existeEstudiante = repoEstudiante.findById(idEstudiante);
		Optional<Dormitorio> existeDormitorio = repoDormitorio.findById(idDormitorio);
		
		if(existeEstudiante.isPresent()&& existeDormitorio.isPresent()) {
			Estudiante estudiante = existeEstudiante.get();
			Dormitorio dormitorio = existeDormitorio.get();
			
			estudiante.setDormitorio(dormitorio);
			repoEstudiante.save(estudiante);
		} else {
			return;
		}
	}
	
	public List<Estudiante> estudiantesEnDormitorio(Long id) {
		Optional<Dormitorio> existeDormitorio = repoDormitorio.findById(id);
		if(existeDormitorio.isPresent()) {
			Dormitorio dormitorio = existeDormitorio.get();
			List<Estudiante> estudiantesDormitorio = dormitorio.getEstudiantes();
			return estudiantesDormitorio;	
		} else {
			return null;
		}
			
	}
	
}
