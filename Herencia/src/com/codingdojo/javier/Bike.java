package com.codingdojo.javier;

public class Bike extends Vehicle{
	
	public void acelerar() {
		System.out.println("estoy pedealandio");
		this.speed +=2;
		System.out.println("mi velocidad es: "+this.speed);
	}
	
	public void desacelerar() {
		System.out.println("estoy frenando");
		this.speed -=2;
		System.out.println("mi velocidad es: "+this.speed);
	}

	public Bike(int year, String brand, String model, int wheels) {
		super(year, brand, model, wheels);
		// TODO Auto-generated constructor stub
	}
	
	
}
