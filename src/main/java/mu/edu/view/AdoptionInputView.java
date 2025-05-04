package mu.edu.view;

import javax.swing.*;

import java.awt.event.ActionListener;

public class AdoptionInputView extends JFrame {
	private JPanel panel;
	private JTextField animalNameTextField;
	private JTextField animalTypeTextField;
	private JTextField animalSpeciesTextField;
	private JTextField animalAgeTextField;
	private JButton submitUserButton;

	private JLabel lblNewLabel_3;
	private JTextField textField;
	private JLabel lblNewLabel_4;

	
	public AdoptionInputView() {
		setTitle("Submit User Information Page");
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
		
		submitUserButton = new JButton("Submit User");
		submitUserButton.setBounds(229, 288, 101, 23);
		panel.add(submitUserButton);
		
		JLabel lblNewLabel = new JLabel("Animal name:");
		lblNewLabel.setBounds(161, 93, 70, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Animal age:");
		lblNewLabel_1.setBounds(149, 138, 70, 14);
		panel.add(lblNewLabel_1);
		
		animalTypeTextField = new JTextField();
		animalTypeTextField.setBounds(229, 173, 96, 20);
		panel.add(animalTypeTextField);
		animalTypeTextField.setColumns(10);
		
		animalSpeciesTextField = new JTextField();
		animalSpeciesTextField.setBounds(229, 214, 96, 20);
		panel.add(animalSpeciesTextField);
		animalSpeciesTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Animal Type");
		lblNewLabel_2.setBounds(145, 175, 86, 17);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Animal Species");
		lblNewLabel_3.setBounds(149, 217, 75, 14);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(229, 245, 96, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Animal Age");
		lblNewLabel_4.setBounds(145, 248, 74, 14);
		panel.add(lblNewLabel_4);
	}

	public String getUserName() {
		return animalNameTextField.getText().trim();
	}

	public Integer getUserAge() {
		try {
			return Integer.parseInt(animalAgeTextField.getText().trim());
		} catch (NumberFormatException e) {
			return null;
		}
	}
	

	public void addSubmitListener(ActionListener listener) {
		submitUserButton.addActionListener(listener);
	}
}
