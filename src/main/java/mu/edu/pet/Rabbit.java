package mu.edu.pet;

/**
 * Represents a Rabbit pet in the pet management system
 * Extends the abstract Pet class with rabbit specific implementations
 */
public class Rabbit extends Pet{

	/**
	 * Constructs a new Rabbit with the specified attributes
	 * The type is automatically set to "Rabbit"
	 * 
	 * @param id The unique identifier for the rabbit
	 * @param name The name of the rabbit
	 * @param species The species or breed of the rabbit
	 * @param age The age of the rabbit in years
	 */
	public Rabbit(String id, String name, String species, int age) {
		super(id, name, "Rabbit", species, age);
	}
	
	/**
	 * Constructs a new Rabbit from an existing Pet object
	 * This constructor allows conversion from a generic Pet to a Rabbit
	 * 
	 * @param p The Pet object to convert to a Rabbit
	 */
	public Rabbit(Pet p) {
		super(p.getId(), p.getName(), "Rabbit", p.getSpecies(), p.getAge());
	}
	
}