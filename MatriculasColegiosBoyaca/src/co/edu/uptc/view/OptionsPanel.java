package co.edu.uptc.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import co.edu.uptc.view.ui.ShapedButtonUI;

public class OptionsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton departmentBtn;
	private JButton municipalityBtn;
	private JButton institutionBtn;

	public OptionsPanel() {
		initMetadata();
		initComponents();
		addComponents();
	}

	private void addComponents() {
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(20, 2, 0, 2);
		add(departmentBtn, gbc);

		gbc.gridy = 1;
		add(municipalityBtn, gbc);

		gbc.gridy = 2;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.NORTH;
		add(institutionBtn, gbc);
	}

	private void initComponents() {
		departmentBtn = createBtn("Departamento");
		municipalityBtn = createBtn("Municipio");
		institutionBtn = createBtn("Institución");
	}

	private JButton createBtn(String content) {
		JButton button = new JButton(content);
		button.setBackground(new Color(68, 212, 242));
		button.setUI(new ShapedButtonUI());
		return button;
	}

	private void initMetadata() {
		this.setBackground(new Color(177, 236, 250));
		this.setLayout(new GridBagLayout());
	}

	public JButton getDepartmentBtn() {
		return departmentBtn;
	}

	public JButton getMunicipalityBtn() {
		return municipalityBtn;
	}

	public JButton getInstitutionBtn() {
		return institutionBtn;
	}

}
