package data.courses;

public enum CoursesData {
    QALEAD ("qa-lead");
    private String name;
    CoursesData (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
