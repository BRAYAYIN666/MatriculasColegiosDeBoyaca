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

    public Municipality getMunicipality(String name) {
        for (Municipality municipality : municipalities) {
            if (municipality.getName().equalsIgnoreCase(name)) {
                return municipality;
            }
        }
        return null;
    }

    public String getName() {
        return NAME;
    }

    public SimpleList<Municipality> getMunicipalities() {
        return municipalities;
    }

    public void setMunicipalities(
            SimpleList<Municipality> municipalities) {
        this.municipalities = municipalities;
    }

}