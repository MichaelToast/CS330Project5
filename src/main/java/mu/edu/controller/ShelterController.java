package mu.edu.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	private Shelter<Pet> shelter; 
	private AdoptionInputView inputView;
	private AdoptionCenterView centerView;
	
	public ShelterController(Shelter<Pet> shelter, AdoptionInputView inputView) {
		this.shelter = shelter; 
		this.inputView = inputView;
		this.inputView.addSubmitListener(new SubmitButtonActionListener());
		//this.centerView = centerView; 
	}
	
	public void initiate() {
		inputView.setVisible(true);
	}
	
	private class SubmitButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Need to see if what they a
			String type = inputView.getAnimalType();
			String tempId = "";
			
			Pet pet = null;
			// 
			switch (type) {
            case "Dog":
                pet = new Dog(tempId, inputView.getAnimalName(), inputView.getAnimalSpecies(), inputView.getAnimalAge());
                break;
            case "Cat":
                pet = new Cat(tempId, inputView.getAnimalName(), inputView.getAnimalSpecies(), inputView.getAnimalAge());
                break;
            case "Rabbit":
                pet = new Rabbit(tempId, inputView.getAnimalName(), inputView.getAnimalSpecies(), inputView.getAnimalAge());
                break;
            default:
            	System.out.println("kjfnsfdnskj");
            	break;
                // THIS IS AN EXOTIC ANIMAL we have to create
        }
		shelter.addPet(pet);
		centerView.getUserList().addElement(pet);
		centerView.setVisible(true);

			
		}
		
	}
	
	public void readNonExoticAnimalFile(String fileName) {
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
	
	public void readExoticAnimalFile(String filename) {
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
		LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
	    String fileName = now.format(formatter) + "_pets.json";
	    
	    try (FileWriter writer = new FileWriter(fileName)) {
	        Gson gson = new Gson();
	        
	        // Serialize the whole list of pets to JSON
	        List<Pet> pets = this.shelter.getAnimalList();
	        
	        // Write the entire list as a JSON array
	        gson.toJson(pets, writer);  // This serializes the list and writes it directly to the file

	        System.out.println("Animal list saved to " + fileName);
	    } catch (IOException e) {
	        e.printStackTrace();
	        System.out.println("Error saving animal list");
	    }
	}
	
	
	public void tempPrintShelter() {
		for (Object obj : this.shelter.getAnimalList()) {
		    Pet p = (Pet) obj;
		    System.out.println(p);
		}
	}

}
