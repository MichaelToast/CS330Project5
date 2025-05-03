package mu.edu.comparators;

import java.util.Comparator;

import mu.edu.pet.Pet;

public class SortByName implements Comparator<Pet> {

	@Override
	public int compare(Pet a, Pet b) {
		return a.getName().compareToIgnoreCase(b.getName());
	}
}
