package mu.edu.controller;

import java.io.BufferedWriter;
import java.io.FileReader;

import mu.edu.model.Shelter;
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
		// Tools
		// FileReader reader = new FileReader(fileName) // The files are stored in resources
		// Going to have to use; shelter.getAnimalList().add()
	}
	
	public void addExoticAnimals(String filename) {
		
	}
	
	
	public void saveAnimalList () {
		// Ekin said that some of the finer data may be lost when we have the file. 
		// I am taking this as meaning we can convert all of the exotic animals to nonexotic animals as we go to save it
	}

}
