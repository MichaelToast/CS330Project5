package mu.edu.main;

import java.util.ArrayList;

import mu.edu.pet.Cat;
import mu.edu.pet.ExoticAnimal;
import mu.edu.pet.ExoticAnimalAdapter;
import mu.edu.pet.Pet;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello There!");
		
		ArrayList<Pet> animals = new ArrayList<>();
		ExoticAnimal Steve = new ExoticAnimal("exo001", "Steve", "Bear", "Black", 80);
		Cat Carl = new Cat("123", "Fiend", "Blue", 20);
		Pet StevePet = new ExoticAnimalAdapter(Steve);
		System.out.println(StevePet.isAdopted());
		
		animals.add(Carl);
		animals.add(StevePet);
		
		for (Pet creature : animals) {
			System.out.println(creature);
		}
		
		StevePet.setAdopted(true);
		System.out.println(StevePet.isAdopted());
		
	}

}
