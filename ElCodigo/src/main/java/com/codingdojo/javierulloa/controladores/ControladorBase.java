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
	
	return "home.jsp";
	}
	
	@PostMapping("/password")
	public String password(@RequestParam(value="code")String code, RedirectAttributes flash, HttpSession session) {
		
		System.out.println(code);
		
		if(!code.equals("bushido")) {
			flash.addFlashAttribute("errorCodigo","Proporciona el codigo correcto");
			return "redirect:/";
		}
		
		session.setAttribute("contraseña", code);
	
	return "redirect:/code";
	}
	
	
	@GetMapping("/code")
	public String code(HttpSession session) {
		
		Object codigo = session.getAttribute("contraseña");
		if(codigo != null) {
			
			return "code.jsp";
		}
		else {
			return "redirect:/";
		}
		
	}

}
