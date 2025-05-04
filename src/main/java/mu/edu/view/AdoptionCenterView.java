package mu.edu.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import mu.edu.pet.Pet;

public class AdoptionCenterView extends JFrame {
    private JPanel panel;
    private JList<Pet> list;
    private DefaultListModel<Pet> modelList;
    private JButton deleteSelectedAnimals;
    private JButton adoptSelectedAnimals;
    private JButton saveButton;
    private JComboBox<String> sortCombo;

    public AdoptionCenterView() {
        setTitle("Adoption Center");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        setContentPane(panel);

        // 🔼 Sort Dropdown
        sortCombo = new JComboBox<>(new String[] { "Sort by Name", "Sort by Age", "Sort by Species" });
        sortCombo.setBounds(40, 20, 180, 30);
        panel.add(sortCombo);

        // 💾 Save Button
        saveButton = new JButton("Save List to File");
        saveButton.setBounds(230, 20, 180, 30);
        panel.add(saveButton);

        // 📜 Pet List
        modelList = new DefaultListModel<>();
        list = new JList<>(modelList);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(40, 70, 500, 280);
        panel.add(scrollPane);

        // 🐾 Adopt Button
        adoptSelectedAnimals = new JButton("Adopt Selected");
        adoptSelectedAnimals.setBounds(100, 370, 160, 40);
        panel.add(adoptSelectedAnimals);

        // ❌ Delete Button
        deleteSelectedAnimals = new JButton("Delete Selected");
        deleteSelectedAnimals.setBounds(320, 370, 160, 40);
        panel.add(deleteSelectedAnimals);
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

    public JButton getSaveButton() {
        return saveButton;
    }

    public JComboBox<String> getSortCombo() {
        return sortCombo;
    }

    public DefaultListModel<Pet> getUserList() {
        return modelList;
    }
}
