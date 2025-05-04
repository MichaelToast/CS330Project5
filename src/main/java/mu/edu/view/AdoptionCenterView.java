package mu.edu.view;

import javax.swing.*;
import java.util.List;
import mu.edu.pet.Pet;

import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextArea; 


public class AdoptionCenterView extends JFrame{
	// My Version of UserInformationListView.java
	private JPanel panel;
	private JList list;
	private JButton deleteSelectedPets;
	private JButton adoptSelectedPets;
	private JButton saveButton; 
	private JTextArea textArea;
	private JComboBox sortingDropDown;
	
	private DefaultListModel<Pet> modelList;
	private JButton deleteSelectedAnimals;
	private JButton adoptSelectedAnimals;

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
		deleteSelectedPets.setBounds(121, 304, 161, 36);
		panel.add(deleteSelectedPets);
		
		adoptSelectedPets = new JButton("Addopt Selected Animals");
		adoptSelectedPets.setBounds(309, 306, 161, 33);
		panel.add(adoptSelectedPets);
		adoptSelectedAnimals = new JButton("Adopt Selected Animals");
		adoptSelectedAnimals.setBounds(309, 306, 161, 33);
		panel.add(adoptSelectedAnimals);
		
		sortingDropDown = new JComboBox();
		sortingDropDown.setBounds(119, 43, 56, 22);
		panel.add(sortingDropDown);
		
		textArea = new JTextArea();
		textArea.setBounds(207, 351, 151, 22);
		panel.add(textArea);
		
		saveButton = new JButton("New button");
		saveButton.setBounds(398, 43, 89, 23);
		panel.add(saveButton);
	}
	
	public void addActionListenerToDeletePetsButton(ActionListener listener) {
		deleteSelectedPets.addActionListener(listener);
	}
	
	public void addActionListenerToAdoptPetsButton(ActionListener listener) {
		deleteSelectedPets.addActionListener(listener);
	}
	
	public DefaultListModel<Pet> getUserList() {
		return (DefaultListModel<Pet>) list.getModel();
	}
	
	public int getSelectedUser() {
		System.out.println("Selected Pet index: " + list.getSelectedIndex());
		return list.getSelectedIndex();
	}
	
	public int[] getMultipleSelectedPets() {
		return list.getSelectedIndices();
	}

    public void updatePetList(List<Pet> pets) {
        modelList.clear();
        for (Pet pet : pets) {
            modelList.addElement(pet);
        }
    }

    public Pet getSelectedPet() {
        return (Pet) list.getSelectedValue();
    }

    public JButton getDeleteButton() {
        return deleteSelectedAnimals;
    }

    public JButton getAdoptButton() {
        return adoptSelectedAnimals;
    }
}
