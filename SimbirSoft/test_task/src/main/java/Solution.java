import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import yandex.LoginPage;
import yandex.MailPage;
import yandex.MainPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Solution {
    static WebDriver driver;

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.gecko.driver", "S:\\GIT_REP\\addons\\drivers\\firefox\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://passport.yandex.ru/auth?origin=home_desktop_ru&retpath=https%3A%2F%2Fmail.yandex.ru%2F&backpath=https%3A%2F%2Fyandex.ru");

        User user = new User();
        LoginPage loginPage = new LoginPage(driver);

        MailPage mailPage = loginPage.login(user.getLogin(), user.getPassword());

        List<WebElement> searchThemeCounter = driver.findElements(By.xpath("//span[@title=\"Simbirsoft Тестовое задание\"]"));

        mailPage.sendLetter("Количество сообщений с темой \"Simbirsoft Тестовое задание\" - " + searchThemeCounter.size(), "\"Simbirsoft Тестовое задание.\"" + "<" + user.getSurname() + ">", user.getEmail());
    }
}
