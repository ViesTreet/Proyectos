package com.codingdojo.javierulloa;

public class Bat extends Animal{
	
	
	Animal bat1 = new Animal(300);
	
	public void fly() {
		System.out.println("whoosh");
		bat1.setEnergyLevel(bat1.getEnergyLevel()-50);
		System.out.println("The energy of the bat is: "+bat1.getEnergyLevel());
		
	}
	public void eatHumans(){
		System.out.println("bueno, no importa");
		bat1.setEnergyLevel(bat1.getEnergyLevel()+25);
		System.out.println("The energy of the bat is: "+bat1.getEnergyLevel());
		
	}
	public void attackTown(){
		System.out.println("Boom! Crack! Bang!");
		bat1.setEnergyLevel(bat1.getEnergyLevel()-100);
		System.out.println("The energy of the bat is: "+bat1.getEnergyLevel());
		
	}

}
