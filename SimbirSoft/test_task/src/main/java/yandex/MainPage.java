package yandex;

import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy (xpath ="//a[@data-statlog=\"notifications.mail.logout.enter\"]")
    WebElement enterButton;
    @FindBy (xpath ="//a[contains(@href, \"auth\")]")
    WebElement mailButton;

    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getUrl() {
        Objects.requireNonNull(this);
        return "https://mail.yandex.ru";
    }

    public LoginPage clickEnterButton() {
        enterButton.click();
        return new LoginPage(this.driver);
    }

    public LoginPage clickMailButton() {
        mailButton.click();
        return new LoginPage(this.driver);
    }
}