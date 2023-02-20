package pages.events;

import data.DateData;
import data.events.EventTypeTextData;
import data.events.EventsNewOrOldData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbsBasePage;
import waiters.StandartWaiter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


public class EventsPage extends AbsBasePage {
    public EventsPage(WebDriver driver) {
        super(driver, "events/near/");
    }

    protected StandartWaiter standartWaiter;

    String lastEventsLocator = "//div[@class='dod_new-event__type']/ancestor::div[contains(@class,'list')]/a[last()]";

    String displayEventsLocator = "//div[@class='dod_new-type']//div[contains(text(),'%s')]";

    String eventsNewOrOldSelector = "a[href*='events/%s']>span";

    String dateSelector = ".dod_new-event__time";


    private List<WebElement> displayEvents = new ArrayList<>();

    public void clickEventNewOrOld(EventsNewOrOldData eventsNewOrOldData) {
        String selector = String.format(eventsNewOrOldSelector, eventsNewOrOldData.getName());
        driver.findElement(By.cssSelector(selector)).click();
    }


    public void scrollLastElements() {
        for (int i = 0; i <= 100; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement element = driver.findElement(By.xpath(lastEventsLocator));
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        }
    }

    public EventsPage countEvents(EventTypeTextData eventTypeTextData) {
        String locator = String.format(displayEventsLocator, eventTypeTextData.getName());
        displayEvents = driver.findElements(By.xpath(locator));
        int numberCourses = displayEvents.size();
        Assertions.assertNotNull(numberCourses);
        System.out.println("Количество событий: " + numberCourses);
        return this;
    }

    public void checkEventDate() {
        List<WebElement> dateElements = driver.findElements(By.cssSelector(dateSelector));
        //      LocalDateTime now = LocalDateTime.now();

        Assertions.assertTrue(dateElements.stream()
                .map(WebElement::getText)
                .map((String dateStr) -> {
                    String monthStr = dateStr.split("\\s+")[1];

                    dateStr = dateStr.replaceAll("[а-я]+", String.format("%d", DateData.getDateData(monthStr).getNumber()));
                    dateStr += " " + LocalDate.now().getYear();

                    if (dateStr.equals("Сейчас в эфире")) {
                        return LocalDateTime.now();
                    }

                    return LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern("d M HH:mm yyyy", Locale.ROOT));
                })
                .allMatch((LocalDateTime localDateTime) -> localDateTime.isAfter(localDateTime.now()) || localDateTime.isEqual(localDateTime.now())));
    }
}
