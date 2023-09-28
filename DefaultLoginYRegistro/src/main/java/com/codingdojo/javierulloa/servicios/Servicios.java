package com.codingdojo.javierulloa.servicios;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.javierulloa.modelos.Usuario;
import com.codingdojo.javierulloa.repositorios.RepositorioUsuarios;

@Service
public class Servicios {

	@Autowired
	private RepositorioUsuarios repoUsuario;
	
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
}
