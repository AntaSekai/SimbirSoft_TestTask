import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import yandex.LoginPage;
import yandex.MailPage;
import yandex.MainPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MailPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    String hub, node;


    @Before
    public void setUp() throws MalformedURLException {
        hub="www.google.com";
        node="http://192.168.0.105:4444/wd/hub";
        System.setProperty("webdriver.gecko.driver",  "./src/main/resources/driver/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver();
        /*
       DesiredCapabilities caps = new DesiredCapabilities();
       caps.setBrowserName("firefox");
       caps.setPlatform(Platform.WIN10);


        driver = new RemoteWebDriver(new URL("http://localhost:4444/"), caps);
*/
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://yandex.ru");
    }


    @Test
    public void countLettersSentWithSubject() {
        User user = new User();
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.clickMailButton();

        MailPage mailPage = loginPage.login(user.getLogin(), user.getPassword());
        int counter = mailPage.searchElementsWithSubject("Simbirsoft Тестовое задание");

        mailPage.sendLetter("Количество сообщений с темой \"Simbirsoft Тестовое задание\" - " + counter, "\"Simbirsoft Тестовое задание.\"" + "<" + user.getSurname() + ">", user.getEmail());

        for (String currentWindow : driver.getWindowHandles())
            driver.switchTo().window(currentWindow);
        Assert.assertEquals("Письмо отправлено", mailPage.done());
    }

    @After
    public void close() {
        driver.quit();
    }
}
