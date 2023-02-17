package pages.events;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbsBasePage;
import waiters.StandartWaiter;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


public class EventsPage extends AbsBasePage {
    public EventsPage(WebDriver driver) {
        super(driver,"events/near/");
    }
    protected StandartWaiter standartWaiter;

   String lastEventsLocator = "//div[@class='dod_new-event__type']/ancestor::div[contains(@class,'list')]/a[last()]";

   String displayEventsLocator = "//div[@class='dod_new-type']//div[contains(text(),'Открытый вебинар')]";

 //  String lastEventsLocator = "//div[@class='footer2__info']";

    private List<WebElement> displayEvents = new ArrayList<>();


     public void scrollLastElements() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(lastEventsLocator));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

        public EventsPage countEvents() {
            displayEvents = driver.findElements(By.xpath(displayEventsLocator));
            int numberCourses = displayEvents.size();
            Assertions.assertNotNull(numberCourses);
            System.out.println("Количество событий: " + numberCourses);
            return this;
        }
    }
