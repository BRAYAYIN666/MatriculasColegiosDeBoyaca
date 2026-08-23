package co.edu.uptc.view.institution;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.uptc.view.ui.ShapedButtonUI;

public class InsertCampusPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField nameField;
	private JLabel title;
	private JPanel separator1;
	private JPanel separator2;
	private JButton saveBtn;

	public InsertCampusPanel() {
		initMetadata();
		initComponents();
		addComponents();
	}

	private void initMetadata() {
		this.setBackground(new Color(230, 252, 252));
		this.setLayout(new GridBagLayout());
	}

	private void addComponents() {
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(20, 10, 0, 0);
		gbc.fill = GridBagConstraints.BOTH;
		add(title, gbc);

		gbc.gridy = 1;
		add(separator1, gbc);

		gbc.gridy = 2;
		gbc.gridwidth = 1;
		add(nameField, gbc);

		gbc.gridy = 3;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		add(separator2, gbc);

		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		add(saveBtn, gbc);
	}

	private void initComponents() {
		nameField = createTextField();
		title = createJLabel("Inserte el nombre de la nueva sede:");
		separator1 = createSeparator();
		separator2 = createSeparator();
		saveBtn = createBtn("Guardar");
	}

	private JPanel createSeparator() {
		JPanel separator = new JPanel();
		separator.setPreferredSize(new Dimension(10, 2));
		separator.setBackground(new Color(120, 119, 119));
		return separator;
	}

	private JTextField createTextField() {
		JTextField textField = new JTextField(20);
		textField.setForeground(new Color(75, 85, 99));
		textField.setFont(new Font("Segoe UI", Font.BOLD, 18));
		return textField;
	}

	private JLabel createJLabel(String content) {
		JLabel label = new JLabel(content);
		label.setFont(new Font("Segoe UI", Font.BOLD, 17));
		return label;
	}

	private JButton createBtn(String content) {
		JButton btn = new JButton("Guardar");
		btn.setForeground(Color.WHITE);
		btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setBackground(new Color(68, 212, 242));
		btn.setUI(new ShapedButtonUI());
		return btn;
	}

	public String getName() {
		return nameField.getText();
	}

	public void clearNameField() {
		nameField.setText("");
	}

	public JButton getSaveBtn() {
		return saveBtn;
	}
}
