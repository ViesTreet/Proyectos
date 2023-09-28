package com.codingdojo.javierulloa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorBase {
	
	@GetMapping("/")
	public String home() {
		return "Hola usuario";
	}
	
	@GetMapping("/random")
	public String random() {
		return "Hola usuario, estamos usando Spring";
	}


}
