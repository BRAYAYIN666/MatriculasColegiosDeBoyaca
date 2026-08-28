package co.edu.uptc.model;

import co.edu.uptc.persistence.Persistence;
import co.edu.uptc.structures.SimpleList;

public class Department {

	private final String NAME = "BOYACA";
	private SimpleList<Municipality> municipalities = new SimpleList<>();

	public Department() {
		this.municipalities = new SimpleList<>();
		createObjects();
	}

	private void createObjects() {
		Persistence persitence = new Persistence();
		persitence.loadFromFile(this);
	}

	public SimpleList<String> totalGradesByMunicipality(String municipalityName) {
		Municipality municipality = searchMunicipality(municipalityName);
		SimpleList<String> totalGrades = new SimpleList<String>();
		for (int i = 0; i < 12; i++) {
			totalGrades.add(String.valueOf(municipality.getTotalByGrade(i)));
		}
		return totalGrades;
	}

	public Municipality searchMunicipality(String munName) {
		for (Municipality municipality : municipalities) {
			if (municipality.getName().equals(munName)) {
				return municipality;
			}
		}
		return null;
	}

	public void addMunicipality(Municipality municipality) {
		if (searchMunicipality(municipality.getName()) == null) {
			municipalities.add(municipality);
		}
	}

	public String getName() {
		return NAME;
	}

	public SimpleList<Municipality> getMunicipalities() {
		return municipalities;
	}

}