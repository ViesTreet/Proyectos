package com.codingdojo.javierulloa;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages = "com.codingdojo.javierulloa")
@RestController
public class ProjectUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectUsuarioApplication.class, args);
		
		
		
		
		
		
	}
	@GetMapping("/hola")
	public String Home() {
		
		return "hola mundo";
	}
	
	@GetMapping("/vacaciones/{lugar}/{dia}/{persona}")
	public String vacaciones(@PathVariable("lugar") String lugar,@PathVariable("dia") String dia,@PathVariable("persona") String persona){
		
		return "<h1>"+persona+" "+"viajará por el mundo y conocera "+lugar+" el "+dia+" de este mes"+"</h1>";
		
	}
	

}
