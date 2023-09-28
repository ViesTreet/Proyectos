package com.codingdojo.javierulloa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.javierulloa.modelos.Contacto;
import com.codingdojo.javierulloa.modelos.Estudiante;
import com.codingdojo.javierulloa.repositorios.repositoriosContactos;
import com.codingdojo.javierulloa.repositorios.repositoriosEstudiantes;

@Service
public class Servicios {
	
	@Autowired
	private repositoriosContactos repoContacto;
	
	@Autowired
	private repositoriosEstudiantes repoEstudiante;
	
	
	
	
	
	
	public List<Estudiante> todosEstudiantes(){  
		
		return repoEstudiante.findAll();
	}
	
	public List<Contacto> todosContatos(){
		
		return repoContacto.findAll();
	}
	
	public Estudiante estudiantePorId(Long id) {
		
		return repoEstudiante.findById(id).orElse(null);
	}
	
	public Contacto contactoPorId(Long id) {
		
		return repoContacto.findById(id).orElse(null);
	}
	
	public Estudiante guardarEstudiante(Estudiante nuevoEstudiante) {
		
		return repoEstudiante.save(nuevoEstudiante);
	}
	
	public Contacto guardarContacto(Contacto nuevoContacto) {
		
		return repoContacto.save(nuevoContacto);
	}
	
	public List<Estudiante> estudiantesSinContacto(){
		
		return repoEstudiante.findByContactoIdIsNull();
	}
	
	public void CrearEstudiante(String nombre,String apellido,int edad) {
		Estudiante estudianteNuevo = new Estudiante();
		estudianteNuevo.setNombre(nombre);
		estudianteNuevo.setApellido(apellido);
		estudianteNuevo.setEdad(edad);
		repoEstudiante.save(estudianteNuevo);
	}
	
	public void CrearContacto(Long estudianteId,String direccion,String ciudad,String region) {
		Contacto nuevoContacto = new Contacto();
		Estudiante estudianteBuscado = repoEstudiante.findById(estudianteId).orElse(null);
		nuevoContacto.setEstudiante(estudianteBuscado);
		nuevoContacto.setDireccion(direccion);
		nuevoContacto.setCiudad(ciudad);
		nuevoContacto.setRegion(region);
		repoContacto.save(nuevoContacto);
	}
}
