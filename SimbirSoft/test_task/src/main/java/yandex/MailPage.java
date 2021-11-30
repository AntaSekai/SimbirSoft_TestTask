package yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MailPage {
    private WebDriver driver;

    public  MailPage(WebDriver driver){
        this.driver= driver;
    }
    public By buttonNewLetter = By.xpath("//a[@title=\"Написать (w, c)\"]");
    public By writeTo = By.xpath("//div[@class=\"composeYabbles\"]");
    public By letterBody = By.xpath("//div[@role=\"textbox\"]");
    public By subject=By.xpath("//input[@name=\"subject\"]");
    public By letterSent=By.xpath("//body[@class=\"ComposeDoneScreen-Title\"]");
    public By mailOwner=By.xpath("//a[@data-count='{\"name\":\"user\"}']");
    public By buttonSend = By.xpath("//button[@class=\"Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l\"]");
    public By elements = By.xpath("//span[@title=\"Simbirsoft Тестовое задание\"]");
    public By refresh = By.xpath("//span[@class=\"mail-ComposeButton-Refresh js-main-action-refresh ns-action\"]");
    public By lettersCounter = By.xpath("//span[@class=\"mail-NestedList-Item-Info-Link-Text\"]");

    public void searchElements(By xpath){
        List<WebElement> searchThemeCounter = driver.findElements(elements);
    }

    public void fillWriteTo(String toWhom){
        driver.findElement(writeTo).sendKeys(toWhom);
    }

    public void fillLetterBody(String message){
        driver.findElement(letterBody).sendKeys(message);
    }

    public void fillSubject(String subject){
        driver.findElement(this.subject).sendKeys(subject);
    }

    public void clickButtonNewLetter(){
        driver.findElement(buttonNewLetter).click();
    }

    public void clickButtonSend(){
        driver.findElement(buttonSend).click();
    }

    public String getMailOwner(){
        return driver.findElement(mailOwner).getText();
    }

    public void clickRefresh(){
        driver.findElement(refresh).click();
    }

    public Integer getCounter(){
        return Integer.parseInt(driver.findElement(lettersCounter).getText());
    }


    public String done(){
        return driver.findElement(letterSent).getText();
    }

    public void sendLetter(String letterBody, String subject, String toWhom){
        clickButtonNewLetter();
        fillLetterBody(letterBody);
        fillSubject(subject);
        fillWriteTo(toWhom);
        clickButtonSend();
    }
}
