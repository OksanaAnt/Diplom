package otus;

import components.CoursesFilterComponent;
import components.HeaderMenuComponent;
import data.CategoryData;
import data.menu.HeaderMenuItemData;
import data.menu.SubMenuCategoryCoursesItemData;
import exceptions.BrowserNotSupportException;
import factories.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.events.EventsPage;
import waiters.StandartWaiter;

public class Events_Test {

    private WebDriver driver;


    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void init() throws BrowserNotSupportException {
        driver = new WebDriverFactory().createDriver();
    }


    @AfterEach
    public void close() {
        if(driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void EventsTesting() {
        new MainPage(driver).open();

        components.popups.HeaderSubMenuPopup headerSubMenuPopup = new components.popups.HeaderSubMenuPopup(driver);
        headerSubMenuPopup.popupShouldNotBeVisible(HeaderMenuItemData.LEARNING);

        new HeaderMenuComponent(driver)
                .moveCursorToHeaderItem(HeaderMenuItemData.LEARNING);
        headerSubMenuPopup.popupShouldBeVisible(HeaderMenuItemData.LEARNING);
        headerSubMenuPopup.clickSubMenuItemByNameEvents(SubMenuCategoryCoursesItemData.EVENTS);

        new EventsPage(driver)
                .scrollLastElements();
        new EventsPage(driver)
                .countEvents();

    }

}
