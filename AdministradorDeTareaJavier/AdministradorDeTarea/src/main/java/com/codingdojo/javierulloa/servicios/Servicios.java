package com.codingdojo.javierulloa.servicios;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.javierulloa.modelos.Tarea;
import com.codingdojo.javierulloa.modelos.Usuario;
import com.codingdojo.javierulloa.repositorios.RepositorioTareas;
import com.codingdojo.javierulloa.repositorios.RepositorioUsuarios;

@Service
public class Servicios {

	@Autowired
	private RepositorioUsuarios repoUsuario;
	
	@Autowired
	private RepositorioTareas repoTarea;
	
	public Usuario registrar(Usuario nuevoUsuario, BindingResult result) {
		String contrasena = nuevoUsuario.getContrasena();
		String confirmacion = nuevoUsuario.getConfirmacion();
		if(!contrasena.equals(confirmacion)) {
			result.rejectValue("confirmacion", "Matches", "Las contraseñas no coinciden");
		}
		
		String email = nuevoUsuario.getEmail();
		Usuario existeUsuario = repoUsuario.findByEmail(email);
		if(existeUsuario != null) {
			result.rejectValue("email", "Unique", "El correo ingresado ya se encuentra registrado.");
		}
		
		if(result.hasErrors()) {
			return null;
		} else {
			String contraEncriptada = BCrypt.hashpw(contrasena, BCrypt.gensalt());
			nuevoUsuario.setContrasena(contraEncriptada);
			return repoUsuario.save(nuevoUsuario);
		}
		
	}
	
	public Usuario login(String email, String password) {
		Usuario usuarioInicioSesion = repoUsuario.findByEmail(email); 
		if(usuarioInicioSesion == null) {
			return null;
		}
		
		if(BCrypt.checkpw(password, usuarioInicioSesion.getContrasena())) {
			return usuarioInicioSesion;
		}
		return null;
	}
	
	public Tarea guardarTarea(Tarea nuevaTarea) {
		return repoTarea.save(nuevaTarea);
	}
	
	public Tarea EditarTarea(Long idTarea,String nombre,Long idCreador,Long idAsignado,int prioridad) {
		Optional<Tarea> tareaExiste = repoTarea.findById(idTarea);
		
		if(tareaExiste.isPresent()) {
			Tarea tarea = tareaExiste.get();
			
			tarea.setNombreTarea(nombre);
			tarea.setPrioridad(prioridad);
			
			Optional<Usuario> creadorExiste = repoUsuario.findById(idCreador);
			Optional<Usuario> asignadoExiste = repoUsuario.findById(idAsignado);
			
			if(creadorExiste.isPresent() && asignadoExiste.isPresent()) {
				
				Usuario creador = creadorExiste.get();
				Usuario asignado = asignadoExiste.get();
				
				tarea.setCreador(creador);
				tarea.setAsignado(asignado);
				
				Tarea tareaActualizada = repoTarea.save(tarea);
				
				return tareaActualizada;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public List<Tarea> todasLasTareas(){
		return repoTarea.findAll();
	}
	
	public List<Tarea> ordenarAsc(){
		return repoTarea.findAllByOrderByPrioridadAsc();
	}
	
	public List<Tarea> ordenarDesc(){
		return repoTarea.findAllByOrderByPrioridadDesc();
	}
	
	public Tarea tareaPorId(Long id) {
		return repoTarea.findById(id).orElse(null);
	}
	
	public List<Usuario> todosLosUsuario(){
		return repoUsuario.findAll();
	}
	
	public Tarea actualizarTarea(Long tareaId ,Long creadorId, String nombreTarea, Long asignadoId, int prioridad) {
		Tarea tarea = repoTarea.findById(tareaId).orElse(null);
		
		if(tarea != null) {
			tarea.setNombreTarea(nombreTarea);
			tarea.setCreador(repoUsuario.findById(creadorId).orElse(null));
			tarea.setAsignado(repoUsuario.findById(asignadoId).orElse(null));
			tarea.setPrioridad(prioridad);
			tarea.setId(tareaId);
			
			repoTarea.save(tarea);
			
			return tarea;
		} else {
			return null;
		}
		
	}
	
	public void eliminarTarea(Long id) {
		Optional<Tarea> tareaExiste = repoTarea.findById(id);
		
		if(tareaExiste.isPresent()) {
			
			Tarea tarea = tareaExiste.get();
			
			Usuario creador = tarea.getCreador();
			Usuario asignado = tarea.getAsignado();
			
			if(creador != null) {
				creador.getTareasCreadas().remove(tarea);
			}
			
			if(asignado != null) {
				asignado.getTareasAsignadas().remove(tarea);
			}
			
			repoTarea.deleteById(id);
		}
	}
}
