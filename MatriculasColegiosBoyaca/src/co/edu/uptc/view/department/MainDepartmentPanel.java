package co.edu.uptc.view.department;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class MainDepartmentPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public MainDepartmentPanel() {
		initMetadata();
		initComponents();
		addComponents();
	}

	private void addComponents() {
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.BOTH;
		gbc.weighty = 1.0;
		gbc.weightx = 0.1;

		gbc.weightx = 0.9;
		gbc.gridx = 1;
	}

	private void initComponents() {
	}

	private void initMetadata() {
		this.setBackground(new Color(230, 252, 252));
		this.setLayout(new GridBagLayout());
	}

}
