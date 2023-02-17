package pages;

import org.openqa.selenium.WebDriver;
import pageobject.PageObject;

public abstract class AbsBasePage  extends PageObject{
    // заводим пропертю для ввода url через консоль
    private String baseUrl = System.getProperty("base.url","https://otus.ru");
    private String path;

    //  инициализируем через конструктор
    public AbsBasePage(WebDriver driver, String path) {
        super(driver);
        this.path = path;
    }
    //  заводим общий метод open для всех страниц и передаем url через констуктор
    public void open(){
//  в if проверяем есть ли в конце ссылки / и если нет, ставим; replaceAll - удаляем в конце /
        if(!path.startsWith("/")){
            path +="/";
        }
        driver.get(baseUrl.replaceAll("\\/$","") + path);
    }
}
