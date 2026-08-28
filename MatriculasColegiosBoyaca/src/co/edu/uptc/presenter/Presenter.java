package co.edu.uptc.presenter;

import co.edu.uptc.model.Campus;
import co.edu.uptc.model.Department;
import co.edu.uptc.model.Institution;
import co.edu.uptc.model.Municipality;
import co.edu.uptc.structures.SimpleList;
import co.edu.uptc.view.View;

public class Presenter {

	private View view;
	private Department department;

	public Presenter() {
		department = new Department();
		view = new View(this);
		loadMunicipalitiesCombo();
	}

	public void loadMunicipalitiesCombo() {
		SimpleList<String> municipalities = new SimpleList<String>();
		for (Municipality mun : department.getMunicipalities()) {
			municipalities.add(mun.getName());
		}
		view.loadMunicipalityCombos(municipalities);
	}

	public void loadInstitutionsCombos(String municipality) {
		SimpleList<String> institutions = new SimpleList<String>();
		for (Institution ins : department.searchMunicipality(municipality).getInstitutions()) {
			institutions.add(ins.getName());
		}
		view.loadInstitutionsCombos(institutions);
	}

	public void loadCampusesCombos(String institution, String municipality) {
		SimpleList<String> campuses = new SimpleList<String>();
		for (Campus cam : department.searchMunicipality(municipality).searchInstitution(institution).getCampuses()) {
			campuses.add(cam.getName());
		}
		view.loadCampusesCombo(campuses);
	}

	public void createMunicipality(String municipality) {
		department.addMunicipality(new Municipality(municipality));
		loadMunicipalitiesCombo();
	}

	public void createInstitution(String institution, String municipality) {
		department.searchMunicipality(municipality).addInstitution(new Institution(institution));
		loadInstitutionsCombos(municipality);
	}

	public void createCampuse(String campus, String institution, String municipality) {
		department.searchMunicipality(municipality).searchInstitution(institution).addCampus(new Campus(campus, null));
		loadCampusesCombos(institution, municipality);
	}

	public void loadGradesByMunicipality(String municipality) {
		view.loadGradesTable(department.totalGradesByMunicipality(municipality));
	}

	// SIRVE LA FUNCIONALIDAD DE INSERTAR MUNICIPIO, INSTITUCION y SEDE

	public static void main(String[] args) {
		new Presenter();
	}

}
