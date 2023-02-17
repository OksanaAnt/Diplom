package factories;

import data.BrowserData;
import exceptions.BrowserNotSupportException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//реализация фабрики
public class WebDriverFactory implements IFactory{

    // определяем как передавать browserType
    private String browserName = System.getProperty("browser", "chrome");

    @Override
    public WebDriver createDriver() throws BrowserNotSupportException {
        switch (BrowserData.valueOf(browserName.toUpperCase())) {
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                return new ChromeDriver(options);
            default:
                throw new BrowserNotSupportException(browserName);
        }
    }

}
