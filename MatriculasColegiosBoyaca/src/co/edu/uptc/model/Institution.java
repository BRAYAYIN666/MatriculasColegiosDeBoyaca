package co.edu.uptc.model;

import co.edu.uptc.structures.SimpleList;

public class Institution {

    private String name;
    private SimpleList<Campus> campuses;

    public Institution(String name) {
        this.name = name;
        this.campuses = new SimpleList<>();
    }

    public void addCampus(Campus campus) {
        campuses.add(campus);
    }

    public int getTotalStudents() {
        int total = 0;
        for (Campus campus : campuses) {
            total += campus.getTotalByCampus();
        }

        return total;
    }

        public int getTotalByGrade(int position) {
        int total = 0;
        for (Campus campus : campuses) {
            total += campus.getStudentsByGrade(position);
        }

        return total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SimpleList<Campus> getCampuses() {
        return campuses;
    }

    public void setCampuses(SimpleList<Campus> campuses) {
        this.campuses = campuses;
    }
}
