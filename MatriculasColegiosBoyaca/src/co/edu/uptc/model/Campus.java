package co.edu.uptc.model;

import co.edu.uptc.structures.SimpleList;

public class Campus {

    private String name;
    private SimpleList<String> grades = new SimpleList<>();
    
    public Campus(String name, int code) {
        this.name = name;
        this.grades = new SimpleList<>();
    }

    public int getTotalByCampus() {
        int total = 0;
        if (grades != null) {
            for (String grade : grades) {
                if (grade != null) {
                    total += Integer.parseInt(grade);
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

    public SimpleList<String> getGrades() {
        return grades;
    }

    public void setGrades(SimpleList<String> grades) {
        this.grades = grades;
    }
}
