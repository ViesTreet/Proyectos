package com.codingdojo.javierulloa;

public class Samurai extends Human{
	
	public static int cantidad = 0;

	public Samurai(String nombre) {
		super(nombre);
		cantidad = cantidad+1;
		this.health=200;
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void deathBlow(Human human) {
		human.health = 0;
		this.health -= (this.health/2);
		System.out.println(this.nombre+" mato a "+human.nombre);
		System.out.println("al atacar perdio vida y quedo a "+this.health);
	}
	
	public void meditate(){
		this.health += (this.health/2);
		System.out.println(this.nombre+" medito y su vida actual es: "+this.health);
	}
	
	
	public static int howMany(){
		System.out.println("la cantidad es: "+Samurai.cantidad);
		return Samurai.cantidad;
	}
}
