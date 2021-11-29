import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.mailYandex;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        mailYandex site = new mailYandex();
        User user = new User();
        System.setProperty("webdriver.gecko.driver", "S:\\GIT_REP\\addons\\drivers\\firefox\\geckodriver.exe");
        try {
            FirefoxDriver driver = new FirefoxDriver();
            driver.get(site.getUrl());
            //задержка
            WebDriverWait waitToMail = new WebDriverWait(driver,10);
            WebDriverWait waitToLogin = new WebDriverWait(driver,10);
            WebDriverWait waitToPassword = new WebDriverWait(driver,10);
            WebDriverWait waitToWrite = new WebDriverWait(driver,10);


         //   WebElement enterMail = driver.findElement(By.xpath("//a[@data-statlog=\"notifications.mail.logout.mail\"]"));
          //  enterMail.click();
            System.out.println("жду поле ввода");
            waitToLogin.until(ExpectedConditions.visibilityOfElementLocated(By.id("passp-field-login")));
//логин
            WebElement inputLogin = driver.findElement(By.id("passp-field-login"));
            inputLogin.sendKeys(user.getLogin());
            System.out.println("ввел логин");


            WebElement enter = driver.findElement(By.id("passp:sign-in"));

            enter.click();


            waitToPassword.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"passp-field-passwd\"]")));

            WebElement inputPassword = driver.findElement(By.id("passp-field-passwd"));
            inputPassword.sendKeys(user.getPassword());
            System.out.println("ввел пароль");
            enter = driver.findElement(By.id("passp:sign-in"));
            enter.click();

            waitToMail.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-key=\"view=footer\"]")));
//поиск
            List<WebElement> searchThemeCounter = driver.findElements(By.xpath("//span[@title=\"Simbirsoft Тестовое задание\"]"));
//написать
            WebElement writeNew = driver.findElement(By.xpath("//a[@title=\"Написать (w, c)\"]"));
            writeNew.click();
            //Thread.sleep(2000);
            waitToWrite.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role=\"textbox\"]")));

            WebElement writeMessageBody = driver.findElement(By.xpath("//div[@role=\"textbox\"]"));
            writeMessageBody.click();
            writeMessageBody.sendKeys("Количество сообщений с темой \"Simbirsoft Тестовое задание\" - "+searchThemeCounter.size());
            Thread.sleep(200);

            WebElement writeSubject = driver.findElement(By.xpath("//input[@name=\"subject\"]"));
            writeSubject.click();
            writeSubject.sendKeys("Simbirsoft Тестовое задание."+" "+"<"+user.getSurname()+">");
            Thread.sleep(200);

            WebElement writeTo = driver.findElement(By.xpath("//div[@class=\"composeYabbles\"]"));
            writeTo.click();
            writeTo.sendKeys(user.getAddress());
            Thread.sleep(200);


//отправить
            WebElement sendButton = driver.findElement(By.xpath("//button[@class=\"Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l\"]"));
            sendButton.click();
        } catch (Exception e) {
            System.out.println("err");
            e.printStackTrace();
        }

    }
}
