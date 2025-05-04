package mu.edu.pet;

/**
 * Represents an exotic animal in the pet management system
 * This class uses different attribute names compared to the Pet class hierarchy
 */
public class ExoticAnimal {
    private String uniqueId;
    private String animalName;
    private String category;	// Our version of Species
    private String subSpecies; // Our version of Type
    private int yearsOld;
    
    /**
     * Constructs a new ExoticAnimal with the specified attributes
     * 
     * @param uniqueId The unique identifier for the exotic animal
     * @param animalName The name of the exotic animal
     * @param category The category of animal 
     * @param subSpecies The subspecies of the animal 
     * @param yearsOld The age of the animal in years
     */
	public ExoticAnimal(String uniqueId, String animalName, String category, String subSpecies, int yearsOld) {
		super();
		this.uniqueId = uniqueId;
		this.animalName = animalName;
		this.category = category;
		this.subSpecies = subSpecies;
		this.yearsOld = yearsOld;
	}
	
	/**
	 * Gets the unique identifier of the exotic animal
	 * 
	 * @return The exotic animal's unique ID
	 */
	public String getUniqueId() {
		return uniqueId;
	}

	/**
	 * Sets the unique identifier of the exotic animal.
	 * 
	 * @param uniqueId The new unique ID to set
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	/**
	 * Gets the name of the exotic animal.
	 * 
	 * @return The exotic animal's name
	 */
	public String getAnimalName() {
		return animalName;
	}

	/**
	 * Sets the name of the exotic animal
	 * 
	 * @param animalName The new name to set
	 */
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	/**
	 * Gets the category of the exotic animal 
	 * 
	 * @return The exotic animal's category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the category of the exotic animal
	 * 
	 * @param category The new category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Gets the subspecies of the exotic animal
	 * 
	 * @return The exotic animal's subspecies
	 */
	public String getSubSpecies() {
		return subSpecies;
	}

	/**
	 * Sets the subspecies of the exotic animal
	 * 
	 * @param subSpecies The new subspecies to set
	 */
	public void setSubSpecies(String subSpecies) {
		this.subSpecies = subSpecies;
	}

	/**
	 * Gets the age of the exotic animal in years
	 * 
	 * @return The exotic animal's age
	 */
	public int getYearsOld() {
		return yearsOld;
	}

	/**
	 * Sets the age of the exotic animal
	 * 
	 * @param yearsOld The new age to set
	 */
	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}

	/**
	 * Returns a string representation of the exotic animal
	 * Includes the animal's name, unique ID, category, subspecies, and age
	 * 
	 * @return A formatted string with exotic animal details
	 */
	@Override
	public String toString() {
		return animalName + " (" + uniqueId + ", " + "Exotic" + ", " + category
				+ ", " + subSpecies + ", Age: " + yearsOld + ")";
	}
}