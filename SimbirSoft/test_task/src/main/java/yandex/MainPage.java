package yandex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final String url = "https://yandex.ru";

    private WebDriver driver;

    public  MainPage(WebDriver driver){
        this.driver= driver;
    }

    private By enterButton = By.xpath("//a[@data-statlog=\"notifications.mail.logout.enter\"]");
    private By mailButton = By.xpath("//a[@data-statlog=\"notifications.mail.logout.mail\"]");

    public String getUrl() {
        return this.url;
    }

    public LoginPage clickEnterButton(){
        driver.findElement(enterButton).click();
        return new LoginPage(driver);
    }

    public LoginPage clickMailButton(){
        driver.findElement(mailButton).click();
        return new LoginPage(driver);
    }

}
