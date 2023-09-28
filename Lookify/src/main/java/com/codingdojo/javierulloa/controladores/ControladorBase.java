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
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.javierulloa.modelos.Musica;
import com.codingdojo.javierulloa.servicios.Servicios;

import jakarta.validation.Valid;

@Controller
public class ControladorBase {

	
	@Autowired
	private Servicios servicio;
	
	
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		
		List<Musica> musicas = servicio.todoMusica();
		model.addAttribute("musica",musicas);
		return "dashboard.jsp";
	}
	
	@DeleteMapping("/borrar/{id}")
	public String borrar(@PathVariable("id")Long id) {
		servicio.eliminarMusica(id);
		return "redirect:/dashboard";
	}
	
	@PostMapping("/search")
	public String buscar(@RequestParam("autor")String autor) {
		
		return "redirect:/search/"+autor;
	}
	
	
	@GetMapping("/search/{autor}")
	public String busqueda(@PathVariable("autor")String autor,Model model) {
		List<Musica> musicaBuscada = servicio.BuscarPorAutor(autor);
		model.addAttribute("musica",musicaBuscada);
		model.addAttribute("palabra",autor);
		return "musicaBuscar.jsp";
		
	}
	
	
	@GetMapping("/songs/new")
	public String nuevo(@ModelAttribute("cancion")Musica nuevaMusica) {
		return "nuevo.jsp";
	}
	
	@PostMapping("/nuevo")
	public String crear(@Valid @ModelAttribute("cancion")Musica nuevaMusica,BindingResult result ) {
		
		if(result.hasErrors()) {
			return "nuevo.jsp";
		} else {
			servicio.guardarMusica(nuevaMusica);
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/songs/{id}")
	public String mostrar(@PathVariable("id")Long id, Model model) {
		Musica musicaBuscada = servicio.MusicaId(id);
		model.addAttribute("musica",musicaBuscada);
		return "mostrar.jsp";
	}
	
	@GetMapping("/search/topTen")
	public String topTen(Model model) {
		
		List<Musica> topTen = servicio.topTen();
		model.addAttribute("top10",topTen);
		return "topTen.jsp";
	}
}
