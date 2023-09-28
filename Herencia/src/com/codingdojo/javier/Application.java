package com.codingdojo.javier;


public class Application {

	public static void main(String[] args) {
		
		Vehicle boat=new Vehicle(2015,"boat123","modelBoat",0);
		System.out.println(boat);
		
		
		
		Car car1 = new Car(2020,"dodge","Charger",4,"ABC1234");
		
		System.out.println(car1);
		
		
		car1.acelerar();
		car1.acelerar();
		car1.desacelerar();
		
		Bike moto1 = new Bike(2012,"yamha","xt2",2);
		moto1.acelerar();
		moto1.acelerar();
	}

}
