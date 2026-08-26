package co.edu.uptc.model;

import co.edu.uptc.structures.DoubleList;

public class Municipality {

    private String name;
    private DoubleList<Institution> institutions;

    public Municipality(String name) {
        this.name = name;
        this.institutions = new DoubleList<>();
    }

    // Agregar una nueva institución
    public void addInstitution(Institution institution) {
        institutions.add(institution);
    }

    // Buscar una institución por nombre
    public Institution getInstitution(String name) {
        for (Institution institution : institutions) {
            if (institution.getName().equalsIgnoreCase(name)) {
                return institution;
            }
        }

        return null;
    }

    // Total de estudiantes matriculados en el municipio
    public int getTotalStudents() {
        int total = 0;

        for (Institution institution : institutions) {
            total += institution.getTotalStudents();
        }

        return total;
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