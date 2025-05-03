package mu.edu.main;

import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import mu.edu.controller.ShelterController;
import mu.edu.model.Shelter;
import mu.edu.pet.Cat;
import mu.edu.pet.ExoticAnimal;
import mu.edu.pet.ExoticAnimalAdapter;
import mu.edu.pet.Pet;
import mu.edu.view.AdoptionInputView;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello There!");
		/*
		
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
		*/
		
		ShelterController controller = new ShelterController(
				new Shelter(),
				new AdoptionInputView());
		controller.initiate();

		controller.addAnimals("src/main/resources/pet.files/pets.json");
		
		// This is actually running the program: 		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ShelterController controller = new ShelterController(
						new Shelter(),
						new AdoptionInputView());
				controller.initiate();

			}
		});
		
	}

}
