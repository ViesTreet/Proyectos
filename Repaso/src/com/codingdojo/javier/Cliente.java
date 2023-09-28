package com.codingdojo.javier;

public class Cliente {

	
	public void ejercicio(String texto) {
		System.out.println(texto);
	}
	public void ejercicio(String texto , int numero) {
		for(var i=0;i<numero;i++) {
			System.out.println(texto);
		}
	}
	
	public void ejercicio(String texto , int numero ,boolean urgente) {
		if(urgente) {
			texto = texto.toUpperCase();
			for(var i=0;i<numero;i++) {
				System.out.println(texto);
			}
		} else {
			for(var i=0;i<numero;i++) {
				texto = texto.toLowerCase();
				System.out.println(texto);
			}
		}
	}
}
