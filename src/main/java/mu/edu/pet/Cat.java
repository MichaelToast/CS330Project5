package mu.edu.pet;

public class Cat extends Pet{

	public Cat(String id, String name, String species, int age) {
		super(id, name, "Cat", species, age);
	}
	
	public Cat(Pet p) {
		super(p.getId(), p.getName(), "Cat", p.getSpecies(), p.getAge());
	}
}
