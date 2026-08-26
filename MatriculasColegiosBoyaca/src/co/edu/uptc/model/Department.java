package co.edu.uptc.model;

import co.edu.uptc.structures.SimpleList;

public class Department {

    private String name;
    private SimpleList<Municipality> municipalities;

    public Department(String name) {
        this.name = name;
        this.municipalities = new SimpleList<>();
    }

    // Agregar un nuevo municipio
    public void addMunicipality(Municipality municipality) {
        municipalities.add(municipality);
    }

    // Buscar un municipio por nombre
    public Municipality getMunicipality(String name) {
        for (Municipality municipality : municipalities) {
            if (municipality.getName().equalsIgnoreCase(name)) {
                return municipality;
            }
        }

        return null;
    }

    // Total de estudiantes matriculados en todo el departamento
    public int getTotalStudents() {
        int total = 0;

        for (Municipality municipality : municipalities) {
            total += municipality.getTotalStudents();
        }

        return total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SimpleList<Municipality> getMunicipalities() {
        return municipalities;
    }

    public void setMunicipalities(
            SimpleList<Municipality> municipalities) {
        this.municipalities = municipalities;
    }
}