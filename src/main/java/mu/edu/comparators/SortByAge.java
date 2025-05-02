package mu.edu.comparators;

import java.util.Comparator;

import mu.edu.pet.Pet;

public class SortByAge implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Pet a = (Pet) o1;
	    Pet b = (Pet) o2;
	    if (a.getAge() < b.getAge()) return -1; // The first Pet has a smaller Age
	    if (a.getAge() > b.getAge()) return 1;  // The first Pet has a larger Age
	    return 0;
	}

}
