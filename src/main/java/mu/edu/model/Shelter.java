package mu.edu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

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
	
	public T findPetById(String id) {
		for (T pet : animalList) {
			if (pet.getId().equals(id)) {
				return pet;
			}
		}
		return null;
	}
	
	public List<T> findPetsByType(String type) {
		return animalList.stream()
				.filter(pet -> pet.getType().equalsIgnoreCase(type))
				.collect(Collectors.toList());
	}
	
	public List<T> findPetsBySpecies(String species) {
		return animalList.stream()
				.filter(pet -> pet.getSpecies().equalsIgnoreCase(species))
				.collect(Collectors.toList());
	}
	
	
	
	
	
}
