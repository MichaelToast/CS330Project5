package mu.edu.comparators;

import java.util.Comparator;

import mu.edu.pet.Pet;
/**
 * This class implements the Comparator interface to provide function for sorting
 * pet objects by their species name in alphabetical order
 */
public class SortBySpecies implements Comparator<Pet> {

	/**
	 * Compares two pet objects based on their age
	 * @param a the first pet compared
	 * @param b the second pet compared
	 * @return if alphabetically less than, equal to, or greater than the second species
	 */
	@Override
	public int compare(Pet a, Pet b) {
		return a.getSpecies().compareToIgnoreCase(b.getSpecies());
	}
}
