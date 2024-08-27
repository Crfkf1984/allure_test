import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void beforeAll() {

        System.setProperty("webdriver.chrome.driver", "C:\\.cache\\selenium\\chromedriver\\win64\\126.0.6478.126\\chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com";
        Configuration.holdBrowserOpen = true;
    }
}
