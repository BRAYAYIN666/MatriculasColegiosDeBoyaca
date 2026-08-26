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

	public int getTotalStudents() {
		int total = 0;
		for (Municipality municipality : municipalities) {
			total += municipality.getTotalStudents();
		}
		return total;
	}

	public int getTotalByGrade(int position) {
		int total = 0;
		for (Municipality municipality : municipalities) {
			total += municipality.getTotalByGrade(position);
		}
		return total;
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

	public void setMunicipalities(SimpleList<Municipality> municipalities) {
		this.municipalities = municipalities;
	}

}