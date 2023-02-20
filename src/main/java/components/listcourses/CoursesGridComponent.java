package components.listcourses;

import components.AbsBaseComponent;
import data.courses.CoursesData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CoursesGridComponent extends AbsBaseComponent {
    public CoursesGridComponent(WebDriver driver) {
        super(driver);
    }

    private String coursesHrefLocator = "//div[contains(text(), 'Каталог')]//ancestor::section//a[contains(@href,'')]";
    private String buttonShowAllLocator = "//button[contains(text(),'Показать')]";

    private String coursesNameLocator  ="//div[contains(text(), 'Каталог')]//ancestor::section//a[contains(@href,'/lessons/%s')]";

    private List<WebElement> coursesList = new ArrayList<>();

    public void clickButtonShowAll () {
        WebElement element = driver.findElement(By.xpath(buttonShowAllLocator));
        if (element.isDisplayed()) {
            element.click();
        }
    }

    public CoursesGridComponent countCourses (int number) {
        coursesList = driver.findElements(By.xpath(coursesHrefLocator));
        int numberCourses = coursesList.size();
        Assertions.assertEquals(number,numberCourses);
        return this;
    }

    public void coursesClick (CoursesData coursesData) {
        String locator = String.format(coursesNameLocator, coursesData.getName());
        driver.findElement(By.xpath(locator)).click();
    }

}
