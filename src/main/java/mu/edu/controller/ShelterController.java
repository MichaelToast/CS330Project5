package mu.edu.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import mu.edu.model.Shelter;
import mu.edu.pet.Cat;
import mu.edu.pet.Dog;
import mu.edu.pet.ExoticAnimal;
import mu.edu.pet.ExoticAnimalAdapter;
import mu.edu.pet.Pet;
import mu.edu.pet.Rabbit;
import mu.edu.view.AdoptionCenterView;
import mu.edu.view.AdoptionInputView;

public class ShelterController {
	private Shelter shelter; 
	private AdoptionInputView inputView;
	private AdoptionCenterView centerView;
	
	public ShelterController(Shelter shelter, AdoptionInputView inputView) {
		this.shelter = shelter; 
		this.inputView = inputView;
		// this.centerView = centerView; 
	}
	
	public void initiate() {
		inputView.setVisible(true);
	}
	

	
	public void addAnimals(String fileName) {
		System.out.println("Attempting to read the file!");
        try {
            FileReader reader = new FileReader(fileName);
            Gson gson = new Gson();

            // Define the type for the list of pets
            Type petListType = new TypeToken<List<Map<String, Object>>>(){}.getType();
            List<Map<String, Object>> petList = gson.fromJson(reader, petListType);

            for (Map<String, Object> petMap : petList) {
                String type = (String) petMap.get("type");
                Double idTemp = ((Double) petMap.get("id"));
                String id = String.valueOf(idTemp);

                String name = (String) petMap.get("name");
                String species = (String) petMap.get("species");
                int age = ((Double) petMap.get("age")).intValue();
                //Boolean adoptionStatus = (Boolean) petMap.get("adopted");
                
                Pet pet = null;
                switch (type) {
                    case "Dog":
                        pet = new Dog(id, name, species, age);
                        break;
                    case "Cat":
                        pet = new Cat(id, name, species, age);
                        break;
                    case "Rabbit":
                        pet = new Rabbit(id, name, species, age);
                        break;
                    default:
                        System.out.println("Unknown pet type: " + type);
                }

                if (pet != null) {
                    this.shelter.addPet(pet);
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

	
	
	public void addExoticAnimals(String filename) {
		System.out.println("Attempting to read the file!");
        try {
            FileReader reader = new FileReader(filename);
            Gson gson = new Gson();

            // Define the type for the list of pets
            Type petListType = new TypeToken<List<Map<String, Object>>>(){}.getType();
            List<Map<String, Object>> petList = gson.fromJson(reader, petListType);

            for (Map<String, Object> petMap : petList) {
                String uniqueId = (String) petMap.get("uniqueId");
                String animalName = (String) petMap.get("animalName");
                String category = (String) petMap.get("category");
                String subSpecies = (String) petMap.get("subSpecies");
                int yearsOld = ((Double) petMap.get("yearsOld")).intValue();
                
                Pet pet = null;
                pet = new ExoticAnimalAdapter(new ExoticAnimal(uniqueId, animalName, category, subSpecies, yearsOld));
                if (pet != null) {
                    this.shelter.addPet(pet);
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public void saveAnimalList () {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = timeStamp + "_pets.json";

        List<Pet> pets = shelter.getAnimalList();

        Gson gson = new Gson();
        String jsonOut = gson.toJson(pets);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(jsonOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
		// Ekin said that some of the finer data may be lost when we have the file. 
		// I am taking this as meaning we can convert all of the exotic animals to nonexotic animals as we go to save it
	}
	
	public void tempPrintShelter() {
		for (Object obj : this.shelter.getAnimalList()) {
		    Pet p = (Pet) obj;
		    System.out.println(p);
		}
	}

}
