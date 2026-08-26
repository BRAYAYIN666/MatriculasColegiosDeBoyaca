package co.edu.uptc.view.municipality;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainMunicipalityPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar;
	private JMenu insertMenu;
	private JMenu show;
	private JMenuItem insertMenuItem;
	private JMenuItem byCampuses;
	private JMenuItem byGrade;
	private JPanel container;
	private CardLayout cardLayout;
	private InsertInstitutionPanel insertInstitutionPanel;
	private ShowByCampusesPanel showByCampusesPanel;
	private ShowByGradesPanel showByGradesPanel;

	public MainMunicipalityPanel() {
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
		show.add(byCampuses);
		insertMenu.add(insertMenuItem);
		menuBar.add(insertMenu);
		menuBar.add(show);
		container.add(showByCampusesPanel, "showByCampuses");
		container.add(insertInstitutionPanel, "insert");
		container.add(showByGradesPanel, "showByGrades");
	}

	private void initComponents() {
		insertMenu = createMenu("Insertar institución  ");
		insertMenuItem = createMenuItem("Insertar institución");
		show = createMenu("Mostrar institución");
		byCampuses = createMenuItem("por sedes");
		byGrade = createMenuItem("por grados");

		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(191, 242, 255));

		cardLayout = new CardLayout();
		container = new JPanel(cardLayout);

		insertInstitutionPanel = new InsertInstitutionPanel();
		showByCampusesPanel = new ShowByCampusesPanel();
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

	public JMenuItem getByCampuses() {
		return byCampuses;
	}

	public JMenuItem getByGrade() {
		return byGrade;
	}

	public InsertInstitutionPanel getInsertInstitutionPanel() {
		return insertInstitutionPanel;
	}

	public ShowByCampusesPanel getShowByCampusesPanel() {
		return showByCampusesPanel;
	}

	public ShowByGradesPanel getShowByGradesPanel() {
		return showByGradesPanel;
	}
}
