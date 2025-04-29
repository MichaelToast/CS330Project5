package mu.edu.pet.adaptor;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import mu.edu.pet.ExoticAnimal;
import mu.edu.pet.Pet;

public class ExoticAnimalAdapter extends Pet {
    private ExoticAnimal exoticAnimal;

    // Constructor that adapts the ExoticAnimal to Pet
    public ExoticAnimalAdapter(ExoticAnimal exoticAnimal) {
        super(exoticAnimal.getUniqueId(), exoticAnimal.getAnimalName(),
              exoticAnimal.getCategory(), exoticAnimal.getSubSpecies(),
              exoticAnimal.getYearsOld());
        this.exoticAnimal = exoticAnimal;
    }
    
    public ExoticAnimalAdapter(String uniqueId, String animalName, String category, String subSpecies, int yearsOld) {
    	super(uniqueId, animalName, category, subSpecies, yearsOld);
    	this.exoticAnimal = new ExoticAnimal(uniqueId, animalName, category, subSpecies, yearsOld);
    	
    }
    
	public String getId() {
		return exoticAnimal.getUniqueId();
	}

	public void setId(String id) {
		this.exoticAnimal.setUniqueId(id);
	}

	public String getName() {
		return this.exoticAnimal.getAnimalName();
	}

	public void setName(String name) {
		this.exoticAnimal.setAnimalName(name);
	}

	public String getType() {
		return this.exoticAnimal.getSubSpecies();
	}

	public void setType(String type) {
		this.exoticAnimal.setSubSpecies(type);
	}

	public String getSpecies() {
		return this.exoticAnimal.getCategory();
	}

	public void setSpecies(String species) {
		this.exoticAnimal.setCategory(species);
	}

	public int getAge() {
		return this.exoticAnimal.getYearsOld();
	}

	public void setAge(int age) {
		this.exoticAnimal.setYearsOld(age);
	}

	public boolean isAdopted() {
		return this.isAdopted();
	}

	public void setAdopted(boolean adopted) {
		this.setAdopted(adopted);
	}
	
    @Override
	public String toString() {
		return this.exoticAnimal.toString();
	}

}
