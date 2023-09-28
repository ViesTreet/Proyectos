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
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.javierulloa.modelos.Libro;
import com.codingdojo.javierulloa.servicios.Servicios;

import jakarta.validation.Valid;



@Controller
public class ControladorBase {
	

	@Autowired
	private Servicios servicio;
	
	@GetMapping("/")
	public String index(Model model) {
		
		Libro libro1 = new Libro("1984","Una distopia clasica que explora un futuro totalitario en el que el gobierno controla todos los aspectos de la vida de las personas.","Ingles",328);
		Libro libro2 = new Libro("Cien anos de soledad","Una novela magica y realista que sigue a la familia Buendia a lo largo de varias generaciones en el ficticio pueblo de Macondo.","Espanol",448);
		Libro libro3 = new Libro("To Kill a Mockingbird","Una novela que aborda temas de justicia racial y moral a traves de los ojos de una nina en el sur de Estados Unidos.","Ingles",336);
		Libro libro4 = new Libro("El Principito","Un cuento filosofico y poetico que narra el viaje de un nino desde su asteroide hasta la Tierra, explorando temas como la amistad y el sentido de la vida.","Frances",96);
		Libro libro5 = new Libro("The Great Gatsby","Una novela que retrata la decadencia de la sociedad estadounidense en la decada de 1920, a traves de los ojos del misterioso Jay Gatsby.","Ingles",180);
		servicio.guardaLibro(libro1);
		servicio.guardaLibro(libro2);
		servicio.guardaLibro(libro3);
		servicio.guardaLibro(libro4);
		servicio.guardaLibro(libro5);
		List<Libro> libros = servicio.todosLibros();
		model.addAttribute("libros",libros);
		
		return "index.jsp";
	}
	
	@GetMapping("/mostrar/{id}")
	public String mostrar(@PathVariable("id")Long id,Model model) {
		
		Libro libroBuscado = servicio.buscarLibro(id);
		model.addAttribute("libroBuscado",libroBuscado);
		return "mostrar.jsp";
		
	}
	@DeleteMapping("/borrar/{id}")
	public String borrar(@PathVariable("id")Long id) {
		servicio.borrarLibro(id);
		return "redirect:/";
	}
	@GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Libro libro = servicio.buscarLibro(id);
        model.addAttribute("libro", libro);
        return "formulario.jsp";
    }
    
	@PutMapping("/libros/{id}")
	public String actualizarLibro(@PathVariable Long id, @Valid @ModelAttribute("libro") Libro libroActualizado, BindingResult result) {
	    if (result.hasErrors()) {
	        return "formulario.jsp";
	    } else {
	        servicio.editarLibro(id, libroActualizado);
	        return "redirect:/";
	    }
	}
}
