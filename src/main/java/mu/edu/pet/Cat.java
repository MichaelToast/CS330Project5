package mu.edu.pet;
/**
 * Represents a Cat pet in the pet management system
 * Extends the abstract Pet class with cat specific implementations
 */
public class Cat extends Pet{

	/**
	 * Constructs a new Cat with the specified attributes
	 * The type is automatically set to "Cat"
	 * 
	 * @param id The unique identifier for the cat
	 * @param name The name of the cat
	 * @param species The breed of the cat
	 * @param age The age of the cat in years
	 */
	public Cat(String id, String name, String species, int age) {
		super(id, name, "Cat", species, age);
	}
	/**
	 * Constructs a new Cat from an existing Pet object
	 * This constructor allows conversion from a generic Pet to a Cat
	 * 
	 * @param p The Pet object to convert to a Cat
	 */
	public Cat(Pet p) {
		super(p.getId(), p.getName(), "Cat", p.getSpecies(), p.getAge());
	}
}
