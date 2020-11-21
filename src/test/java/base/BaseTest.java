package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.CookieManager;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage; // so that the subclasses can access the homepage

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver =  new ChromeDriver();

        //driver =  new ChromeDriver(getChromeOptions()); // set some browser options
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File(
                        "resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    // Provide a handle to the WindowManager utility by passing a driver to it
    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    // Provide a handle to the CookieManager utility by passing a driver to it
    public CookieManager getCookieManager() {
        return new CookieManager(driver);
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito"); // start private browser session
        //options.setHeadless(true); // headless browser
        return options;
    }
}
