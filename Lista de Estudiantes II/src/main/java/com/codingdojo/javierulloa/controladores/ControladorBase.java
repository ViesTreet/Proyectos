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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.javierulloa.modelos.Dormitorio;
import com.codingdojo.javierulloa.modelos.Estudiante;
import com.codingdojo.javierulloa.servicios.Servicios;

import jakarta.validation.Valid;

@Controller
public class ControladorBase {

	@Autowired
	private Servicios servicio;
	
	@GetMapping("/")
	public String redireccion() {
		return "redirect:/dormitorio";
	}
	
	@GetMapping("/dormitorio")
	public String dormitorio(@ModelAttribute("nuevoDormitorio")Dormitorio dormitorio) {
		return "nuevoDormitorio.jsp";
	}
	
	@PostMapping("/dormitorio")
	public String crearDormitorio(@Valid @ModelAttribute("nuevoDormitorio")Dormitorio dormitorio,BindingResult result) {
		if(result.hasErrors()) {
			return "nuevoDormitorio.jsp";
		} else {
			servicio.guardarDormitorio(dormitorio);
			return "redirect:/dormitorio/"+dormitorio.getId();
		}
	}
	
	@GetMapping("/estudiante/crear")
	public String crearEstudianteAPI(@RequestParam("nombre")String nombre) {
		servicio.crearEstudianteAPI(nombre);
		return "redirect:/dormitorio";
	}
	
	@GetMapping("/dormitorio/{id}")
	public String dashboardDormitorio(@PathVariable("id")Long Id,Model model) {
		
		Dormitorio dormitorioBuscado = servicio.dormitorioPorId(Id);
		model.addAttribute("dormitorios",dormitorioBuscado);
		
		List<Estudiante> listaDeEstudiante = servicio.estudianteSinDormitorio();
		model.addAttribute("estudiantes",listaDeEstudiante);
		
		List<Estudiante> estudianteEnEsteDormitorio = servicio.estudiantesEnDormitorio(Id);
		model.addAttribute("estudianteEnEsteDormitorio",estudianteEnEsteDormitorio);
		return "dashboard.jsp";
	}
	
	@PutMapping("/asignar")
	public String asignar(@RequestParam("DormitorioID")Long IdDormitorio,Model model,@RequestParam("estudianteID")Long IdEstudiante) {
		servicio.asignarEstudianteADormitorio(IdDormitorio, IdEstudiante);
		return "redirect:/dormitorio/"+IdDormitorio;
	}
	
	@PutMapping("/quitarDelRoom")
	public String Sacar(@RequestParam("DormiID")Long IdDormitorio,Model model,@RequestParam("EstuId")Long IdEstudiante) {
		servicio.eliminarEstudianteDeDormitorio(IdEstudiante, IdDormitorio);
		return "redirect:/dormitorio/"+IdDormitorio;
	}
}
