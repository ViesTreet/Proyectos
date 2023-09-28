package com.codingdojo.javierulloa.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorBase {
	
	
	@GetMapping("")
	public String home() {
		
		return "<div><h1>Hola Humano</h1></div><div>Desde Spring</div>";
		
		
	}
	
	@GetMapping("/search")
	public String nombre(@RequestParam(value="q") String nombre) {
		
		return "<div><h1>Hola "+nombre+"</h1></div><div>Desde Spring</div>";
		
		
	}

}
