package mu.edu.pet;

public class Rabbit extends Pet{

	public Rabbit(String id, String name, String species, int age) {
		super(id, name, "Rabbit", species, age);
	}
	public Rabbit(Pet p) {
		super(p.getId(), p.getName(), "Rabbit", p.getSpecies(), p.getAge());
	}
	
}
