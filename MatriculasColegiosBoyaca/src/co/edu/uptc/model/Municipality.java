package co.edu.uptc.model;

import co.edu.uptc.structures.DoubleList;
import co.edu.uptc.structures.SimpleList;

public class Municipality {

	private String name;
	private DoubleList<Institution> institutions = new DoubleList<>();

	public Municipality(String name) {
		this.name = name;
	}

	public void addInstitution(Institution institution) {
		institutions.add(institution);
	}

	public int getTotalStudents() {
		int total = 0;
		for (Institution institution : institutions) {
			total += institution.getTotalStudents();
		}
		return total;
	}

	public int getTotalByGrade(int position) {
		int total = 0;
		for (Institution institution : institutions) {
			total += institution.getTotalByGrade(position);
		}
		return total;
	}

	public Institution searchInstitution(String name) {
		for (Institution institution : institutions) {
			if (institution.getName().equalsIgnoreCase(name)) {
				return institution;
			}
		}
		return null;
	}

	// Retorna una lista de los Campus con la cantidad de estudiantes
	// respectivamente.
	public SimpleList<String> totalByCampus(Institution institution) {
		SimpleList<String> totalCampus = new SimpleList<>();
		SimpleList<Campus> campus = institution.getCampuses();
		for (Campus tempCampus : campus) {
			totalCampus.add(String.valueOf(tempCampus.getTotalByCampus()));
		}
		return totalCampus;
	}

	// Retorna una lista de los cursos con la cantidad de estudiantes de la
	// institucion respectivamente.
	public SimpleList<String> totalByGrades(Institution institution) {
		SimpleList<String> totalGrades = new SimpleList<>();
		SimpleList<Campus> campus = institution.getCampuses();
		for (Campus tempCampus : campus) {
			int i = 0;
			totalGrades.add(String.valueOf(tempCampus.getStudentsByGrade(i)));
			i++;
		}
		return totalGrades;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DoubleList<Institution> getInstitutions() {
		return institutions;
	}

	public void setInstitutions(DoubleList<Institution> institutions) {

		this.institutions = institutions;
	}
}