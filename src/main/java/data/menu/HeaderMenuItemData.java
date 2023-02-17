package data.menu;

import components.HeaderMenuComponent;
import org.openqa.selenium.WebDriver;

public enum HeaderMenuItemData {
    LEARNING("learning");

    private String name;

    HeaderMenuItemData(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
