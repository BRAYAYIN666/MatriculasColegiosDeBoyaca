package co.edu.uptc.model;

import co.edu.uptc.structures.DoubleList;

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

    public Institution getInstitution(String name) {
        for (Institution institution : institutions) {
            if (institution.getName().equalsIgnoreCase(name)) {
                return institution;
            }
        }
        return null;
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

    public void setInstitutions(
            DoubleList<Institution> institutions) {

        this.institutions = institutions;
    }
}