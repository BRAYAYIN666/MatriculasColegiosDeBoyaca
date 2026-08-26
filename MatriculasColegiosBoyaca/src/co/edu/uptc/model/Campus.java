package co.edu.uptc.model;

import co.edu.uptc.structures.SimpleList;

public class Campus {

    private String name;
    private String code;
    private SimpleList<Integer> grades;

    public Campus(String name, String code) {
        this.name = name;
        this.code = code;
        this.grades = new SimpleList<>();
    }

    public void addGrade(int numberStudents) {
        grades.add(numberStudents);
    }

    public int getTotalByCampus() {
        int total = 0;

        for (Integer numberStudents : grades) {
            if (numberStudents != null) {
                total += numberStudents;
            }
        }

        return total;
    }

    public int getStudentsByGrade(int position) {
        return grades.get(position);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SimpleList<Integer> getGrades() {
        return grades;
    }

    public void setGrades(SimpleList<Integer> grades) {
        this.grades = grades;
    }
}