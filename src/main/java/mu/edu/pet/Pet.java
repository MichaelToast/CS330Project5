package mu.edu.pet;

public interface Pet {

	public String getId();

	public void setId(String id);

	public String getName();

	public void setName(String name);

	public String getType();
	
	public void setType(String type);

	public String getSpecies();
	
	public void setSpecies(String species);
	
	public int getAge();

	public void setAge(int age);

	public boolean isAdopted();

	public void setAdopted(boolean adopted);

	
	
}
