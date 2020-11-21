package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleWindowsPage {

    private WebDriver driver;
    private By clickHereLink = By.linkText("Click Here");

    public MultipleWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHere() {
        driver.findElement(clickHereLink).click();
    }

    // Ctrl + click on the link
    public MultipleWindowsPage controlClickHere() {
        Actions actions = new Actions(driver);

        actions.keyDown(Keys.CONTROL)
                .click(driver.findElement(clickHereLink))
                .keyUp(Keys.CONTROL)
                .perform();

        return new MultipleWindowsPage(driver);
    }
}
