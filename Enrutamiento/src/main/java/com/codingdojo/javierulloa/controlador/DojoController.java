package com.codingdojo.javierulloa.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	
	
	@GetMapping("/{variable}")
	public String dojo(@PathVariable("variable")String var) {
		
		if("dojo".equals(var)) {
		return "el "+var+" es increíble!";
		}
		
		else if("burbank-dojo".equals(var)) {
			return "El Dojo Burbank está localizado al sur de California";
		}
		
		else if ("san-jose".equals(var)) {
			return "El Dojo SJ es el cuartel general";
		}
		else {
		return "<h1>elija /dojo , /burbank-dojo o /san-jose</h1>";
		}
	}
	
	

}
