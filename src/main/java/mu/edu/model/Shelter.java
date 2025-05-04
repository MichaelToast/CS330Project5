package mu.edu.model;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import mu.edu.comparators.SortByName;
import mu.edu.comparators.SortByAge;
import mu.edu.comparators.SortBySpecies;
import mu.edu.pet.Pet;

public class Shelter <T extends Pet> {
	// Our Version of: UserInformationContainerModel 
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
	
	public List<T> getAdoptedPets() {
		return animalList.stream()
				.filter(Pet::isAdopted)
				.collect(Collectors.toList());
	}
	
	public List<T> getAvailablePets() {
		return animalList.stream()
				.filter(pet -> !pet.isAdopted())
				.collect(Collectors.toList());
	}
	
	public List<Pet> getAllPets() {
		return new ArrayList<>(animalList);
	}
	

	public void sortPetsByName() {
		animalList.sort(new SortByName());
	}
	
	public void sortPetsByAge() {
		animalList.sort(new SortByAge());
	}
	
	public void sortPetsBySpecies() {
		animalList.sort(new SortBySpecies());
	}
	
	public int getTotalPets() {
		return animalList.size();
	}

	public int getSize() {
		return animalList.size();
	}
}
	
