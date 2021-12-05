package yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MailPage {
    private WebDriver driver;
    @FindBy (xpath= "//a[@title=\"Написать (w, c)\"]")
    private WebElement buttonNewLetter;
    @FindBy (xpath= "//div[@class=\"composeYabbles\"]")
    private WebElement writeTo;
    @FindBy (xpath= "//div[@role=\"textbox\"]")
    private WebElement letterBody;
    @FindBy (xpath= "//input[@name=\"subject\"]")
    private WebElement subject;
    @FindBy (xpath= "//div[@class=\"ComposeDoneScreen-Title\"]")
    private WebElement letterSent;
    @FindBy (xpath= "//a[@data-count='{\"name\":\"user\"}']")
    private WebElement mailOwner;
    @FindBy (xpath = "//button[contains(@aria-disabled, \"false\")]")
    private WebElement buttonSend;
    @FindBy (xpath= "//span[@class=\"mail-NestedList-Item-Info-Link-Text\"]")
    private WebElement lettersCounter;


    public MailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int searchLettersWithSubject(String subject) {
        By elements = By.xpath("//span[@title=\"" + subject + "\"]");
        List<WebElement> searchThemeCounter = driver.findElements(elements);
        return searchThemeCounter.size();
    }

    public void fillWriteTo(String toWhom) {
        this.writeTo.sendKeys(toWhom);
    }

    public void fillLetterBody(String message) {
        this.letterBody.sendKeys(message);
    }

    public void fillSubject(String subject) {
        this.subject.sendKeys(subject);
    }

    public void clickButtonNewLetter() {
        this.buttonNewLetter.click();
    }

    public void clickButtonSend() {
        this.buttonSend.click();
    }

    public String getMailOwner() {
        return this.mailOwner.getText();
    }

    public Integer getCounter() {
        return Integer.parseInt(this.lettersCounter.getText());
    }

    public String done() {
        return this.letterSent.getText();
    }

    public void sendLetter(String letterBody, String subject, String toWhom) {
        WebDriverWait waitToMail = new WebDriverWait(driver, 10);
        waitToMail.until(ExpectedConditions.visibilityOf(mailOwner));
        clickButtonNewLetter();
        fillLetterBody(letterBody);
        fillSubject(subject);
        fillWriteTo(toWhom);
        clickButtonSend();
    }
}
