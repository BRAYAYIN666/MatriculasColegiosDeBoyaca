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

public class ShowByGradesPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JComboBox<String> institutions;
	private JLabel institutionsLbl;
	private JPanel separator1;
	private JPanel separator2;
	private JTable gradesTable;
	private DefaultTableModel tableModel;

	public ShowByGradesPanel() {
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
		add(institutionsLbl, gbc);

		gbc.gridy = 1;
		add(institutions, gbc);

		gbc.gridy = 2;
		add(separator1, gbc);

		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		add(new JScrollPane(gradesTable), gbc);

		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(separator2, gbc);
	}

	private void initComponents() {
		institutions = new JComboBox<String>();
		institutionsLbl = new JLabel("Seleccione la institución: ");
		institutionsLbl.setFont(new Font("Segoe UI", Font.BOLD, 25));
		separator1 = createSeparator();
		separator2 = createSeparator();
		tableModel = new DefaultTableModel(new String[] { "Grado", "Estudiantes" }, 0);
		gradesTable = new JTable(tableModel) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		gradesTable.setRowHeight(33);
		fillGradesValues();
	}

	private JPanel createSeparator() {
		JPanel separator = new JPanel();
		separator.setPreferredSize(new Dimension(10, 2));
		separator.setBackground(new Color(120, 119, 119));
		return separator;
	}

	public void fillStudentsValues(SimpleList<String> students) {
		for (int i = 0; i < students.size(); i++) {
			tableModel.setValueAt((String) students.get(i), i, 0);
		}
	}

	private void fillGradesValues() {
		String[] grades = new String[] { "Prescolar", "Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto",
				"Séptimo", "Octavo", "Noveno", "Décimo", "Once" };
		for (String grade : grades) {
			tableModel.addRow(new Object[] { grade, 0 });
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
