package com.codingdojo.javierulloa;

public class HumanTest{


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ninja Juan = new Ninja("Juan");
		Ninja Fer = new Ninja("Fer");
		Samurai Pedro = new Samurai("Pedro");
		Samurai Lautaro = new Samurai("Pedro");
		Samurai Pepe = new Samurai("Pedro");
		Wizard Gandalf = new Wizard("Gandalf");
		
		Juan.steal(Pedro);
		Lautaro.deathBlow(Fer);
		Pepe.meditate();
		Gandalf.heal(Lautaro);
		Gandalf.fireBall(Juan);
		Juan.runAway();
		

	}

}
