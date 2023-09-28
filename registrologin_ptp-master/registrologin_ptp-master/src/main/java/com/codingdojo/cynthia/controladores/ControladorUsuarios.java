package com.codingdojo.cynthia.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.servicios.Servicios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuarios {
	
	@Autowired
	private Servicios servicio;
	
	@GetMapping("/")
	public String index(@ModelAttribute("nuevoUsuario") Usuario nuevoUsuario) {
		return "index.jsp";
	}
	
	@PostMapping("/registro")
	public String registro(@Valid @ModelAttribute("nuevoUsuario") Usuario nuevoUsuario,BindingResult result,HttpSession session) {
		
		servicio.registrar(nuevoUsuario, result);
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			session.setAttribute("UsuarioEnSesion", nuevoUsuario);
			return "redirect:/dashboard";
		}
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email")String email,@RequestParam("password")String password,HttpSession session,RedirectAttributes redirectAttributes ) {
		
		Usuario usuarioLogin = servicio.Login(email, password);
		if(usuarioLogin == null) {
			redirectAttributes.addFlashAttribute("error_login", "el correo/password es incorrecto");
			return "redirect:/";
		} else {
			session.setAttribute("UsuarioEnSesion", usuarioLogin);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session,Model model) {
		
		Usuario usuarioTemporal = (Usuario)session.getAttribute("UsuarioEnSesion");
		if(usuarioTemporal==null) {
			return "redirect:/";
		}else {
			model.addAttribute("usuarioTemporal",usuarioTemporal);
			return "dashboard.jsp";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("UsuarioEnSesion");
		return "redirect:/";
	}
	
}
