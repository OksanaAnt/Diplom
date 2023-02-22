package components.events;

import components.AbsBaseComponent;
import data.events.EventTypeTextData;
import data.events.EventTypesData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EventsType extends AbsBaseComponent {
    public EventsType(WebDriver driver) {
        super(driver);
    }

    private String listTypesSelector = ".dod_new-events-dropdown>div>svg";

    private String selectTypeSelector = "a[title='%s']";

    private String checkTypeLocator = "//div[contains(text(),'%s')]";


    public void clickEventType() {
        String selector = String.format(listTypesSelector);
        driver.findElement(By.cssSelector(selector)).click();
    }

    public void selectEventType(EventTypesData eventTypesData) {
        String selector = String.format(selectTypeSelector, eventTypesData.getName());
        driver.findElement(By.cssSelector(selector)).click();
    }

    public EventsType checkEventTypeText(EventTypeTextData eventTypeTextData) {
        String locator = String.format(checkTypeLocator, eventTypeTextData.getName());
        Assertions.assertEquals(true, driver.findElement(By.xpath(locator)).isDisplayed());
        return this;
    }
}




