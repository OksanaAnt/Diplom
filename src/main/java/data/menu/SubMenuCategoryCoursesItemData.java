package data.menu;

public enum SubMenuCategoryCoursesItemData implements ISubMenu {
    TESTING("Testing"),
    EVENTS("Календарь мероприятий");
    private String name;

    SubMenuCategoryCoursesItemData (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
