
package yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    @FindBy (xpath = "//input[@id='passp-field-login']")
    private WebElement loginField;
    @FindBy (xpath = "//input[@id='passp-field-passwd']")
    private WebElement passwordField;
    @FindBy (id = "passp:sign-in")
    private WebElement buttonSignIn;
    @FindBy (xpath = "//h1[@class=\"passp-title \"]")
    private WebElement header;
    @FindBy (xpath = "//div[@id=\"field:input-login:hint\"]")
    private WebElement emptyLoginError;
    @FindBy (xpath = "//div[@id=\"field:input-passwd:hint\"]")
    private WebElement emptyPasswordError;

    private WebDriver driver;
/*
    public By loginField = By.xpath("//input[@id='passp-field-login']");
    public By passwordField = By.id("passp-field-passwd");
    public By buttonSignIn = By.id("passp:sign-in");
    public By header = By.xpath("//h1[@class=\"passp-title \"]");
    public By emptyLoginError = By.xpath("//div[@id=\"field:input-login:hint\"]");
    public By emptyPasswordError = By.xpath("//div[@id=\"field:input-passwd:hint\"]");
*/
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void fillLogin(String login) {
     //   driver.findElement(loginField).sendKeys(login);
       this.loginField.sendKeys(login);
    }

    public void fillPassword(String password) {
       // driver.findElement(passwordField).sendKeys(password);
        this.passwordField.sendKeys(password);
    }

    public void clickSighIn() {
      // driver.findElement(buttonSignIn).click();
         this.buttonSignIn.click();
    }

    public String getHeadingText() {
      //  return driver.findElement((header)).getText();
        return this.header.getText();
    }

    public String getEmptyLoginError() {
     //  return driver.findElement(emptyLoginError).getText();
        return this.emptyLoginError.getText();
    }

    public String getEmptyPasswordError() {
      //  return  driver.findElement(emptyPasswordError).getText();
        return this.emptyPasswordError.getText();
    }

    public MailPage login(String login, String password) {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        WebDriverWait waitToLogin = new WebDriverWait(driver,10);
        waitToLogin.until(ExpectedConditions.visibilityOf(this.header));
        this.fillLogin(login);
        this.clickSighIn();
        this.fillPassword(password);
        this.clickSighIn();
        return new MailPage(this.driver);
    }
}
