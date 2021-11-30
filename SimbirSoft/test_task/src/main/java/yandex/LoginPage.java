
package yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    public By loginField = By.xpath("//input[@id='passp-field-login']");
    public By passwordField = By.id("passp-field-passwd");
    public By buttonSignIn = By.id("passp:sign-in");
    public By header = By.xpath("//h1[@class=\"passp-title \"]");
    public By emptyLoginError = By.xpath("//div[@id=\"field:input-login:hint\"]");
    public By emptyPasswordError = By.xpath("//div[@id=\"field:input-passwd:hint\"]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillLogin(String login) {
        this.driver.findElement(this.loginField).sendKeys(new CharSequence[]{login});
    }

    public void fillPassword(String password) {
        this.driver.findElement(this.passwordField).sendKeys(new CharSequence[]{password});
    }

    public void clickSighIn() {
        this.driver.findElement(this.buttonSignIn).click();
    }

    public String getHeadingText() {
        return this.driver.findElement(this.header).getText();
    }

    public String getEmptyLoginError() {
        return this.driver.findElement(this.emptyLoginError).getText();
    }

    public String getEmptyPasswordError() {
        return this.driver.findElement(this.emptyPasswordError).getText();
    }

    public MailPage login(String login, String password) {
        this.fillLogin(login);
        this.clickSighIn();
        this.fillPassword(password);
        this.clickSighIn();
        return new MailPage(this.driver);
    }
}
