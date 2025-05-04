package mu.edu.comparators;

import java.util.Comparator;

import mu.edu.pet.Pet;
/**
 * This class implements the Comparator interface to provide function for sorting
 * pet objects by their age in ascending order
 */
public class SortByAge implements Comparator<Pet>{
	/**
	 * Compares two pet objects based on their age
	 * @param a the first pet compared
	 * @param b the second pet compared
	 * @return negative int, zero, or positive int
	 */
	@Override
	public int compare(Pet a, Pet b) {
		return Integer.compare(a.getAge(), b.getAge());
	}
}
