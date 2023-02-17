package components;

import org.openqa.selenium.WebDriver;
import pageobject.PageObject;

public abstract class AbsBaseComponent extends PageObject {
    // прокидываем в конструктор только драйвер
    public AbsBaseComponent(WebDriver driver) {
        super(driver);
    }
}
