package mu.edu.controller;

import mu.edu.comparators.*;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

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
	 // Used to automatically generate ID's
	private Double nonExoticIdCounter;	// Because of how it reads from files
	private Integer exoticIdCounter; 
	
	public ShelterController(Shelter<Pet> shelter, AdoptionInputView inputView) {
	    this.shelter = shelter;
	    this.inputView = inputView;
	    this.inputView.addActionListenerToSubmitButton(new SubmitButtonActionListener());
	    this.centerView = new AdoptionCenterView();
		this.centerView.addActionListenerToDeletePetsButton(new DeletePetButtonActionListener());
		this.centerView.addActionListenerToAdoptPetsButton(new AdoptPetButtonActionListener());
		this.centerView.addActionListenerToSortingDropDown(new SortingActionListener());
		this.centerView.addActionListenerToSaveButton(new SaveActionListener());
		this.centerView.addActionListenerToViewDetailsButton(new ViewDetailsButtonActionListener());
		
		this.nonExoticIdCounter = 0.0;
		this.exoticIdCounter = 0;
	}

	public void initiate() {
		inputView.setVisible(true);
	}
	
	private class SubmitButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String type = inputView.getAnimalType();
			String tempId = "";
			
			Pet pet = null;
			
			switch (type) {
            case "Dog":
            	nonExoticIdCounter ++;
                pet = new Dog(Double.toString(nonExoticIdCounter), inputView.getAnimalName(), inputView.getAnimalSpecies(), inputView.getAnimalAge());  
                break;
            case "Cat":
                nonExoticIdCounter ++;
                pet = new Cat(Double.toString(nonExoticIdCounter), inputView.getAnimalName(), inputView.getAnimalSpecies(), inputView.getAnimalAge());
                break;
            case "Rabbit":
                nonExoticIdCounter ++;
                pet = new Rabbit(Double.toString(nonExoticIdCounter), inputView.getAnimalName(), inputView.getAnimalSpecies(), inputView.getAnimalAge());
                break;
            default:
            	exoticIdCounter ++;
            	pet = new ExoticAnimalAdapter(new ExoticAnimal("exo" + Integer.toString(exoticIdCounter), inputView.getAnimalName(), inputView.getAnimalSpecies(),inputView.getAnimalType(), inputView.getAnimalAge()));
            	break;
        }
		shelter.getAnimalList().add(pet);
		centerView.getPetList().addElement(pet);
		centerView.setVisible(true);
		centerView.setDialogue("Information has been Saved");

		}
		
	}
	
	
	private class DeletePetButtonActionListener implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        int[] multipleSelectedPetIndices = centerView.getMultipleSelectedPets();
	        Arrays.sort(multipleSelectedPetIndices);
	        for (int i = multipleSelectedPetIndices.length - 1; i >= 0; i--) {
	            int index = multipleSelectedPetIndices[i];
	            Pet pet = centerView.getPetList().get(index);
	            centerView.getPetList().removeElementAt(index);
	            shelter.getAnimalList().remove(pet);
	        }

	        centerView.setDialogue("Information has been Deleted");
	    }
	}

	private class AdoptPetButtonActionListener implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	boolean errorEncountered = false; // So that the error doesn't dispapear
	        int[] multipleSelectedPetIndices = centerView.getMultipleSelectedPets();
	        Arrays.sort(multipleSelectedPetIndices);
	        for (int i = multipleSelectedPetIndices.length - 1; i >= 0; i--) {
	            int index = multipleSelectedPetIndices[i];
	            Pet pet = centerView.getPetList().get(index);
	            if (pet.isAdopted()) {
	            	centerView.setDialogue("Pets Cannot be Adopted more than once!");
	            	errorEncountered = true;
	            }
	            pet.setAdopted(true);
	            centerView.getPetList().set(index, pet); 
	        }
	        if (!errorEncountered) {
	        	centerView.setDialogue("Thank You!");
	        }

	    }
	}

	private class SortingActionListener implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	String selectedOption = centerView.getSelectedDropdown();
	        List<Pet> petList = new ArrayList<>();

	        // Temp list
	        for (int i = 0; i < centerView.getPetList().size(); i++) {
	            petList.add(centerView.getPetList().get(i));
	        }

	        switch (selectedOption) {
	            case "Name":
	                petList.sort(new SortByName());
	                break;
	            case "Age":
	                petList.sort(new SortByAge());
	                break;
	            case "Species Name":
	                petList.sort(new SortBySpecies());
	                break;
	            case "Default":
	            default:
	                // Maybe sort by ID or load from the original shelter list if needed
	                petList = new ArrayList<>(shelter.getAnimalList());
	                break;
	        }

	        // Clear and re-populate the list model to update the UI
	        DefaultListModel<Pet> model = centerView.getPetList();
	        model.clear();
	        for (Pet pet : petList) {
	            model.addElement(pet);
	        }
	    }
	}
	
	private class SaveActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			saveAnimalList();
			centerView.setDialogue("Information has been Saved");
		}
	}
	
	private class ViewDetailsButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			centerView.setDialogue("There are: " + nonExoticIdCounter + " Non-Exotic Animals, and " + exoticIdCounter + " Exotic Animals");
		}
		
	}

	/*Read pets.json*/
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
                    centerView.getPetList().addElement(pet);
            		centerView.setVisible(true);
            		nonExoticIdCounter ++;
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
	
	
	/*Read exotic_animals.json*/
	public void readExoticAnimalFile(String filename) {
		System.out.println("Attempting to read the file!");
        try {
            FileReader reader = new FileReader(filename);
            Gson gson = new Gson();
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
            		centerView.getPetList().addElement(pet);
            		centerView.setVisible(true);
            		exoticIdCounter ++;
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	
	/*Saves animal list with current time and date*/
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


}
