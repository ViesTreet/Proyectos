package com.codingdojo.javierulloa;

public class Human {
	protected int strength=3;
	protected int stealth=3;
	protected int intelligence=3;
	protected int health=100;
	public String nombre;
	protected int cantidad=0;
	
	
	public Human(String nombre) {
		this.nombre = nombre;
	}




	public void attack(Human victima) {
		victima.health -= this.strength;
		System.out.println("Salud de "+victima.nombre+" es: "+victima.health);
	}
}
