package co.edu.uptc.view;

import javax.swing.JFrame;

import co.edu.uptc.presenter.Presenter;
import co.edu.uptc.structures.SimpleList;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private MainPanel mainPanel;
	private Presenter presenter;

	public View(Presenter presenter) {
		super("Matriculas Colegios Boyacá");
		this.presenter = presenter;
		initComponents();
		initListeners();
		initMetadata();
	}

	private void initMetadata() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void initComponents() {
		mainPanel = new MainPanel();
		add(mainPanel);
	}

	private void initListeners() {
		mainPanel.getOptionsPanel().getDepartmentBtn().addActionListener(e -> {
			mainPanel.changePanel("department");
		});

		mainPanel.getMainDepartmentPanel().getByInstitutions().addActionListener(e -> {
			mainPanel.getMainDepartmentPanel().changePanel("showByInstitutions");
			mainPanel.getMainDepartmentPanel().getInsertMunicipalityPanel().clearNameField();
		});

		mainPanel.getMainDepartmentPanel().getInsert().addActionListener(e -> {
			mainPanel.getMainDepartmentPanel().changePanel("insert");
		});

		mainPanel.getMainDepartmentPanel().getByGrade().addActionListener(e -> {
			mainPanel.getMainDepartmentPanel().changePanel("showByGrades");
			mainPanel.getMainDepartmentPanel().getInsertMunicipalityPanel().clearNameField();
		});

		mainPanel.getOptionsPanel().getMunicipalityBtn().addActionListener(e -> {
			mainPanel.changePanel("municipality");
		});

		mainPanel.getMainMunicipalityPanel().getByCampuses().addActionListener(e -> {
			mainPanel.getMainMunicipalityPanel().changePanel("showByCampuses");
			mainPanel.getMainMunicipalityPanel().getInsertInstitutionPanel().clearNameField();
		});

		mainPanel.getMainMunicipalityPanel().getInsert().addActionListener(e -> {
			mainPanel.getMainMunicipalityPanel().changePanel("insert");
		});

		mainPanel.getMainMunicipalityPanel().getByGrade().addActionListener(e -> {
			mainPanel.getMainMunicipalityPanel().changePanel("showByGrades");
			mainPanel.getMainMunicipalityPanel().getInsertInstitutionPanel().clearNameField();
		});

		mainPanel.getOptionsPanel().getInstitutionBtn().addActionListener(e -> {
			mainPanel.changePanel("institution");
		});

		mainPanel.getMainInstitutionPanel().getInsertMenuItem().addActionListener(e -> {
			mainPanel.getMainInstitutionPanel().changePanel("insert");
		});

		mainPanel.getMainInstitutionPanel().getByGrade().addActionListener(e -> {
			mainPanel.getMainInstitutionPanel().changePanel("showByGrades");
			mainPanel.getMainInstitutionPanel().getInsertCampusPanel().clearNameField();
		});

		mainPanel.getMainDepartmentPanel().getShowByMunicipalitiesPanel().getMunicipalities().addActionListener(e -> {
			presenter.loadInstitutionsCombos(
					mainPanel.getMainDepartmentPanel().getShowByMunicipalitiesPanel().getMunicipality());
		});
		
//		mainPanel.getMainInstitutionPanel().get

	}

	public void loadMunicipalityCombos(SimpleList<String> municipalities) {
		mainPanel.getMainDepartmentPanel().getShowByMunicipalitiesPanel().loadMunicipalities(municipalities);
		mainPanel.getMainDepartmentPanel().getShowByGradesPanel().loadMunicipalities(municipalities);
	}

	public void loadInstitutionsCombos(SimpleList<String> institutions) {
		mainPanel.getMainMunicipalityPanel().getShowByInstitutionsPanel().loadInstitutions(institutions);
		mainPanel.getMainMunicipalityPanel().getShowByGradesPanel().loadInstitutions(institutions);
	}

	public void loadCampusesCombo(SimpleList<String> campuses) {
		mainPanel.getMainInstitutionPanel().getShowByGradesPanel().loadCampuses(campuses);
	}
}
