package mu.edu.view;

import javax.swing.*;
import java.util.List;
import mu.edu.pet.Pet;


public class AdoptionCenterView extends JFrame{
	// My Version of UserInformationListView.java
	private JPanel panel;
	private JList<Pet> list;
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
		
		deleteSelectedAnimals = new JButton("Delete Selected Animals");
		deleteSelectedAnimals.setBounds(121, 304, 161, 36);
		panel.add(deleteSelectedAnimals);
		
		adoptSelectedAnimals = new JButton("Adopt Selected Animals");
		adoptSelectedAnimals.setBounds(309, 306, 161, 33);
		panel.add(adoptSelectedAnimals);
		
	}

    public void updatePetList(List<Pet> pets) {
        modelList.clear();
        for (Pet pet : pets) {
            modelList.addElement(pet);
        }
    }

    public Pet getSelectedPet() {
        return list.getSelectedValue();
    }

    public JButton getDeleteButton() {
        return deleteSelectedAnimals;
    }

    public JButton getAdoptButton() {
        return adoptSelectedAnimals;
    }

}
