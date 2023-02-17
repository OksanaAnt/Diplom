package components.popups;

import components.AbsBaseComponent;
import data.menu.HeaderMenuItemData;
import data.menu.ISubMenu;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Locale;

public class HeaderSubMenuPopup extends AbsBaseComponent implements components.popups.ISubMenuPopup {

    public HeaderSubMenuPopup(WebDriver driver) {
        super(driver);
    }
    // динамический локатор, т.к используется в нескольких классах, выносим в св-ва
    private String headerSubMenuPopupSelector = "[data-name='%s'].js-header3-popup";
    private String subMenuItemByNameLocator = "//div[@class='header3__nav-item-popup-content']//a[contains(@href,'/categories/%s')]";

    private String subMenuItemByNameEventsLocator = "//div[@class='header3__nav-item-popup-content']//a[contains(text(),'%s')]";


    @Override
    public void popupShouldNotBeVisible(HeaderMenuItemData headerMenuItemData) {
        String selector = String.format(headerSubMenuPopupSelector, headerMenuItemData.getName());
        Assertions.assertTrue(standartWaiter.waitForCondition(
                ExpectedConditions.attributeContains(driver.findElement(By.cssSelector(selector)),
                        "style", "none"))
        );
    }

    @Override
    public void popupShouldBeVisible(HeaderMenuItemData headerMenuItemData) {
        //true, потому что если будет фолс, кондишн будет ждать заложенный таймаут, тест будет медленнее
        String selector = String.format(headerSubMenuPopupSelector, headerMenuItemData.getName());
        Assertions.assertTrue(standartWaiter.waitForCondition(
                ExpectedConditions.not(
                        ExpectedConditions.attributeContains(driver.findElement(By.cssSelector(selector)),
                                "style", "none"))
        ));
    }

    public void clickSubMenuItemByName(ISubMenu subMenuItemData) {
        String locator = String.format(subMenuItemByNameLocator, subMenuItemData.getName().toLowerCase(Locale.ROOT));
        driver.findElement(By.xpath(locator)).click();
    }

    public void clickSubMenuItemByNameEvents(ISubMenu subMenuItemData) {
        String locator = String.format(subMenuItemByNameEventsLocator, subMenuItemData.getName());
        driver.findElement(By.xpath(locator)).click();
    }
}
