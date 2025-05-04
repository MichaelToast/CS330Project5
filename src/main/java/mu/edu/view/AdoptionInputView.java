package mu.edu.view;

import javax.swing.*;

import java.awt.event.ActionListener;

public class AdoptionInputView extends JPanel{
	private JTextField userNameTextField;
	private JTextField userAgeTextField;
	private JButton submitUserButton;

	public AdoptionInputView() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		JLabel userNameLabel = new JLabel("Enter User Name:");
		userNameTextField = new JTextField(10);
		JLabel userAgeLabel = new JLabel("Enter User Age:");
		userAgeTextField = new JTextField(10);
		submitUserButton = new JButton("Submit");

		add(userNameLabel);
		add(userNameTextField);
		add(Box.createVerticalStrut(10));

		add(userAgeLabel);
		add(userAgeTextField);
		add(Box.createVerticalStrut(20));

		add(submitUserButton);
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
