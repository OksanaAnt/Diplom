package pages.categorycoursestesting;

import org.openqa.selenium.WebDriver;
import pages.AbsBasePage;

public abstract class AbsCoursesTestingListPage extends AbsBasePage {

    public AbsCoursesTestingListPage(WebDriver driver) {
        super(driver,"catalog/courses?categories=testing");
    }
}
