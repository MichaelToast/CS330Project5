package mu.edu.comparators;

import java.util.Comparator;

import mu.edu.pet.Pet;

public class SortBySpecies implements Comparator<Pet> {

	@Override
	public int compare(Pet a, Pet b) {
		return a.getSpecies().compareToIgnoreCase(b.getSpecies());
	}
}
