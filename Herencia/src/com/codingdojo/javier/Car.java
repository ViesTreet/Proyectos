package com.codingdojo.javier;

public class Car extends Vehicle {
	
	private String licensePlate;

	public Car(int year, String brand, String model, int wheels, String licensePlate) {
		super(year, brand, model, wheels);
		this.licensePlate = licensePlate;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
	public String toString() {
		return super.toString()+"[licensePlate=" + licensePlate + "]";
	}
	
	public void acelerar() {
		System.out.println("estoy acelerando");
		this.speed +=2;
		System.out.println("mi velocidad es: "+this.speed);
	}
	
	public void desacelerar() {
		System.out.println("estoy desacelerando");
		this.speed -=2;
		System.out.println("mi velocidad es: "+this.speed);
	}
	
	
	

}
