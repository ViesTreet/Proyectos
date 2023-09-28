package com.codingdojo.javierulloa.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.javierulloa.modelos.Contacto;
import com.codingdojo.javierulloa.modelos.Estudiante;
import com.codingdojo.javierulloa.servicios.Servicios;

import jakarta.validation.Valid;

@Controller
public class ControladorBase {
	
	
	@Autowired
	private Servicios servicio;
	
	
	@GetMapping("/")
	public String redireccion() {          //Para redireccionar a dashboard
		
		return "redirect:/students";
	}
	
	@GetMapping("/students")
	public String Estudiantes(Model model) {
		
		List<Estudiante> estudiantes = servicio.todosEstudiantes();
		model.addAttribute("estudiantes",estudiantes);
		
		return "estudiantes.jsp";
	}
	
	@GetMapping("/students/new")
	public String nuevoEstudiante() {
		
		return "nuevo.jsp";
	}
	
	
	@PostMapping("/students/new")
	public String nuevo(@RequestParam("nombre")String nombre ,@RequestParam("apellido")String apellido,@RequestParam("edad")int edad) {
		
		servicio.CrearEstudiante(nombre, apellido, edad);
		return "redirect:/students";
	}
	
	
	 @GetMapping("/students/create")
	    public String APICrearEstudiante(@RequestParam("nombre") String nombre,
	                                @RequestParam("apellido") String apellido,
	                                @RequestParam("edad") int edad) {
	        servicio.CrearEstudiante(nombre, apellido, edad);
	        return "redirect:/students";
	}
	 
	 
	 @GetMapping("/contact/new")
		public String nuevoContacto(Model model , @ModelAttribute("nuevoContacto")Contacto contacto) {
		 
		 List<Estudiante> estudianteSinContacto = servicio.estudiantesSinContacto();
		 model.addAttribute("estudiantes",estudianteSinContacto);
			
			return "nuevoContacto.jsp";
		}
	 
	 @PostMapping("/contact/new")
	 public String guardarContacto(@Valid @ModelAttribute("nuevoContacto")Contacto contacto,BindingResult result,Model model ) {
		 
		 if(result.hasErrors()) {
			 List<Estudiante> estudianteSinContacto = servicio.estudiantesSinContacto();
			 model.addAttribute("estudiantes",estudianteSinContacto);
				
			return "nuevoContacto.jsp";
		 } else {
			 servicio.guardarContacto(contacto);
			 return "redirect:/students";
		 }
	 }
	 
	 @GetMapping("/contacts/create")
	    public String APICrearContacto(@RequestParam("estudianteID") Long estudianteId,
	                                @RequestParam("direccion") String direccion,
	                                @RequestParam("ciudad") String ciudad,
	                                @RequestParam("region") String region) {
	        servicio.CrearContacto(estudianteId, direccion, ciudad, region);
	        return "redirect:/students"; // Redirige a la página deseada después de crear el contacto
	    }
	 
}
