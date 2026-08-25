package co.edu.uptc.model;

import co.edu.uptc.structures.DoubleList;

public class Municipality {
    private String name;
    private DoubleList<Institution> institutions = new DoubleList<>();

    public Municipality(String name) {
        this.name = name;
        this.institutions = new DoubleList<>();
    }

    public void addInstitution(Institution institution){
        institutions.add(institution);
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
