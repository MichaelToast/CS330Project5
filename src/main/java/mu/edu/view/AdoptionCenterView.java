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

public class AdoptionCenterView extends JFrame{
	// My Version of UserInformationListView.java
	private JPanel panel;
	private JList list;
	private JButton deleteSelectedAnimals;
	private JButton adoptSelectedAnimals;
	
	public AdoptionCenterView() {
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		DefaultListModel<Pet> modelList = new DefaultListModel<Pet>();
		
		list = new JList<Pet>(modelList);
		
		list.setBounds(119, 76, 368, 196);
		panel.add(list);
		
		deleteSelectedAnimals = new JButton("Delete Selected Animals");
		deleteSelectedAnimals.setBounds(121, 304, 161, 36);
		panel.add(deleteSelectedAnimals);
		
		adoptSelectedAnimals = new JButton("Addopt Selected Animals");
		adoptSelectedAnimals.setBounds(309, 306, 161, 33);
		panel.add(adoptSelectedAnimals);
		
	}
}
