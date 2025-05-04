package mu.edu.view;

import javax.swing.*;
import java.util.List;
import mu.edu.pet.Pet;

import java.awt.event.ActionListener; 

/**
 * The AdoptionCenterView class provides the main GUI for the pet adoption center
 * It displays a list of available pets and provides buttons for various operations
 * such as adopting, deleting, and viewing details of selected pets
 */
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
	
	/**
	 * Constructs a new AdoptionCenterView with all necessary UI components
	 * Sets up the main JFrame, list to display pets, buttons for actions,
	 * and a dropdown for sorting options
	 */
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
		list.setBounds(75, 76, 500, 196);
		panel.add(list);
		
		deleteSelectedPets = new JButton("Delete Selected Animals");
		deleteSelectedPets.setBounds(85, 284, 180, 33);
        panel.add(deleteSelectedPets);
		
        adoptSelectedAnimals = new JButton("Adopt Selected Animals");
        adoptSelectedAnimals.setBounds(338, 283, 180, 33);
		panel.add(adoptSelectedAnimals);
		
		String[] options = {"Name", "Age", "Species Name"};
		dropdown = new JComboBox<>(options);
		dropdown.setBounds(119, 43, 120, 22);
		panel.add(dropdown);
		
		saveButton = new JButton("Save List");
		saveButton.setBounds(382, 43, 110, 23);
		panel.add(saveButton);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText("Sort By:");
		lblNewLabel.setBounds(29, 43, 50, 22);
		panel.add(lblNewLabel);
		
		dialogBox = new JLabel();
		dialogBox.setText("Welcome!");
		dialogBox.setBounds(89,9,390,23);
		panel.add(dialogBox);
		
		viewDetailsButton = new JButton("View Details");
		viewDetailsButton.setBounds(245, 42, 120, 23);
		panel.add(viewDetailsButton);
		
	}
	
	/**
	 * Adds an ActionListener to the delete pets button
	 * 
	 * @param listener The ActionListener to add
	 */
	public void addActionListenerToDeletePetsButton(ActionListener listener) {
		deleteSelectedPets.addActionListener(listener);
	}
	
	/**
	 * Adds an ActionListener to the adopt pets button
	 * 
	 * @param listener The ActionListener to add
	 */
	public void addActionListenerToAdoptPetsButton(ActionListener listener) {
		adoptSelectedAnimals.addActionListener(listener);
	}
	
	/**
	 * Adds an ActionListener to the sorting dropdown menu
	 * 
	 * @param listener The ActionListener to add
	 */
	public void addActionListenerToSortingDropDown(ActionListener listener) {
		dropdown.addActionListener(listener);
	}
	
	/**
	 * Adds an ActionListener to the save button
	 * 
	 * @param listener The ActionListener to add
	 */
	public void addActionListenerToSaveButton(ActionListener listener) {
		saveButton.addActionListener(listener);
	}
	
	/**
	 * Adds an ActionListener to the view details button
	 * 
	 * @param listener The ActionListener to add
	 */
	public void addActionListenerToViewDetailsButton(ActionListener listener) {
		viewDetailsButton.addActionListener(listener);
	}
	
	/**
	 * Sets the text displayed in the dialog box
	 * 
	 * @param text The text to display
	 */
	public void setDialogue(String text) {
		dialogBox.setText(text);
	}
	
	/**
	 * Gets the pet list model
	 * 
	 * @return The DefaultListModel containing the pets
	 */
	public DefaultListModel<Pet> getPetList() {
		return (DefaultListModel<Pet>) list.getModel();
	}
	
	/**
	 * Gets the index of the currently selected pet in the list
	 * Prints the selected index to the console.
	 * 
	 * @return The index of the selected pet
	 */
	public int getSelectedPet() {
		System.out.println("Selected Pet index: " + list.getSelectedIndex());
		return list.getSelectedIndex();
	}
	
	/**
	 * Gets the indices of all selected pets when multiple selection is enabled
	 * 
	 * @return An array of indices for the selected pets
	 */
	public int[] getMultipleSelectedPets() {
		return list.getSelectedIndices();
	}
	
	/**
	 * Gets the currently selected item from the dropdown menu
	 * 
	 * @return The selected dropdown item as a String
	 */
	public String getSelectedDropdown() {
		return (String) dropdown.getSelectedItem();
	}

    /**
     * Updates the pet list with a new list of pets
     * Clears the current model and adds all pets from the provided list
     * 
     * @param pets The list of Pet objects to display
     */
    public void updatePetList(List<Pet> pets) {
        modelList.clear();
        for (Pet pet : pets) {
            modelList.addElement(pet);
        }
    }

    /**
     * Gets the delete button
     * 
     * @return The JButton for deleting selected pets
     */
    public JButton getDeleteButton() {
        return deleteSelectedPets;
    }

    /**
     * Gets the adopt button
     * 
     * @return The JButton for adopting selected pets
     */
    public JButton getAdoptButton() {
        return adoptSelectedAnimals;
    }
}