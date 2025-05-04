package mu.edu.view;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import mu.edu.model.Shelter;
import mu.edu.pet.Pet;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
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
	
	public AdoptionCenterView() {
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		DefaultListModel<Pet> modelList = new DefaultListModel<Pet>();
		
		list = new JList<Pet>(modelList);
		
		list.setBounds(119, 76, 368, 196);
		panel.add(list);
		
		deleteSelectedPets = new JButton("Delete Selected Animals");
		deleteSelectedPets.setBounds(121, 304, 161, 36);
		panel.add(deleteSelectedPets);
		
		adoptSelectedPets = new JButton("Addopt Selected Animals");
		adoptSelectedPets.setBounds(309, 306, 161, 33);
		panel.add(adoptSelectedPets);
		
		
		/*
		sortingDropDown = new JComboBox();
		sortingDropDown.setBounds(119, 43, 56, 22);
		panel.add(sortingDropDown);
		
		textArea = new JTextArea();
		textArea.setBounds(207, 351, 151, 22);
		panel.add(textArea);
		
		saveButton = new JButton("New button");
		saveButton.setBounds(398, 43, 89, 23);
		panel.add(saveButton);
		*/
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
	
	
}
