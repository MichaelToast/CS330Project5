package mu.edu.pet;

/**
 * Abstract class representing a generic pet
 * Serves as the base class for different types of pets
 * Implements Comparable interface to allow pets to be sorted by name
 */
public abstract class Pet implements Comparable <Pet>{
	private String id;
	private String name;
	private String type;
	private String species;
	private int age;
	private boolean adopted;
	
	/**
	 * Constructs a new Pet with the specified attributes
	 * 
	 * @param id The unique identifier for the pet
	 * @param name The name of the pet
	 * @param type The type of pet
	 * @param species The species/breed of the pet
	 * @param age The age of the pet in years
	 */
	public Pet(String id, String name, String type, String species, int age) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.species = species;
		this.age = age;
		this.adopted = false;
	}
	/**
	 * Gets the unique identifier of the pet
	 * 
	 * @return The pet's ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the unique identifier of the pet
	 * 
	 * @param id The new ID to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets the name of the pet
	 * 
	 * @return The pet's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the pet
	 * 
	 * @param name The new name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the type of the pet
	 * 
	 * @return The pet's type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type of the pet
	 * 
	 * @param type The new type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the species or breed of the pet
	 * 
	 * @return The pet's species
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * Sets the species or breed of the pet
	 * 
	 * @param species The new species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * Gets the age of the pet in years
	 * 
	 * @return The pet's age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age of the pet
	 * 
	 * @param age The new age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Checks if the pet has been adopted
	 * 
	 * @return true if the pet is adopted, false otherwise
	 */
	public boolean isAdopted() {
		return adopted;
	}

	/**
	 * Sets the adoption status of the pet
	 * 
	 * @param adopted The new adoption status
	 */
	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}

	/**
	 * Returns a string representation of the pet
	 * Includes the pet's name, type, species, age, and adoption status
	 * 
	 * @return A formatted string with pet details
	 */
	@Override
	public String toString() {
		return name + " (" + type + ", " + species + ", Age: " + age + ")" + (adopted ? " - Adopted" : "");
	}	
	
	/**
	 * Compares this pet with another pet for equality
	 * Pets are considered equal if they have the same ID
	 * 
	 * @param obj The object to compare with
	 * @return true if the pets are equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pet pet = (Pet) obj;
        return this.getId().equals(pet.getId());
    }
	
	/**
	 * Compares this pet with another pet for ordering
	 * Pets are ordered alphabetically by name
	 * 
	 * @param other The pet to compare with
	 * @return A negative int, zero, or a positive int as this pet's name
	 *         is less than, equal to, or greater than the other pet's name
	 */
	@Override
	public int compareTo(Pet other) {
        return this.getName().compareTo(other.getName());
    }
}
