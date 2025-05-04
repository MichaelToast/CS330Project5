package mu.edu.pet;

public abstract class Pet implements Comparable <Pet>{
	private String id;
	private String name;
	private String type;
	private String species;
	private int age;
	private boolean adopted;
	
	public Pet(String id, String name, String type, String species, int age) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.species = species;
		this.age = age;
		this.adopted = false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isAdopted() {
		return adopted;
	}

	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}

	@Override
	public String toString() {
		return name + " (" + type + ", " + species + ", Age: " + age + ")" + (adopted ? " - Adopted" : "");
	}	
	
	
	@Override
	public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pet pet = (Pet) obj;
        return this.getId().equals(pet.getId());
    }
	
	@Override
	public int compareTo(Pet other) {
        return this.getName().compareTo(other.getName());
    }
}
