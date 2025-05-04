package mu.edu.pet;

/**
 * Represents a Dog pet in the pet management system
 * Extends the abstract Pet class with dog specific implementations
 */
public class Dog extends Pet{

	/**
	 * Constructs a new Dog with the specified attributes
	 * The type is automatically set to "Dog"
	 * 
	 * @param id The unique identifier for the dog
	 * @param name The name of the dog
	 * @param species The species or breed of the dog
	 * @param age The age of the dog in years
	 */
	public Dog(String id, String name, String species, int age) {
		super(id, name, "Dog", species, age);
	}
	
	/**
	 * Constructs a new Dog from an existing Pet object
	 * This constructor allows conversion from a generic Pet to a Dog
	 * 
	 * @param p The Pet object to convert to a Dog
	 */
	public Dog(Pet p) {
		super(p.getId(), p.getName(), "Dog", p.getSpecies(), p.getAge());
	}
}