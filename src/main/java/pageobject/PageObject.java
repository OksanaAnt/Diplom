package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import waiters.StandartWaiter;


public abstract class PageObject {

    protected Actions actions;
    //подлючаем драйвер, он будет общий для компонентов и страниц
    protected WebDriver driver;
    //инициализируем драйвер через конструктор и подключаем actions
    protected StandartWaiter standartWaiter;
    public PageObject(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        standartWaiter = new StandartWaiter(driver);

        PageFactory.initElements(driver, this);
    }
}
