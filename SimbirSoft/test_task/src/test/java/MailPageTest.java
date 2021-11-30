import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import yandex.LoginPage;
import yandex.MailPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MailPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "S:\\GIT_REP\\addons\\drivers\\firefox\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://passport.yandex.ru/auth?origin=home_desktop_ru&retpath=https%3A%2F%2Fmail.yandex.ru%2F&backpath=https%3A%2F%2Fyandex.ru");
        //   LoginPage loginPage = new LoginPage(driver);
    }

    @Test
    public void enterMailSuccess() {
        User user = new User();
        LoginPage loginPage = new LoginPage(driver);
        WebDriverWait waitToLogin = new WebDriverWait(driver,10);
        MailPage mailPage = loginPage.login(user.getLogin(),user.getPassword());
        waitToLogin.until(ExpectedConditions.visibilityOfElementLocated(mailPage.mailOwner));
        Assert.assertEquals(user.getLogin(),mailPage.getMailOwner());
    }

    @Test
    public void letterSent() throws Exception{
        User user = new User();
        LoginPage loginPage = new LoginPage(driver);
        MailPage mailPage = loginPage.login(user.getLogin(), user.getPassword());
        List<WebElement> searchThemeCounter = driver.findElements(By.xpath("//span[@title=\"Simbirsoft Тестовое задание\"]"));
        Integer counterBefore = mailPage.getCounter();
        mailPage.sendLetter("Количество сообщений с темой \"Simbirsoft Тестовое задание\" - "+searchThemeCounter.size(),"\"Simbirsoft Тестовое задание.\""+"<"+user.getSurname()+">", user.getEmail());
        Thread.sleep(1000);
        mailPage.clickRefresh();
        Thread.sleep(1000);
        Integer counterAfter = mailPage.getCounter();
        Assert.assertEquals(1, counterAfter - counterBefore);
    }

    @After
    public void close(){
        driver.quit();
    }
}
