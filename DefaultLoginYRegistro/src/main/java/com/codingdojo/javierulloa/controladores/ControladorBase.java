package com.codingdojo.javierulloa.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.javierulloa.modelos.Usuario;
import com.codingdojo.javierulloa.servicios.Servicios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorBase {

	@Autowired
	private Servicios servicio;
	
	@GetMapping("/")
	public String home(@ModelAttribute("registro")Usuario usuario) {
		
		return "home.jsp";
	}
	
	@PostMapping("/registro")
	public String registro(@Valid @ModelAttribute("registro")Usuario usuario,BindingResult result,HttpSession session) {
		servicio.registrar(usuario, result);
		if(result.hasErrors()) {
			return "home.jsp";
		} else {
			session.setAttribute("usuarioEnSesion", usuario);
			return "redirect:/dashboard";
		}
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("loginEmail")String email,@RequestParam("loginContrasena")String contrasena,RedirectAttributes redirectAttributes,HttpSession session) {
		Usuario usuarioInicioSesion = servicio.login(email, contrasena);
		if(usuarioInicioSesion == null) {
			redirectAttributes.addFlashAttribute("error_login", "El correo/contraseña es incorrecto");
			return "redirect:/";
		} else {
			session.setAttribute("usuarioEnSesion", usuarioInicioSesion);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session) {
		
		if(session.getAttribute("usuarioEnSesion")==null) {
			return "redirect:/";
		} else {
			return "dashboard.jsp"; 
		}
	}
	
}
