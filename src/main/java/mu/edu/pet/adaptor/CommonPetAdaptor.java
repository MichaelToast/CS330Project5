package mu.edu.pet.adaptor;

import com.google.gson.*;

import mu.edu.pet.Cat;
import mu.edu.pet.Dog;
import mu.edu.pet.Pet;
import mu.edu.pet.Rabbit;

public class CommonPetAdaptor {
	private JsonObject pet; 
	
	public CommonPetAdaptor(JsonObject pet) {
		pet = pet; 
	}
	
	public Pet toPet() {
		// Make sure that I am getting the integers correclty. 
		// I need to know what thype of pet to return?
			// (int id, String name, String species, int age)
		if (pet.get("species").equals("Cat")) {
			return new Cat(
					pet.get("id").getAsInt(),
					pet.get("name").getAsString(),
					pet.get("species").getAsString(),
					pet.get("age").getAsInt()
					);
		}
		else if (pet.get("species").equals("Dog")) {
			return new Dog(
					pet.get("id").getAsInt(),
					pet.get("name").getAsString(),
					pet.get("species").getAsString(),
					pet.get("age").getAsInt()
					);
		}
		else {
			return new Rabbit(
					pet.get("id").getAsInt(),
					pet.get("name").getAsString(),
					pet.get("species").getAsString(),
					pet.get("age").getAsInt()
					);
		}
		
	}
}
