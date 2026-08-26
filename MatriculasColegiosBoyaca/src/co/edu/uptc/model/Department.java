package co.edu.uptc.model;

import co.edu.uptc.structures.SimpleList;

public class Department {
	private final String NAME = "BOYACA";
	private SimpleList<Municipality> municipalities = new SimpleList<>();

	public Department() {
		this.municipalities = new SimpleList<>();
	}

	public void addMunicipality(Municipality municipality) {
		municipalities.add(municipality);
	}

	public String getNAME() {
		return NAME;
	}

	public SimpleList<Municipality> getMunicipalities() {
		return municipalities;
	}

	public void setMunicipalities(SimpleList<Municipality> municipalities) {
		this.municipalities = municipalities;
	}
}
