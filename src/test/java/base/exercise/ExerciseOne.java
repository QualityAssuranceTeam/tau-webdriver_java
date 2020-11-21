package base.exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ExerciseOne {

    private WebDriver driver;

    // No test runner
    public static void main(String[] args) {
        ExerciseOne test = new ExerciseOne();
        test.setUp();

        test.exerciseTest();

        test.tearDown();
    }

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver =  new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        //driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(1024, 768));
    }

    public void tearDown() {
        driver.quit();
    }

    public void exerciseTest() {
        // Click on Shifting Content link
        WebElement shiftingContentLink = driver.findElement(By.linkText("Shifting Content"));
        shiftingContentLink.click();

        // Click on the first example
        WebElement firstExampleLink = driver.findElement(By.partialLinkText("Example 1"));
        firstExampleLink.click();

        // Print how many menu elements appear
        List<WebElement> menu = driver.findElements(By.cssSelector("ul > li"));
        System.out.println(menu.size());
    }
}
