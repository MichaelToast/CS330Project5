package mu.edu.view;

import javax.swing.*;

import java.awt.event.ActionListener;

public class AdoptionInputView extends JFrame {
	private JPanel panel;
	private JTextField userNameTextField;
	private JTextField userAgeTextField;
	private JButton submitUserButton;

	public AdoptionInputView() {
		
		setTitle("Submit User Information Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		

		
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		JLabel userNameLabel = new JLabel("Enter User Name:");
		userNameTextField = new JTextField(10);
		JLabel userAgeLabel = new JLabel("Enter User Age:");
		userAgeTextField = new JTextField(10);
		submitUserButton = new JButton("Submit");

		panel.add(userNameLabel);
		panel.add(userNameTextField);
		panel.add(Box.createVerticalStrut(10));

		panel.add(userAgeLabel);
		panel.add(userAgeTextField);
		panel.add(Box.createVerticalStrut(20));

		panel.add(submitUserButton);
	}

	public String getUserName() {
		return userNameTextField.getText().trim();
	}

	public Integer getUserAge() {
		try {
			return Integer.parseInt(userAgeTextField.getText().trim());
		} catch (NumberFormatException e) {
			return null;
		}
	}
	

	public void addSubmitListener(ActionListener listener) {
		submitUserButton.addActionListener(listener);
	}
}
