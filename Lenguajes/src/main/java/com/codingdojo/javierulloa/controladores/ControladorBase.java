package com.codingdojo.javierulloa.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.javierulloa.modelos.Lenguaje;
import com.codingdojo.javierulloa.servicios.Servicios;

import jakarta.validation.Valid;

@Controller
public class ControladorBase {

	
	@Autowired
	private Servicios servicio;
	
	@GetMapping("")
	public String index() {
		return"redirect:/languages";
	}
	
	@GetMapping("/languages")
	public String home(Model model, @ModelAttribute("lenguaje")Lenguaje lenguaje) {
		
		List<Lenguaje> lenguajes = servicio.todosLenguajes();
		model.addAttribute("lenguajes",lenguajes);
		return "home.jsp";
	}
	
	@PostMapping("/languages")
	public String crear(@Valid @ModelAttribute("lenguaje")Lenguaje lenguaje,BindingResult result ) {
		if(result.hasErrors()) {
			return "home.jsp";
		}else {
			servicio.guardaLenguajes(lenguaje);
			return "redirect:/languages";
		}
	}
	
	@DeleteMapping("/languages/{id}")
	public String eliminar(@PathVariable("id")Long id) {
		
		servicio.borrarLenguaje(id);
		return "redirect:/languages";
	
	}
	
	@GetMapping("/languages/{id}")
	public String detalles(@PathVariable("id")Long id,Model model ,@ModelAttribute("lenguaje")Lenguaje lenguaje ) {
		
		Lenguaje lenguajeBuscado=servicio.buscarLenguaje(id);
		model.addAttribute("lenguaje",lenguajeBuscado);
		return "detalles.jsp";
		
	}
	
	@GetMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		
		Lenguaje lenguaje=servicio.buscarLenguaje(id);
		model.addAttribute("lenguaje",lenguaje);
		return "edit.jsp";
	}
	
	@PutMapping("/languages/{id}")
	public String formularioEdicion(@Valid @PathVariable("id")Long id,@ModelAttribute("lenguaje")Lenguaje lenguajeEditado ,BindingResult result) {
		if (result.hasErrors()) {
	        return "edit.jsp";
	    } else {
	        servicio.editarLenguaje(id, lenguajeEditado);
	        return "redirect:/languages";
	    }
		
	}
	
	
	
}