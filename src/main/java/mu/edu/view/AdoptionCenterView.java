package mu.edu.view;

import javax.swing.*;
import java.util.List;
import mu.edu.pet.Pet;

import java.awt.event.ActionListener; 


public class AdoptionCenterView extends JFrame{
	// My Version of UserInformationListView.java
	private JPanel panel;
	private JList list;
	private JButton deleteSelectedPets;
	private JButton saveButton; 
	private JComboBox<String> dropdown;
	
	private DefaultListModel<Pet> modelList;
	private JButton adoptSelectedAnimals;
	private JLabel dialogBox;
	private JButton viewDetailsButton;
	

	public AdoptionCenterView() {

		setTitle("Adoption Center");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,450);
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		setContentPane(panel);

		modelList = new DefaultListModel<>();
		list = new JList<>(modelList);
		list.setBounds(119, 76, 368, 196);
		panel.add(list);
		
		deleteSelectedPets = new JButton("Delete Selected Animals");
		deleteSelectedPets.setBounds(119, 284, 180, 33);
        panel.add(deleteSelectedPets);
		
        adoptSelectedAnimals = new JButton("Adopt Selected Animals");
        adoptSelectedAnimals.setBounds(327, 284, 161, 33);
		panel.add(adoptSelectedAnimals);
		
		String[] options = {"Name", "Age", "Species Name"};
		dropdown = new JComboBox<>(options);
		dropdown.setBounds(119, 43, 80, 22);
		panel.add(dropdown);
		
		saveButton = new JButton("Save List");
		saveButton.setBounds(398, 43, 89, 23);
		panel.add(saveButton);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText("Sort By:");
		lblNewLabel.setBounds(29, 43, 80, 22);
		panel.add(lblNewLabel);
		
		dialogBox = new JLabel();
		dialogBox.setText("Welcome!");
		dialogBox.setBounds(89,9,383,23);
		panel.add(dialogBox);
		
		viewDetailsButton = new JButton("View Details");
		viewDetailsButton.setBounds(245, 42, 95, 23);
		panel.add(viewDetailsButton);
		
	}
	
	public void addActionListenerToDeletePetsButton(ActionListener listener) {
		deleteSelectedPets.addActionListener(listener);
	}
	
	public void addActionListenerToAdoptPetsButton(ActionListener listener) {
		adoptSelectedAnimals.addActionListener(listener);
	}
	
	public void addActionListenerToSortingDropDown(ActionListener listener) {
		dropdown.addActionListener(listener);
	}
	
	public void addActionListenerToSaveButton(ActionListener listener) {
		saveButton.addActionListener(listener);
	}
	
	public void addActionListenerToViewDetailsButton(ActionListener listener) {
		viewDetailsButton.addActionListener(listener);
	}
	
	public void setDialogue(String text) {
		dialogBox.setText(text);
	}
	
	public DefaultListModel<Pet> getPetList() {
		return (DefaultListModel<Pet>) list.getModel();
	}
	
	public int getSelectedPet() {
		System.out.println("Selected Pet index: " + list.getSelectedIndex());
		return list.getSelectedIndex();
	}
	
	public int[] getMultipleSelectedPets() {
		return list.getSelectedIndices();
	}
	
	public String getSelectedDropdown() {
		return (String) dropdown.getSelectedItem();
	}

    public void updatePetList(List<Pet> pets) {
        modelList.clear();
        for (Pet pet : pets) {
            modelList.addElement(pet);
        }
    }

    public JButton getDeleteButton() {
        return deleteSelectedPets;
    }

    public JButton getAdoptButton() {
        return adoptSelectedAnimals;
    }
}
