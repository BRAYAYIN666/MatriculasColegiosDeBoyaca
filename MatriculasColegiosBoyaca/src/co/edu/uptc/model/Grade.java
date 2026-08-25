package co.edu.uptc.model;

public class Grade {
    private String name;
    private int numberStudents;

    public Grade(String name, int numberStudents) {
        this.name = name;
        this.numberStudents = numberStudents;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumberStudents() {
        return numberStudents;
    }
    public void setNumberStudents(int numberStudents) {
        this.numberStudents = numberStudents;
    }
}
