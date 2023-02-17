package waiters;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StandartWaiter {

    private WebDriver driver;

    public  StandartWaiter(WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForCondition(ExpectedCondition condition) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try{
            webDriverWait.until(condition);
            return true;
        } catch (Exception ignored){
            return false;
        }
    }

    public  void  waitForVisible(By locator) {
        Assertions.assertTrue(waitForCondition(ExpectedConditions.visibilityOf(driver.findElement(locator))));
    }
}
