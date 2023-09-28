package com.codingdojo.javierulloa;

public class Mammal {
	private int energyLevel;
	
	
	public Mammal() {
	}

	public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public void desiplayEnergy(String animal) {
		System.out.println("The energy level of this animal is "+this.energyLevel);
	}

	@Override
	public String toString() {
		return "Mammal [energyLevel=" + energyLevel + "]";
	}
	
	
}
