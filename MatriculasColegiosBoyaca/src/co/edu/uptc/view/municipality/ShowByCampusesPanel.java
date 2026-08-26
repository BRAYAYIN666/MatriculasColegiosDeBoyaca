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

public class ShowByCampusesPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JComboBox<String> campuses;
	private JLabel campusesLlb;
	private JPanel separator1;
	private JPanel separator2;
	private JTable institutionsTable;
	private DefaultTableModel tableModel;

	public ShowByCampusesPanel() {
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
		add(campusesLlb, gbc);

		gbc.gridy = 1;
		add(campuses, gbc);

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
		campuses = new JComboBox<String>();
		campusesLlb = new JLabel("Seleccione la institución: ");
		campusesLlb.setFont(new Font("Segoe UI", Font.BOLD, 25));
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

	public void loadCampuses(SimpleList<String> campuses) {
		for (int i = 0; i < campuses.size(); i++) {
			this.campuses.addItem(campuses.get(i));
		}
	}

}
