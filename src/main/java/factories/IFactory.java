package factories;

import data.BrowserData;
import exceptions.BrowserNotSupportException;
import org.openqa.selenium.WebDriver;

public interface IFactory {
    WebDriver createDriver() throws BrowserNotSupportException;
}