import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.mailYandex;

import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        mailYandex site = new mailYandex();
        User user = new User();
        System.setProperty("webdriver.gecko.driver", "S:\\GIT_REP\\addons\\drivers\\firefox\\geckodriver.exe");
        try {
            FirefoxDriver driver = new FirefoxDriver();
            driver.get(site.getUrl());
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"passp-auth-content\"]")));
//логин
            WebElement inputLogin = driver.findElement(By.id("passp-field-login"));
            WebElement enter = driver.findElement(By.id("passp:sign-in"));
     //       inputLogin.sendKeys(user.getLogin());

            enter.click();

            WebElement inputPassword = driver.findElement(By.id("passp-field-passwd"));
            inputPassword.sendKeys(user.getPassword());

            enter = driver.findElement(By.id("passp:sign-in"));

            enter.click();
//поиск

//написать

//отправить

        } catch (Exception e) {
            System.out.println("err");
            e.printStackTrace();
        }

    }
}
