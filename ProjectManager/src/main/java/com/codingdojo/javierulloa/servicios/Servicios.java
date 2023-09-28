package com.codingdojo.javierulloa.servicios;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.javierulloa.modelos.Proyecto;
import com.codingdojo.javierulloa.modelos.Usuario;
import com.codingdojo.javierulloa.repositorios.RepositorioProyectos;
import com.codingdojo.javierulloa.repositorios.RepositorioUsuarios;

@Service
public class Servicios {

	@Autowired
	private RepositorioProyectos repoProyecto;
	
	@Autowired
	private RepositorioUsuarios repoUsuario;
	
	public Usuario registrarNuevoUsuario(Usuario nuevoUsuario,BindingResult result) {
		String Contrasena = nuevoUsuario.getContrasena();
		String Confirmacion = nuevoUsuario.getConfirmacion();
		
		if(!Contrasena.equals(Confirmacion)) {
			result.rejectValue("confirmacion", "Matches","Las contraseñas no coinciden");
		}
		
		String email = nuevoUsuario.getEmail();
		Usuario existeUsuario = repoUsuario.findByEmail(email);
		if(existeUsuario != null) {
			result.rejectValue("email", "Unique","El correo ingresado ya esta registrado");
		}
		
		if(result.hasErrors()) {
			return null;
		} else {
			String contraEncriptada = BCrypt.hashpw(Contrasena, BCrypt.gensalt());
			nuevoUsuario.setContrasena(contraEncriptada);
			return repoUsuario.save(nuevoUsuario);
		}
	}
	
	
	public Usuario login(String email,String contrasena) {
		
		Usuario usuarioSesion=repoUsuario.findByEmail(email);
		
		if(usuarioSesion == null) {
			return null;
		}
		
		if(BCrypt.checkpw(contrasena, usuarioSesion.getContrasena())){
			return usuarioSesion;
		} else {
			return null;
		}
	}
	
	public Proyecto guardarProyecto(Proyecto nuevoProyecto) {
		return repoProyecto.save(nuevoProyecto);
	}
	
	public Usuario UsuarioPorId(Long Id) {
		return repoUsuario.findById(Id).orElse(null);
	}
	
	public Usuario guardarUsuario(Usuario nuevoUsuario) {
		return repoUsuario.save(nuevoUsuario);
	}
	
	public List<Proyecto> misProyectos(Usuario usuarioEnSesion){
		return repoProyecto.findByUsuarioUnidosContains(usuarioEnSesion);
	}
	
	public List<Proyecto> otrosProyectos(Usuario usuarioEnSesion){
		return repoProyecto.findByUsuarioUnidosNotContains(usuarioEnSesion);
	}
	
	public Proyecto proyectoPorId(Long id) {
		return repoProyecto.findById(id).orElse(null);
	}
}
