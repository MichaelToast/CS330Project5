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
	private JTextArea textArea;
	private JComboBox sortingDropDown;
	
	private DefaultListModel<Pet> modelList;
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
		deleteSelectedPets.setBounds(100, 280, 180, 35);
        panel.add(deleteSelectedPets);
		
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
		adoptSelectedAnimals.addActionListener(listener);
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
