package mu.edu.comparators;

import java.util.Comparator;

import mu.edu.pet.Pet;

public class SortByAge implements Comparator<Pet>{

	@Override
	public int compare(Pet a, Pet b) {
		return Integer.compare(a.getAge(), b.getAge());
	}
}
