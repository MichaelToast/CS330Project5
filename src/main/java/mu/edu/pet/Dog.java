package mu.edu.pet;

public class Dog extends Pet{

	public Dog(String id, String name, String species, int age) {
		super(id, name, "Dog", species, age);
	}
	
	public Dog(Pet p) {
		super(p.getId(), p.getName(), "Dog", p.getSpecies(), p.getAge());
	}
}
