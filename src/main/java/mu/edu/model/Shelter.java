package mu.edu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

import mu.edu.pet.Pet;

public class Shelter <T extends Pet> {
	// My Version of: UserInformationContainerModel 
	private List<T> animalList;
	
	public Shelter() {
		animalList = new ArrayList<T>();
	}

	public List<T> getAnimalList() {
		return animalList;
	}

	public void setAnimalList(List<T> animalList) {
		this.animalList = animalList;
	}
	
	public boolean addPet(T pet) {
		for(T existingPet : animalList) {
			if (existingPet.getId().equals(pet.getId())) {
				return false;
			}
		}
		return animalList.add(pet);
	}
	
	public boolean removePet(String id) {
		return animalList.removeIf(pet -> pet.getId().equals(id));
	}
	
	
	
}
