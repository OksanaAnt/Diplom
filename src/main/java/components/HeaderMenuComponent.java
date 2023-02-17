package components;

import data.menu.HeaderMenuItemData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenuComponent extends AbsBaseComponent {
    public HeaderMenuComponent(WebDriver driver) {
        super(driver);
    }
    // шаблон селектора для меню
    private String headerMenuSelector = "[data-name='%s'].header3__nav-item";

    public HeaderMenuComponent moveCursorToHeaderItem(HeaderMenuItemData headerMenuItemData) {
        // шаблон селектора для меню
        String selector = String.format("[data-name='%s'].header3__nav-item", headerMenuItemData.getName());
// наводим мышку на селектор
        actions
                .moveToElement(driver.findElement(By.cssSelector(selector)))
                .build()
                .perform();

        return this;
    }

}
