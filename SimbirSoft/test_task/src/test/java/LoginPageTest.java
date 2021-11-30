import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import yandex.LoginPage;
import yandex.MailPage;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "S:\\GIT_REP\\addons\\drivers\\firefox\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://passport.yandex.ru/auth?origin=home_desktop_ru&retpath=https%3A%2F%2Fmail.yandex.ru%2F&backpath=https%3A%2F%2Fyandex.ru");
        //   LoginPage loginPage = new LoginPage(driver);

    }

    @Test
    public void logIn(){
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals("Войдите с Яндекс ID",loginPage.getHeadingText());
    }
    @Test
    public void emptyLogIn(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLogin("");
        loginPage.clickSighIn();
        Assert.assertEquals("Логин не указан",loginPage.getEmptyLoginError());
    }

    @Test
    public void emptyPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test","");
        Assert.assertEquals("Пароль не указан",loginPage.getEmptyPasswordError());
    }

    @After
    public void close(){
        driver.quit();
    }
}
