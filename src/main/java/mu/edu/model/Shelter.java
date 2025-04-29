package mu.edu.model;

import java.util.ArrayList;
import java.util.List;

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
	
}
