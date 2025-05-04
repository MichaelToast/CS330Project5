package mu.edu.view;

import javax.swing.*;

import java.awt.event.ActionListener;

/**
 * The AdoptionInputView class provides a GUI for users to input information about
 * a new pet to be added to the adoption system
 * It collects pet details such as name, age, type, and species.
 */
public class AdoptionInputView extends JFrame {
	private JPanel panel;
	private JTextField animalNameTextField;
	private JTextField animalTypeTextField;
	private JTextField animalSpeciesTextField;
	private JTextField animalAgeTextField;
	private JButton submitPetButton;
	
	/**
	 * Constructs a new AdoptionInputView with all necessary UI components
	 * Sets up the main JFrame and text fields for entering pet information
	 */
	public AdoptionInputView() {
		setTitle("Submit Pet Information Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		animalNameTextField = new JTextField();
		animalNameTextField.setBounds(229, 93, 96, 20);
		panel.add(animalNameTextField);
		animalNameTextField.setColumns(10);
		
		animalAgeTextField = new JTextField();
		animalAgeTextField.setBounds(229, 135, 96, 20);
		panel.add(animalAgeTextField);
		animalAgeTextField.setColumns(10);
		
		submitPetButton = new JButton("Submit Pet");
		submitPetButton.setBounds(229, 245, 100, 23);
		panel.add(submitPetButton);
		
		JLabel lblNewLabel = new JLabel("Animal Name:");
		lblNewLabel.setBounds(134, 93, 1200, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Animal Age:");
		lblNewLabel_1.setBounds(134, 138, 120, 14);
		panel.add(lblNewLabel_1);
		
		animalTypeTextField = new JTextField();
		animalTypeTextField.setBounds(229, 173, 96, 20);
		panel.add(animalTypeTextField);
		animalTypeTextField.setColumns(10);
		
		animalSpeciesTextField = new JTextField();
		animalSpeciesTextField.setBounds(229, 214, 96, 20);
		panel.add(animalSpeciesTextField);
		animalSpeciesTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Animal Type:");
		lblNewLabel_2.setBounds(132, 175, 120, 17);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Animal Species:");
		lblNewLabel_3.setBounds(132, 217, 120, 14);
		panel.add(lblNewLabel_3);
	}

	/**
	 * Gets the name of the animal entered by the user
	 * Trims any leading/trailing whitespace.
	 * 
	 * @return The animal name as a String
	 */
	public String getAnimalName() {
		return animalNameTextField.getText().trim();
	}

	/**
	 * Gets the age of the animal entered by the user
	 * Attempts to parse the text as an integer
	 * 
	 * @return The animal age as an Integer, or null if the input is not a valid integer
	 */
	public Integer getAnimalAge() {
		try {
			return Integer.parseInt(animalAgeTextField.getText().trim());
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	/**
	 * Gets the type of the animal entered by the user
	 * Uses strip() to remove leading/trailing whitespace
	 * 
	 * @return The animal type as a String
	 */
	public String getAnimalType() {
		return animalTypeTextField.getText().strip();
	}
	
	/**
	 * Gets the species of the animal entered by the user
	 * Trims any leading/trailing whitespace
	 * 
	 * @return The animal species as a String
	 */
	public String getAnimalSpecies() {
		return animalSpeciesTextField.getText().trim();
	}
	
	/**
	 * Adds an ActionListener to the submit button
	 * This listener will handle the action when the user submits the pet information
	 * 
	 * @param listener The ActionListener to add
	 */
	public void addActionListenerToSubmitButton(ActionListener listener) {
		submitPetButton.addActionListener(listener);
	}
}