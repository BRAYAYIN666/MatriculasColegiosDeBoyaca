package co.edu.uptc.model;

import co.edu.uptc.structures.SimpleList;

public class Institution {
    
    private String name;
    private SimpleList<Campus> campus = new SimpleList<>();
    
    public Institution(String name) {
        this.name = name;
        this.campus = new SimpleList<>();
    }

    public void addCampus(Campus newCampus){
        campus.add(newCampus);
    }
    public int getTotalByInstitution(){
        int total = 0;
        for (Campus campus2 : campus) {
            total+= campus2.getTotalByCampus();
        }
        return total;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SimpleList<Campus> getCampus() {
        return campus;
    }

    public void setCampus(SimpleList<Campus> campus) {
        this.campus = campus;
    }

}
