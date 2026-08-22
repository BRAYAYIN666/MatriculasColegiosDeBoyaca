package co.edu.uptc.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import co.edu.uptc.view.department.MainDepartmentPanel;
import co.edu.uptc.view.institution.MainInstitutionPanel;
import co.edu.uptc.view.municipality.MainMunicipalityPanel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel container;
	private CardLayout cardLayout;
	private OptionsPanel optionsPanel;
	private MainDepartmentPanel mainDepartmentPanel;
	private MainInstitutionPanel mainInstitutionPanel;
	private MainMunicipalityPanel mainMunicipalityPanel;

	public MainPanel() {
		initMetadata();
		initComponents();
		addComponents();
	}

	private void addComponents() {
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.fill = GridBagConstraints.BOTH;
		gbc.weighty = 1.0;
		gbc.weightx = 0.1;
		add(optionsPanel, gbc);

		gbc.weightx = 0.9;
		gbc.gridx = 1;
		add(container, gbc);

		container.add(mainDepartmentPanel, "department");
		container.add(mainInstitutionPanel, "institution");
		container.add(mainMunicipalityPanel, "municipality");
	}

	private void initComponents() {
		cardLayout = new CardLayout();
		container = new JPanel(cardLayout);
		optionsPanel = new OptionsPanel();
		mainDepartmentPanel = new MainDepartmentPanel();
		mainInstitutionPanel = new MainInstitutionPanel();
		mainMunicipalityPanel = new MainMunicipalityPanel();
	}

	private void initMetadata() {
		this.setBackground(new Color(230, 252, 252));
		this.setLayout(new GridBagLayout());
	}

	public void changePanel(String panelName) {
		cardLayout.show(container, panelName);
	}

	public MainDepartmentPanel getMainDepartmentPanel() {
		return mainDepartmentPanel;
	}

	public MainInstitutionPanel getMainInstitutionPanel() {
		return mainInstitutionPanel;
	}

	public MainMunicipalityPanel getMainMunicipalityPanel() {
		return mainMunicipalityPanel;
	}
}
