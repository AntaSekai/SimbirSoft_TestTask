import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import yandex.LoginPage;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "S:\\GIT_REP\\addons\\drivers\\firefox\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://passport.yandex.ru/auth?origin=home_desktop_ru&retpath=https%3A%2F%2Fmail.yandex.ru%2F&backpath=https%3A%2F%2Fyandex.ru");
        LoginPage loginPage = new LoginPage(driver);

    }

    @Test
    public void logIn(){
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals("Войдите с Яндекс ID",loginPage.getHeadingText());
    }

    @After
    public void close(){
        driver.quit();
    }
}
