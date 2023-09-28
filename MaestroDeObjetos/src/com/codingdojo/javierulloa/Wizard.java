package com.codingdojo.javierulloa;

public class Wizard extends Human{
	
	
	
	
	public void heal(Human human) {
		human.health += this.intelligence;
		System.out.println(this.nombre + " curo a "+human.nombre+" su vida es: "+human.health);
	}
	
	
	public void  fireBall(Human human) {
		human.health -= this.intelligence*3;
		System.out.println(this.nombre+ " Tiro una bola de fuego , ataco a "+human.nombre+"su vida es: "+human.health);
	}
	
	
	
	

	public Wizard(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
		this.health = 50;
		this.intelligence=8;
	}
	
}
