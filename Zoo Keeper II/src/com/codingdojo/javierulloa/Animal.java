package com.codingdojo.javierulloa;

public class Animal {
	protected int energyLevel;

	public Animal() {
	}

	public Animal(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

	@Override
	public String toString() {
		return "Animal [energyLevel=" + energyLevel + "]";
	}
	
}
