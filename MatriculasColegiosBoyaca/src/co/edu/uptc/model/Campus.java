package co.edu.uptc.model;

import co.edu.uptc.structures.SimpleList;

public class Campus {

    private String name;
    private SimpleList<String> grades = new SimpleList<>();

    public Campus(String name, SimpleList<String> grades) {
        this.name = name;
        this.grades = grades;
    }

    public int getTotalByCampus() {
        int total = 0;
        if (grades != null) {
            for (String grade : grades) {
                if (grade != null && !grade.isBlank()) {
                    total += Integer.parseInt(grade);
                }
            }
        }
        return total;
    }

    public int getStudentsByGrade(int position) {
        int aux = 0;
        for (String grade : grades) {
            if (aux == position) {
                if (grade == null || grade.isBlank()) {
                    return 0;
                }
                return Integer.parseInt(grade);
            }
            aux++;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SimpleList<String> getGrades() {
        return grades;
    }

    public void setGrades(SimpleList<String> grades) {
        this.grades = grades;
    }
}
