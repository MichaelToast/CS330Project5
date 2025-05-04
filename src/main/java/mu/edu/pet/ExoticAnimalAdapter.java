package mu.edu.pet;

/**
 * Adapter class that allows an ExoticAnimal to be treated as a Pet
 * Implements the Adapter design pattern to convert ExoticAnimal interface to Pet interface
 * Extends the Pet class and delegates most operations to the adapted ExoticAnimal
 */
public class ExoticAnimalAdapter extends Pet {
    private ExoticAnimal exoticAnimal;
    // private boolean adopted;

    /**
     * Constructs a new ExoticAnimalAdapter that adapts the specified ExoticAnimal to a Pet
     * Maps ExoticAnimal attributes to their corresponding Pet attributes
     * 
     * @param exoticAnimal The ExoticAnimal to adapt
     */
    public ExoticAnimalAdapter(ExoticAnimal exoticAnimal) {
    	 super(exoticAnimal.getUniqueId(), exoticAnimal.getAnimalName(),
                 exoticAnimal.getCategory(), exoticAnimal.getSubSpecies(),
                 exoticAnimal.getYearsOld());
        this.exoticAnimal = exoticAnimal;
    }
    
    /**
     * Constructs a new ExoticAnimalAdapter with the specified attributes
     * This constructor is used when creating a new adapter without an existing ExoticAnimal
     * 
     * @param uniqueId The unique identifier for the exotic animal
     * @param animalName The name of the exotic animal
     * @param category The category of animal 
     * @param subSpecies The subspecies of the animal 
     * @param yearsOld The age of the animal in years
     */
    public ExoticAnimalAdapter(String uniqueId, String animalName, String category, String subSpecies, int yearsOld) {
    	super(uniqueId, animalName, category, subSpecies, yearsOld);
    	//this.adopted = false; 
    }
    
    /**
     * Gets the ID of the exotic animal
     * 
     * @return The exotic animal's unique ID
     */
	public String getId() {
		return exoticAnimal.getUniqueId();
	}

	/**
	 * Sets the ID of the exotic animal
	 * 
	 * @param id The new ID to set
	 */
	public void setId(String id) {
		this.exoticAnimal.setUniqueId(id);
	}

	/**
	 * Gets the name of the exotic animal
	 * 
	 * @return The exotic animal's name
	 */
	public String getName() {
		return this.exoticAnimal.getAnimalName();
	}

	/**
	 * Sets the name of the exotic animal
	 * 
	 * @param name The new name to set
	 */
	public void setName(String name) {
		this.exoticAnimal.setAnimalName(name);
	}

	/**
	 * Gets the type of the exotic animal
	 * 
	 * @return The exotic animal's subspecies
	 */
	public String getType() {
		return this.exoticAnimal.getSubSpecies();
	}

	/**
	 * Sets the type of the exotic animal.
	 * 
	 * @param type The new type to set
	 */
	public void setType(String type) {
		this.exoticAnimal.setSubSpecies(type);
	}

	/**
	 * Gets the species of the exotic animal
	 * 
	 * @return The exotic animal's category
	 */
	public String getSpecies() {
		return this.exoticAnimal.getCategory();
	}

	/**
	 * Sets the species of the exotic animal
	 * 
	 * @param species The new species to set
	 */
	public void setSpecies(String species) {
		this.exoticAnimal.setCategory(species);
	}

	/**
	 * Gets the age of the exotic animal
	 * 
	 * @return The exotic animal's age
	 */
	public int getAge() {
		return this.exoticAnimal.getYearsOld();
	}

	/**
	 * Sets the age of the exotic animal
	 * 
	 * @param age The new age to set
	 */
	public void setAge(int age) {
		this.exoticAnimal.setYearsOld(age);
	}

	/**
	 * Checks if the exotic animal has been adopted
	 * Delegates to the parent Pet class as ExoticAnimal doesn't track adoption status
	 * 
	 * @return true if the exotic animal is adopted, false otherwise
	 */
	public boolean isAdopted() {
		// return this.isAdopted();
		return super.isAdopted();
	}

	/**
	 * Sets the adoption status of the exotic animal
	 * Delegates to the parent Pet class
	 * 
	 * @param adopted The new adoption status
	 */
	public void setAdopted(boolean adopted) {
		super.setAdopted(adopted);
	}
	
	/**
	 * Gets the adapted ExoticAnimal object
	 * 
	 * @return The ExoticAnimal being adapted
	 */
	public ExoticAnimal getExoticAnimal() {
		return this.exoticAnimal;
	}
	
	/**
     * Returns a string representation of the exotic animal
     * Includes the exotic animal's details and adoption status
     * 
     * @return A formatted string with exotic animal details
     */
    @Override
	public String toString() {
    	//System.out.println("Adoption Status: " + this.isAdopted());
		return this.exoticAnimal.toString() + (isAdopted() ? " - Adopted" : "");
	}
}