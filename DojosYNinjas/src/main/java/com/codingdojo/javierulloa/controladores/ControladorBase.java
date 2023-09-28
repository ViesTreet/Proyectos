package com.codingdojo.javierulloa.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.codingdojo.javierulloa.modelos.Dojo;
import com.codingdojo.javierulloa.modelos.Ninja;
import com.codingdojo.javierulloa.servicios.Servicios;

import jakarta.validation.Valid;

@Controller
public class ControladorBase {

	@Autowired
	private Servicios servicio;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Dojo> todosLosDojos = servicio.todosLosDojos();
		model.addAttribute("Dojos",todosLosDojos);
		return "index.jsp";
	}
	
	@GetMapping("/dojo")
	public String Dojo(@ModelAttribute("nuevoDojo")Dojo nuevoDojo) {
		
		return "dojo.jsp";
	}
	
	@PostMapping("/dojo")
	public String crearDojo(@Valid @ModelAttribute("nuevoDojo")Dojo nuevoDojo,BindingResult result) {
		
		if(result.hasErrors()) {
			return "dojo.jsp";
		} else {
			servicio.guardarDojo(nuevoDojo);
			return "redirect:/";
		}
	}
	
	@GetMapping("/ninja")
	public String Ninja(@ModelAttribute("nuevoNinja")Ninja nuevoNinja,Model model) {
		List<Dojo> todosLosDojos = servicio.todosLosDojos();
		model.addAttribute("Dojos",todosLosDojos);
		return "ninja.jsp";
	}
	
	@PostMapping("/ninja")
	public String crearNinja(@Valid @ModelAttribute("nuevoNinja")Ninja nuevoNinja,BindingResult result) {
		
		if(result.hasErrors()) {
			return "ninja.jsp";
		} else {
			servicio.guardarNinja(nuevoNinja);
			return "redirect:/";
		}
	}
	
	@GetMapping("/dojo/{id}")
	public String dashboard(Model model,@PathVariable("id")Long id) {
		Dojo dojoBuscado = servicio.dojoPorId(id);
		model.addAttribute("DojoBuscado",dojoBuscado);
		return "dashboard.jsp";
	}
	
}
