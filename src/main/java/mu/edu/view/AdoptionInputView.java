package mu.edu.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AdoptionInputView extends JFrame {
    private JPanel panel;
    private JTextField animalNameTextField;
    private JTextField animalAgeTextField;
    private JTextField animalTypeTextField;
    private JTextField animalSpeciesTextField;
    private JButton submitUserButton;

    public AdoptionInputView() {
        setTitle("Adoption Input View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        setContentPane(panel);

        // Animal Name
        JLabel lblName = new JLabel("Animal Name:");
        lblName.setBounds(120, 93, 120, 20);
        panel.add(lblName);

        animalNameTextField = new JTextField();
        animalNameTextField.setBounds(229, 93, 120, 20);
        panel.add(animalNameTextField);

        // Animal Age
        JLabel lblAge = new JLabel("Animal Age:");
        lblAge.setBounds(120, 135, 120, 20);
        panel.add(lblAge);

        animalAgeTextField = new JTextField();
        animalAgeTextField.setBounds(229, 135, 120, 20);
        panel.add(animalAgeTextField);

        // Animal Type
        JLabel lblType = new JLabel("Animal Type:");
        lblType.setBounds(120, 175, 120, 20);
        panel.add(lblType);

        animalTypeTextField = new JTextField();
        animalTypeTextField.setBounds(229, 175, 120, 20);
        panel.add(animalTypeTextField);

        // Animal Species
        JLabel lblSpecies = new JLabel("Animal Species:");
        lblSpecies.setBounds(120, 217, 120, 20);
        panel.add(lblSpecies);

        animalSpeciesTextField = new JTextField();
        animalSpeciesTextField.setBounds(229, 217, 120, 20);
        panel.add(animalSpeciesTextField);

        // Submit Button
        submitUserButton = new JButton("Submit Pet");
        submitUserButton.setBounds(229, 275, 120, 25);
        panel.add(submitUserButton);
    }

    public String getAnimalName() {
        return animalNameTextField.getText().trim();
    }

    public Integer getAnimalAge() {
        try {
            return Integer.parseInt(animalAgeTextField.getText().trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public String getAnimalType() {
        return animalTypeTextField.getText().trim();
    }

    public String getAnimalSpecies() {
        return animalSpeciesTextField.getText().trim();
    }

    public void addSubmitListener(ActionListener listener) {
        submitUserButton.addActionListener(listener);
    }
}
