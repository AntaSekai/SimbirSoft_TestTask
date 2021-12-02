package yandex;

import java.util.Objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final String url = "https://yandex.ru";
    private WebDriver driver;
    private By enterButton = By.xpath("//a[@data-statlog=\"notifications.mail.logout.enter\"]");
    private By mailButton = By.xpath("//a[@data-statlog=\"notifications.mail.logout.mail\"]");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        Objects.requireNonNull(this);
        return "https://yandex.ru";
    }

    public LoginPage clickEnterButton() {
        this.driver.findElement(this.enterButton).click();
        return new LoginPage(this.driver);
    }

    public LoginPage clickMailButton() {
        this.driver.findElement(this.mailButton).click();
        return new LoginPage(this.driver);
    }
}