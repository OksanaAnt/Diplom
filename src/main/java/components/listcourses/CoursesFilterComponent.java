package components.listcourses;

import components.AbsBaseComponent;
import data.courses.CategoryData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoursesFilterComponent extends AbsBaseComponent {

    public CoursesFilterComponent(WebDriver driver) {
        super(driver);
    }

    private String courseCategoryCheckTestingLocator = "//div[./label[text()='Тестирование']]//input";

    public CoursesFilterComponent coursesFilterState(CategoryData categoryData, boolean state) {
        String locator = String.format(courseCategoryCheckTestingLocator, categoryData.getName());

        Assertions.assertEquals(state, driver.findElement(By.xpath(locator)).isSelected());

        return this;
    }
}
