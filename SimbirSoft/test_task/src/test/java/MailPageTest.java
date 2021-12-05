import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import yandex.LoginPage;
import yandex.MailPage;
import yandex.MainPage;
import java.util.concurrent.TimeUnit;

public class MailPageTest {
    private WebDriver driver;
    @Before
    public void setUp()  {

        System.setProperty("webdriver.gecko.driver",  "./src/main/resources/driver/geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mail.yandex.ru/");
    }

    @Test
    public void countLettersSentWithSubject() {
        User user = new User();
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.clickMailButton();

        MailPage mailPage = loginPage.login(user.getLogin(), user.getPassword());
        int counter = mailPage.searchLettersWithSubject("Simbirsoft Тестовое задание");

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
