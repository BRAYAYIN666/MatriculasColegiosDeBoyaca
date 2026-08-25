package co.edu.uptc.model;

import java.util.ArrayList;

public class Campus {

    private String name;
    private ArrayList<Grade> grades = new ArrayList<>();
    
    public Campus(String name, int code) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public int getTotalByCampus() {
        int total = 0;
        if (grades != null) {
            for (Grade grade : grades) {
                if (grade != null) {
                    total += grade.getNumberStudents();
                }
            }
        }
        return total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Grade> grades) {
        this.grades = grades;
    }
}
