package mu.edu.controller;

import java.io.BufferedWriter;
import java.io.FileReader;

import mu.edu.model.Shelter;

public class ShelterController {
	private Shelter shelter; 
	
	public ShelterController(Shelter shelter) {
		this.shelter = shelter; 
	}
	
	public void addAnimals(String fileName) {
		// IMPORTANT NOTE: This is going to have to be able to read ExoticAnimals and NonExotic animals because of the way that we are storing the files. 
		
			// Tools
		// FileReader reader = new FileReader(fileName) // The files are stored in resources
		// Going to have to use; shelter.getAnimalList().add()
		// There is probably a fancy way to do this with "instance of Exotic Animal" OR you could do something with a tryCatch statment
	}
	
	
	public void saveAnimalList () {
		/* Save the pet list back to JSON file. For the saved file name, use the current date and time when the save button is clicked. Ex: YYYYMMDD HHMMSS pets.json
		 * */
	}

}
