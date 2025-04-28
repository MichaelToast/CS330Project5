package mu.edu.pet.adaptor;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import mu.edu.pet.ExoticAnimal;

public class ExoticAnimalAdaptor {
	public ExoticAnimal deserialize(JsonElement json) {
        JsonObject jsonObject = json.getAsJsonObject();
        
        String idString = jsonObject.get("uniqueId").getAsString();
        String name = jsonObject.get("animalName").getAsString();
        String type = jsonObject.get("category").getAsString();
        String species = jsonObject.get("subSpecies").getAsString();
        int age = jsonObject.get("yearsOld").getAsInt();
        
        int id = -1; 	// I HAVE TO FIX THIS PROBLEM
        
        // ExoticAnimal(int id, String name, String type, String species, int age)
        ExoticAnimal exoticAnimal = new ExoticAnimal(id, name, type, species, age);
        return exoticAnimal;
    }

}
