package co.edu.uptc.view.municipality;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.uptc.structures.SimpleList;

public class ShowByInstitutionsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JComboBox<String> institutions;
	private JLabel institutionsLlb;
	private JPanel separator1;
	private JPanel separator2;
	private JTable institutionsTable;
	private DefaultTableModel tableModel;

	public ShowByInstitutionsPanel() {
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
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(15, 0, 10, 0);
		add(institutionsLlb, gbc);

		gbc.gridy = 1;
		add(institutions, gbc);

		gbc.gridy = 2;
		add(separator1, gbc);

		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		add(new JScrollPane(institutionsTable), gbc);

		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(separator2, gbc);
	}

	private void initComponents() {
		institutions = new JComboBox<String>();
		institutionsLlb = new JLabel("Seleccione la institución: ");
		institutionsLlb.setFont(new Font("Segoe UI", Font.BOLD, 25));
		separator1 = createSeparator();
		separator2 = createSeparator();
		tableModel = new DefaultTableModel(new String[] { "Sede", "Estudiantes" }, 0);
		institutionsTable = new JTable(tableModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}

	private JPanel createSeparator() {
		JPanel separator = new JPanel();
		separator.setPreferredSize(new Dimension(10, 2));
		separator.setBackground(new Color(120, 119, 119));
		return separator;
	}

	public void fillTable(SimpleList<String> campuses, SimpleList<String> students) {
		for (int i = 0; i < campuses.size(); i++) {
			tableModel.addRow(new Object[] { campuses.get(i), students.get(i) });
		}

	}

	public void loadInstitutions(SimpleList<String> institutions) {
		this.institutions.removeAllItems();
		for (int i = 0; i < institutions.size(); i++) {
			this.institutions.addItem(institutions.get(i));
		}
	}

	public JComboBox<String> getInstitutions() {
		return institutions;
	}

	public String getInstitution() {
		return (String) institutions.getSelectedItem();
	}

}
