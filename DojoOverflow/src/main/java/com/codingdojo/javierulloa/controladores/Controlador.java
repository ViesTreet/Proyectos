package com.codingdojo.javierulloa.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.javierulloa.modelos.Etiqueta;
import com.codingdojo.javierulloa.modelos.Pregunta;
import com.codingdojo.javierulloa.modelos.Respuesta;
import com.codingdojo.javierulloa.servicios.Servicios;

import jakarta.validation.Valid;


@Controller
public class Controlador {
	
	@Autowired
	private Servicios servicio;

	@GetMapping("/")
	public String home() {
		return "redirect:/preguntas";
	}
	
	@GetMapping("/preguntas")
	public String preguntas(Model model) {
		
		List<Pregunta> preguntas = servicio.todasLasPreguntas();
		model.addAttribute("preguntas", preguntas);
		return "preguntas.jsp";
	}
	
	@GetMapping("/preguntas/nueva")
	public String crearPregunta(@ModelAttribute("pregunta")Pregunta pregunta) {
		return "nueva.jsp";
	}
	
	@PostMapping("/nuevo")
	public String crear(@Valid @ModelAttribute("pregunta")Pregunta pregunta,BindingResult result,Model model,@RequestParam("textoEtiquetas")String textoEtiquetas) {
		if(result.hasErrors()) {
			List<Pregunta> preguntas = servicio.todasLasPreguntas();
			model.addAttribute("preguntas", preguntas);
			return "preguntas.jsp";
		} else {
			String[] listaEtiquetas=textoEtiquetas.trim().split(",");
			List <Etiqueta> etiquetas = new ArrayList<>();
			for(String tema : listaEtiquetas) {
				tema = tema.trim();
				Etiqueta verificarEtiqueta = servicio.buscarEtiquetaPorTema(tema);
				if(verificarEtiqueta == null) {
					Etiqueta nuevaEtiqueta = new Etiqueta ();
					nuevaEtiqueta.setTema(tema);
					servicio.guardarEtiqueta(nuevaEtiqueta);
					etiquetas.add(nuevaEtiqueta);
				} else {
					etiquetas.add(verificarEtiqueta);
				}
			}
			pregunta.setEtiquetas(etiquetas);
			servicio.guardarPregunta(pregunta);
			return "redirect:/preguntas";
		}
	}
	
	@GetMapping("/preguntas/{id}")
	public String pregunta(@PathVariable("id")Long id,Model model,@ModelAttribute("crearRespuesta")Respuesta respuesta) {
		Pregunta pregunta = servicio.buscarPreguntaPorId(id);
		model.addAttribute("pregunta",pregunta);
		return "pregunta.jsp";
	}
	
	@PostMapping("/crear")
	public String crearRespuesta(@Valid @RequestParam("pregunta")Long id,Model model,@ModelAttribute("crearRespuesta")Respuesta respuesta,BindingResult result) {
		if(result.hasErrors()) {
			Pregunta pregunta = servicio.buscarPreguntaPorId(id);
			model.addAttribute("pregunta",pregunta);
			return "pregunta.jsp";
		} else {
			servicio.guardarRespuesta(respuesta);
			return "redirect:/preguntas/"+id;
		}
	}
}
