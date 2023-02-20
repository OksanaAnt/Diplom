package data.courses;

public enum CategoryData {
    TESTING("Testing");

    private String name;

    CategoryData (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
