package com.codingdojo.javierulloa.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class ControladorBase {
	
	
	@GetMapping("/")
	public String home() {
		
		return "index.jsp";
	}
	
	@PostMapping("/encuesta")
	public String encuesta(@RequestParam(value="nombre")String nombre, @RequestParam(value="ubicacion")String ubicacion,@RequestParam(value="lenguajeP") String lenguaje,@RequestParam(value="comentario")String comentario,RedirectAttributes flash,HttpSession session) {
		
		if(nombre.isEmpty()||comentario.isEmpty()) {
			flash.addFlashAttribute("Error","Rellena todos los datos");
			return "redirect:/";
		}
		
		session.setAttribute("nombre", nombre);
		session.setAttribute("ubicacion", ubicacion);
		session.setAttribute("lenguaje", lenguaje);
		session.setAttribute("comentario", comentario);
		return "redirect:/result";
		
	}
	
	@GetMapping("/result")
	public String resultado(HttpSession session) {
		
		Object location = session.getAttribute("ubicacion");
		if(location==null) {
			return "redirect:/";
		}
		
		return "result.jsp";
		
	}
}
