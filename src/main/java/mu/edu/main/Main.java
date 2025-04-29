package mu.edu.main;

import java.util.ArrayList;

import mu.edu.pet.Cat;
import mu.edu.pet.ExoticAnimal;
import mu.edu.pet.Pet;
import mu.edu.pet.adaptor.ExoticAnimalAdapter;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello There!");
		
		ArrayList<Pet> animals = new ArrayList<>();
		ExoticAnimal Steve = new ExoticAnimal("exo001", "Steve", "Bear", "Black", 80);
		Cat Carl = new Cat("123", "Fiend", "Blue", 20);
		Pet StevePet = new ExoticAnimalAdapter(Steve);
		
		
		animals.add(Carl);
		animals.add(StevePet);
		
		for (Pet creature : animals) {
			System.out.println(creature);
		}
		

	}

}
