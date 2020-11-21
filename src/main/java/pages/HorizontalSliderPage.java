package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {

    private WebDriver driver;
    private By slider = By.cssSelector("input[type='range']");
    private By rangeIndicator = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver =driver;
    }

    // by Me
    public void moveSliderRight(int positions) {
        for (int i = 0; i < positions; i++) {
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    // by Angie
    public void setSliderValue(String value) {
        while (!getRangeValue().equals(value)) {
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getRangeValue() {
        return driver.findElement(rangeIndicator).getText();
    }
}
