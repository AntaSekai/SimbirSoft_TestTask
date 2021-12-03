import org.junit.runner.JUnitCore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import yandex.LoginPage;
import yandex.MailPage;
import yandex.MainPage;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Solution {
    static WebDriver driver;

    public static void main(String[] args)  throws Exception{
       System.setProperty("webdriver.gecko.driver", "./src/main/resources/driver/geckodriver.exe");

        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        MainPage mainPage = new MainPage(driver);
        User user = new User();
        driver.get(mainPage.getUrl());

        LoginPage loginPage = mainPage.clickMailButton();

        MailPage mailPage = loginPage.login(user.getLogin(), user.getPassword());

        mailPage.searchElementsWithSubject("Simbirsoft Тестовое задание");
        System.out.println(mailPage.searchElementsWithSubject("Simbirsoft Тестовое задание"));

        mailPage.sendLetter("Количество сообщений с темой \"Simbirsoft Тестовое задание\" - " + mailPage.searchElementsWithSubject("Simbirsoft Тестовое задание"), "\"Simbirsoft Тестовое задание.\"" + "<" + user.getSurname() + ">", user.getEmail());


        //div[@class="ComposeDoneScreen-Wrapper"]
        //div[@class=class=\"ComposeDoneScreen-Title\""]
    }
}
