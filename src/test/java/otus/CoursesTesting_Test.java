package otus;

import components.CoursesFilterComponent;
import components.HeaderMenuComponent;
import components.listcourses.InformationOfCoursesComponent;
import data.CategoryData;
import data.CoursesData;
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

public class CoursesTesting_Test {

    private WebDriver driver;

    //BeforeAll, потому что задача только скачать веб-драйвер и положить его в опред. папку, положить в опред.переменную JVM и прописать туда путь
    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }
    // создаем веб-драйвер перед каждым тестом, потому что когда создаем объект веб-дайвер, стартует веб-драйвер, сессия и браузер привязывается к опред сессии браузера (на случай многопоточность)
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
    public void CoursesTesting() {

        new MainPage(driver).open();
        components.popups.HeaderSubMenuPopup headerSubMenuPopup = new components.popups.HeaderSubMenuPopup(driver);
        headerSubMenuPopup.popupShouldNotBeVisible(HeaderMenuItemData.LEARNING);

        new HeaderMenuComponent(driver)
                .moveCursorToHeaderItem(HeaderMenuItemData.LEARNING);
        headerSubMenuPopup.popupShouldBeVisible(HeaderMenuItemData.LEARNING);
        headerSubMenuPopup.clickSubMenuItemByName(SubMenuCategoryCoursesItemData.TESTING);

        new CoursesFilterComponent(driver)
                .coursesFilterState(CategoryData.TESTING, true);

        new components.listcourses.CoursesGridComponent(driver)
                .clickButtonShowAll();

        new components.listcourses.CoursesGridComponent(driver)
                .countCourses(12)
                .coursesClick(CoursesData.QALEAD);

        new InformationOfCoursesComponent(driver)
                .coursesNameShouldBeSameAs("QA Lead")
                .coursesDescriptionShouldBeSameAs("Best Practice по Soft и Hard Skills для эффективного управления командами тестирования")
                .coursesDurationShouldBeSameAs("6 месяцев")
                .coursesFormatShouldBeSameAs("Онлайн");
    }
}
