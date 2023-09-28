package com.codingdojo.javierulloa;

public class Ninja extends Human{
	

	public Ninja(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
		this.stealth = 10;
	}
	
	public void steal(Human human) {
		human.health -= this.stealth;
		this.health += this.stealth;
		System.out.println(this.nombre+" robo la vida de "+human.nombre+" lo dejo a: "+human.health);
		System.out.println("Salud de "+this.nombre+" es: "+this.health);
	}
	
	public void runAway(){
		this.health -=10;
		System.out.println(this.nombre+" huyo y perdio vida , su vida actual es:  "+this.health);
	}
	
}
