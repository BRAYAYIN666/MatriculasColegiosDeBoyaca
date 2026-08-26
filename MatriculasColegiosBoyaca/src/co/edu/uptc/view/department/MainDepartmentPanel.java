package co.edu.uptc.view.department;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainDepartmentPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar;
	private JMenu insertMenu;
	private JMenu show;
	private JMenuItem insertMenuItem;
	private JMenuItem byInstitutions;
	private JMenuItem byGrade;
	private JPanel container;
	private CardLayout cardLayout;
	private InsertMunicipalityPanel insertPanel;
	private ShowByInstitutionsPanel showByInstitutionsPanel;
	private ShowByGradesPanel showByGradesPanel;

	public MainDepartmentPanel() {
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
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		add(menuBar, gbc);

		gbc.gridy = 1;
		gbc.weighty = 1.0;
		add(container, gbc);

		show.add(byGrade);
		show.addSeparator();
		show.add(byInstitutions);
		insertMenu.add(insertMenuItem);
		menuBar.add(insertMenu);
		menuBar.add(show);
		container.add(showByInstitutionsPanel, "showByInstitutions");
		container.add(insertPanel, "insert");
		container.add(showByGradesPanel, "showByGrades");
	}

	private void initComponents() {
		insertMenu = createMenu("Insertar municipio  ");
		insertMenuItem = createMenuItem("Insertar municipio");
		show = createMenu("Mostrar municipio");
		byInstitutions = createMenuItem("por instituciones");
		byGrade = createMenuItem("por grados");

		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(191, 242, 255));

		cardLayout = new CardLayout();
		container = new JPanel(cardLayout);

		insertPanel = new InsertMunicipalityPanel();
		showByInstitutionsPanel = new ShowByInstitutionsPanel();
		showByGradesPanel = new ShowByGradesPanel();
	}

	private JMenu createMenu(String content) {
		JMenu menu = new JMenu(content);
		menu.setFont(new Font("Segoe UI", Font.BOLD, 20));
		return menu;
	}

	private JMenuItem createMenuItem(String content) {
		JMenuItem menuItem = new JMenuItem(content);
		menuItem.setFont(new Font("Segoe UI", Font.BOLD, 20));
		return menuItem;
	}

	public void changePanel(String panelName) {
		cardLayout.show(container, panelName);
	}

	public JMenuItem getInsert() {
		return insertMenuItem;
	}

	public JMenuItem getByInstitutions() {
		return byInstitutions;
	}

	public JMenuItem getByGrade() {
		return byGrade;
	}

	public InsertMunicipalityPanel getInsertMunicipalityPanel() {
		return insertPanel;
	}

	public ShowByInstitutionsPanel getShowByInstitutionsPanel() {
		return showByInstitutionsPanel;
	}

	public ShowByGradesPanel getShowByGradesPanel() {
		return showByGradesPanel;
	}
}
