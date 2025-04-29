package mu.edu.pet;

public class ExoticAnimal {
    private String uniqueId;
    private String animalName;
    private String category;	// Our version of Species
    private String subSpecies; // Our version of Type
    private int yearsOld;
    
	public ExoticAnimal(String uniqueId, String animalName, String category, String subSpecies, int yearsOld) {
		super();
		this.uniqueId = uniqueId;
		this.animalName = animalName;
		this.category = category;
		this.subSpecies = subSpecies;
		this.yearsOld = yearsOld;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubSpecies() {
		return subSpecies;
	}

	public void setSubSpecies(String subSpecies) {
		this.subSpecies = subSpecies;
	}

	public int getYearsOld() {
		return yearsOld;
	}

	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}

	@Override
	public String toString() {
		return "ExoticAnimal [uniqueId=" + uniqueId + ", animalName=" + animalName + ", category=" + category
				+ ", subSpecies=" + subSpecies + ", yearsOld=" + yearsOld + "]";
	}
	
	
	

}
