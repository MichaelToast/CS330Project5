package mu.edu.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mu.edu.comparators.SortByAge;
import mu.edu.comparators.SortByName;
import mu.edu.comparators.SortBySpecies;
import mu.edu.model.Shelter;
import mu.edu.pet.*;
import mu.edu.view.AdoptionCenterView;
import mu.edu.view.AdoptionInputView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ShelterController {
    private final Shelter<Pet> shelter;
    private final AdoptionInputView inputView;
    private final AdoptionCenterView centerView;

    public ShelterController(Shelter<Pet> shelter, AdoptionInputView inputView) {
        this.shelter = shelter;
        this.inputView = inputView;
        this.centerView = new AdoptionCenterView();

        // ✅ Submit button logic
        this.inputView.addSubmitListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = inputView.getAnimalName();
                Integer age = inputView.getAnimalAge();
                String species = inputView.getAnimalSpecies();
                String type = inputView.getAnimalType();

                if (name.isEmpty() || age == null || age <= 0 || species.isEmpty() || type.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields correctly.");
                    return;
                }

                Pet pet = null;
                String tempId = "manual-" + System.currentTimeMillis();

                switch (type.toLowerCase()) {
                    case "dog":
                        pet = new Dog(tempId, name, species, age);
                        break;
                    case "cat":
                        pet = new Cat(tempId, name, species, age);
                        break;
                    case "rabbit":
                        pet = new Rabbit(tempId, name, species, age);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Unsupported type. Use Dog, Cat, or Rabbit.");
                        return;
                }

                shelter.addPet(pet);
                centerView.updatePetList(shelter.getAllPets());

                centerView.setVisible(true);
            }
        });

        // ✅ Adopt button logic
        centerView.getAdoptButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pet selected = centerView.getSelectedPet();

                if (selected == null) {
                    JOptionPane.showMessageDialog(null, "Please select a pet to adopt.");
                    return;
                }

                if (selected.isAdopted()) {
                    JOptionPane.showMessageDialog(null, selected.getName() + " is already adopted.");
                    return;
                }

                selected.setAdopted(true);
                JOptionPane.showMessageDialog(null, "Congratulations! You adopted " + selected.getName() + ".");
                centerView.updatePetList(shelter.getAllPets());
            }
        });

        // ✅ Delete button logic
        centerView.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pet selected = centerView.getSelectedPet();
                if (selected != null) {
                    boolean removed = shelter.removePet(selected.getId());
                    if (removed) {
                        centerView.getUserList().removeElement(selected);
                        System.out.println("Deleted pet: " + selected.getName());
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to remove pet from model.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a pet to delete.");
                }
            }
        });

        // ✅ Save button logic (all pets)
        centerView.getSaveButton().addActionListener(e -> {
            List<Pet> petsToSave = shelter.getAllPets(); // Include adopted pets
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(petsToSave);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filename = "saved_animals_" + timestamp + ".json";

            try (FileWriter writer = new FileWriter(filename)) {
                writer.write(json);
                JOptionPane.showMessageDialog(null, "Animal list saved to " + filename);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to save file.");
            }
        });

        // ✅ Sort dropdown logic
        centerView.getSortCombo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) centerView.getSortCombo().getSelectedItem();
                List<Pet> pets = shelter.getAllPets();

                switch (selected) {
                    case "Sort by Name":
                        pets.sort(new SortByName());
                        break;
                    case "Sort by Age":
                        pets.sort(new SortByAge());
                        break;
                    case "Sort by Species":
                        pets.sort(new SortBySpecies());
                        break;
                    default:
                        break;
                }

                centerView.updatePetList(pets);
            }
        });
    }

    // Optional file loaders
    public void readNonExoticAnimalFile(String fileName) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(fileName)) {
            Pet[] pets = gson.fromJson(reader, Pet[].class);
            for (Pet pet : pets) {
                shelter.addPet(pet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readExoticAnimalFile(String filename) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filename)) {
            ExoticAnimal[] exotics = gson.fromJson(reader, ExoticAnimal[].class);
            for (ExoticAnimal exotic : exotics) {
                shelter.addPet(new ExoticAnimalAdapter(exotic));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
