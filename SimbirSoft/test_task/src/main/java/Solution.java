import org.junit.runner.JUnitCore;
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

    public static void main(String[] args)  throws Exception{
       System.setProperty("webdriver.gecko.driver", "S:\\GIT_REP\\addons\\drivers\\firefox\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //driver.get("https://passport.yandex.ru/auth?origin=home_desktop_ru&retpath=https%3A%2F%2Fmail.yandex.ru%2F&backpath=https%3A%2F%2Fyandex.ru");

        MainPage mainPage = new MainPage(driver);
        User user = new User();
        driver.get(mainPage.getUrl());

        LoginPage loginPage = mainPage.clickMailButton();

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }


        WebDriverWait waitToLogin = new WebDriverWait(driver,10);
        waitToLogin.until(ExpectedConditions.visibilityOfElementLocated(loginPage.header));

        MailPage mailPage = loginPage.login(user.getLogin(), user.getPassword());

        WebDriverWait waitToMail = new WebDriverWait(driver,10);
        waitToMail.until(ExpectedConditions.visibilityOfElementLocated(mailPage.mailOwner));


        mailPage.searchElementsWithSubject("Simbirsoft Тестовое задание");
        System.out.println(mailPage.searchElementsWithSubject("Simbirsoft Тестовое задание"));

        mailPage.sendLetter("Количество сообщений с темой \"Simbirsoft Тестовое задание\" - " + mailPage.searchElementsWithSubject("Simbirsoft Тестовое задание"), "\"Simbirsoft Тестовое задание.\"" + "<" + user.getSurname() + ">", user.getEmail());
    }
}
