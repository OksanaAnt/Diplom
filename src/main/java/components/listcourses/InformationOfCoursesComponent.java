package components.listcourses;

import components.AbsBaseComponent;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InformationOfCoursesComponent extends AbsBaseComponent {

    public InformationOfCoursesComponent (WebDriver driver) {
        super(driver);
    }

    private String nameOfCoursesLocator = "//div[@id='__next']//section//h1[contains(text(),\"\")]";

    private String descriptionOfCoursesLocator = "//div[@id='__next']//section//h1[contains(text(),\"\")]/following-sibling::div[1]";

    private String durationOfCoursesLocator = "//div[@id='__next']//following::section[2]//p[contains(text(),\"месяц\")]";

    private String formatOfCoursesLocator = "//div[@id='__next']//following::section[2]//p[contains(text(),\"лайн\")]";

        public InformationOfCoursesComponent coursesNameShouldBeSameAs(String coursesName) {

            String locator = String.format(nameOfCoursesLocator, coursesName);
            Assertions.assertEquals(coursesName, driver.findElement(By.xpath(locator)).getText(),
                    String.format("Courses name should be %s", coursesName)
            );
            return this;
        }

        public InformationOfCoursesComponent coursesDescriptionShouldBeSameAs(String coursesDescription) {
            String locator = String.format(descriptionOfCoursesLocator, coursesDescription);
            Assertions.assertEquals(coursesDescription, driver.findElement(By.xpath(locator)).getText(),
                    String.format("Courses description should be %s", coursesDescription)
            );
            return this;
        }

        public InformationOfCoursesComponent coursesDurationShouldBeSameAs(String coursesDuration) {
            String locator = String.format(durationOfCoursesLocator, coursesDuration);
            Assertions.assertEquals(coursesDuration, driver.findElement(By.xpath(locator)).getText(),
                    String.format("Courses duration should be %s", coursesDuration)
            );
            return this;
        }

        public InformationOfCoursesComponent coursesFormatShouldBeSameAs(String coursesFormat) {
            String locator = String.format(formatOfCoursesLocator, coursesFormat);
            Assertions.assertEquals(coursesFormat, driver.findElement(By.xpath(locator)).getText(),
                    String.format("Courses format should be %s", coursesFormat)
            );
            return this;
        }

}