package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class CommonBaseTest {
        public static final String PAGE_URL = "https://stellarburgers.nomoreparties.site";
        public WebDriver driver;
        @Before
        public void setUp() {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver\\chromedriver.exe");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                WebDriverManager.chromedriver().setup();
                driver.get(PAGE_URL);

//        WebDriverManager.edgedriver().setup();
//        EdgeOptions options = new EdgeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new EdgeDriver(options);
//        driver.get(PAGE_URL);
//       // HomePage objHomePage = new HomePage(driver);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

    @After
    public void tearDown() {
       driver.quit();
    }
}
