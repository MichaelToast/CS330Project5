package mu.edu.main;

import javax.swing.SwingUtilities;
import mu.edu.controller.ShelterController;
import mu.edu.model.Shelter;
import mu.edu.pet.Pet;
import mu.edu.view.AdoptionInputView;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            Shelter<Pet> shelter = new Shelter<>();
            AdoptionInputView inputView = new AdoptionInputView();

            ShelterController controller = new ShelterController(shelter, inputView);

            // Optional: Load from files at startup
            // controller.readNonExoticAnimalFile("src/main/resources/pets.json");
            // controller.readExoticAnimalFile("src/main/resources/exotic_animals.json");

            inputView.setVisible(true);
        });
    }
}
