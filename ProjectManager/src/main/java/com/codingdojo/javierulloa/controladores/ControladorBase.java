package com.codingdojo.javierulloa.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.javierulloa.modelos.Proyecto;
import com.codingdojo.javierulloa.modelos.Usuario;
import com.codingdojo.javierulloa.servicios.Servicios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorBase {
	
	@Autowired
	private Servicios servicio;
	
	
	
	@GetMapping("/")
	public String Home(@ModelAttribute("registro")Usuario nuevoUsuario) {
		
		return "home.jsp";
	}
	
	@PostMapping("/registro")
	public String registro(@Valid @ModelAttribute("registro")Usuario nuevoUsuario,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			return "home.jsp";
		} else {
			servicio.registrarNuevoUsuario(nuevoUsuario, result);
			session.setAttribute("usuarioEnSesion", nuevoUsuario);
			return "redirect:/dashboard";
		}
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email")String email ,@RequestParam("contrasena")String contrasena,RedirectAttributes redirectAttribute,HttpSession session) {
		Usuario usuario = servicio.login(email, contrasena);
		if (usuario == null) {
			redirectAttribute.addFlashAttribute("error_login", "la contraseña/email es incorrecto");
			return "redirect:/";
		} else {
			session.setAttribute("usuarioEnSesion", usuario);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session,Model model) {
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		
		model.addAttribute("misProyectos",servicio.misProyectos(usuarioTemporal));
		model.addAttribute("otrosProyectos",servicio.otrosProyectos(usuarioTemporal));
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/crear")
	public String crearProyecto(@ModelAttribute("creaProyecto")Proyecto nuevoProyecto,HttpSession session) {
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		
		return "crearProyecto.jsp";
	}
	
	@PostMapping("/crearP")
	public String crear(@Valid @ModelAttribute("creaProyecto")Proyecto nuevoProyecto,BindingResult result,HttpSession session) {
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			return "crearProyecto.jsp";
		} else {
			servicio.guardarProyecto(nuevoProyecto);
			Usuario usuario = servicio.UsuarioPorId(usuarioTemporal.getId());
			usuario.getProyectoUnidos().add(nuevoProyecto);
			servicio.guardarUsuario(usuario);
			return "redirect:/dashboard";
		}
	}
}
