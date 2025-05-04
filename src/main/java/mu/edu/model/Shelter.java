package mu.edu.model;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import mu.edu.comparators.SortByName;
import mu.edu.comparators.SortByAge;
import mu.edu.comparators.SortBySpecies;
import mu.edu.pet.Pet;

/**
 * The Shelter class represents the Model component of the MVC pattern for the Pet Adoption System.
 * It maintains a list of pets and provides methods to manage this collection, including adding, removing,
 * finding, filtering, and sorting pets.
 * 
 * @param <T> a type that extends Pet, allowing the shelter to store different types of pets
 */
public class Shelter <T extends Pet> {
	// Our Version of: UserInformationContainerModel 
	
	/**
	 * List that stores all pets in the shelter
	 */
	private List<T> animalList;
	
	/**
	 * Constructs a new empty Shelter instance
	 */
	public Shelter() {
		animalList = new ArrayList<T>();
	}
	
	/**
	 * Returns the list of all pets in the shelter
	 * 
	 * @return the list of all pets
	 */
	public List<T> getAnimalList() {
		return animalList;
	}
	
	/**
	 * Sets the list of pets in the shelter
	 * 
	 * @param animalList the list of pets to set
	 */
	public void setAnimalList(List<T> animalList) {
		this.animalList = animalList;
	}
	
	/**
	 * Adds a pet to the shelter if a pet with the same ID doesn't already exist
	 * 
	 * @param pet the pet to add to the shelter
	 * @return true if the pet was added successfully, false if a pet with the same ID already exists
	 */
	public boolean addPet(T pet) {
		for(T existingPet : animalList) {
			if (existingPet.getId().equals(pet.getId())) {
				return false;
			}
		}
		return animalList.add(pet);
	}
	
	/**
	 * Removes a pet from the shelter based on its ID
	 * 
	 * @param id the ID of the pet to remove
	 * @return true if a pet was removed, false if no pet with the given ID was found
	 */
	public boolean removePet(String id) {
		return animalList.removeIf(pet -> pet.getId().equals(id));
	}
	
	/**
	 * Sorts the list of pets by name in alphabetical order
	 * Uses the SortByName comparator
	 */
	public void sortPetsByName() {
		animalList.sort(new SortByName());
	}
	
	/**
	 * Sorts the list of pets by age in ascending order
	 * Uses the SortByAge comparator
	 */
	public void sortPetsByAge() {
		animalList.sort(new SortByAge());
	}
	
	/**
	 * Sorts the list of pets by species in alphabetical order
	 * Uses the SortBySpecies comparator
	 */
	public void sortPetsBySpecies() {
		animalList.sort(new SortBySpecies());
	}
}
	
