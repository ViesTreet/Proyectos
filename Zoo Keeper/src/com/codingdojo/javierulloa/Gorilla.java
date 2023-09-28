package com.codingdojo.javierulloa;

public class Gorilla extends Mammal{

	Mammal Gorilla1 = new Mammal(100);
	
	public void throwSomething(){
		System.out.println("Gorilla throw something!! ");
		Gorilla1.setEnergyLevel(Gorilla1.getEnergyLevel()-5);
		System.out.println("The energy of gorilla is: "+ Gorilla1.getEnergyLevel());
	}
	
	public void  eatBananas(){
		System.out.println("Gorilla eat bananas!! ");
		Gorilla1.setEnergyLevel(Gorilla1.getEnergyLevel()+10);
		System.out.println("The energy of gorilla is: "+ Gorilla1.getEnergyLevel());
	}
	
	public void  climb(){
		System.out.println("Gorilla climb!! ");
		Gorilla1.setEnergyLevel(Gorilla1.getEnergyLevel()-10);
		System.out.println("The energy of gorilla is: "+ Gorilla1.getEnergyLevel());
	}
}
