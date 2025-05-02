package mu.edu.comparators;

import java.util.Comparator;

import mu.edu.pet.Pet;

public class SortBySpecies implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Pet a = (Pet) o1;
	    Pet b = (Pet) o2;
	    return a.getSpecies().compareTo(b.getSpecies());
	}

}
