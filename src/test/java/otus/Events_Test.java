package otus;

import components.HeaderMenuComponent;
import components.events.EventsType;
import data.events.EventTypeTextData;
import data.events.EventTypesData;
import data.events.EventsNewOrOldData;
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
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void EventsDateTesting() {
        MainPage mainPage = new MainPage(driver);
        EventsPage eventsPage = new EventsPage(driver);
        HeaderMenuComponent headerMenuComponent = new HeaderMenuComponent(driver);

        mainPage
                .open();
        components.popups.HeaderSubMenuPopup headerSubMenuPopup = new components.popups.HeaderSubMenuPopup(driver);
        headerSubMenuPopup.popupShouldNotBeVisible(HeaderMenuItemData.LEARNING);

        headerMenuComponent
                .moveCursorToHeaderItem(HeaderMenuItemData.LEARNING);
        headerSubMenuPopup.popupShouldBeVisible(HeaderMenuItemData.LEARNING);
        headerSubMenuPopup.clickSubMenuItemByNameEvents(SubMenuCategoryCoursesItemData.EVENTS);

        eventsPage
                .clickEventNewOrOld(EventsNewOrOldData.EVENTSOLD);
//        eventsPage
//                .scrollLastElements();
//        eventsPage
//                .countEvents(EventTypeTextData.TEXTVEBINAR);
        eventsPage
                .checkEventsDate();
    }

    @Test
    public void EventsTypeTesting() {

        MainPage mainPage = new MainPage(driver);
        EventsPage eventsPage = new EventsPage(driver);
        EventsType eventsType = new EventsType(driver);
        HeaderMenuComponent headerMenuComponent = new HeaderMenuComponent(driver);

        mainPage.open();
        components.popups.HeaderSubMenuPopup headerSubMenuPopup = new components.popups.HeaderSubMenuPopup(driver);
        headerSubMenuPopup.popupShouldNotBeVisible(HeaderMenuItemData.LEARNING);

        headerMenuComponent
                .moveCursorToHeaderItem(HeaderMenuItemData.LEARNING);
        headerSubMenuPopup.popupShouldBeVisible(HeaderMenuItemData.LEARNING);
        headerSubMenuPopup.clickSubMenuItemByNameEvents(SubMenuCategoryCoursesItemData.EVENTS);

        eventsPage
                .clickEventNewOrOld(EventsNewOrOldData.EVENTSNEW);

        eventsType
                .clickEventType();
        eventsType
                .selectEventType(EventTypesData.DOD);
        eventsType
                .checkEventTypeText(EventTypeTextData.TEXTDOD);
    }

}
