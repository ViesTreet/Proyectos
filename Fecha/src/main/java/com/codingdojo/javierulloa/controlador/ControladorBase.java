package com.codingdojo.javierulloa.controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorBase {
	
	
	
	@GetMapping("/home")
	public String home() {
		
		return "home.jsp";
	}
	
	@GetMapping("/date")
	public String fecha(Model model) {
		
		Date fecha = new java.util.Date();
		SimpleDateFormat formato = new SimpleDateFormat("EEEE, d 'de' MMMM, yyyy", new Locale("es", "ES"));
        String formatoFinal = formato.format(fecha);
		model.addAttribute("fecha",formatoFinal);
		
		return "fecha.jsp";
	}
	
	@GetMapping("/time")
	public String hora(Model model) {
		
		Date hora = new java.util.Date();
		SimpleDateFormat formato = new SimpleDateFormat("hh:mm a");
		String horaFinal = formato.format(hora);
		model.addAttribute("hora",horaFinal);
		
		return "hora.jsp";
	}

}
