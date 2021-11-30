package yandex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    public  LoginPage(WebDriver driver){
        this.driver= driver;
    }

   public By loginField = By.xpath("//input[@id='passp-field-login']");
    public By passwordField=By.id("passp-field-passwd");
    public By buttonSignIn = By.id("passp:sign-in");
    public By header = By.xpath("//h1[@class=\"passp-title \"]");
    public By emptyLoginError = By.xpath("//div[@id=\"field:input-login:hint\"]");
    public By emptyPasswordError = By.xpath("//div[@id=\"field:input-passwd:hint\"]");

    public void fillLogin(String login){
        driver.findElement(loginField).sendKeys(login);
    }

    public void fillPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSighIn(){
        driver.findElement(buttonSignIn).click();
    }

    public String getHeadingText(){
        return driver.findElement(header).getText();
    }

    public String getEmptyLoginError(){
        return driver.findElement(emptyLoginError).getText();
    }

    public String getEmptyPasswordError(){
        return driver.findElement(emptyPasswordError).getText();
    }

    public MailPage login(String login, String password){
        fillLogin(login);
        clickSighIn();
        fillPassword(password);
        clickSighIn();
        return new MailPage(driver);
    }
}
