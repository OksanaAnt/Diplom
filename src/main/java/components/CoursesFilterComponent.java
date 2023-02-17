package components;

import data.CategoryData;
import data.menu.SubMenuCategoryCoursesItemData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.security.auth.login.CredentialException;

public class CoursesFilterComponent extends AbsBaseComponent {

    public CoursesFilterComponent(WebDriver driver) {
        super(driver);
    }

    private String courseCategoryCheckTestingLocator = "//div[./label[text()='Тестирование']]//input";
    private String courseCategoryCheckEventsLocator = "//div[./label[text()='Календарь мероприятий']]//input";

    public CoursesFilterComponent coursesFilterState(CategoryData categoryData, boolean state) {
        String locator = String.format(courseCategoryCheckTestingLocator, categoryData.getName());

        Assertions.assertEquals(state, driver.findElement(By.xpath(locator)).isSelected());

        return this;
    }
}
