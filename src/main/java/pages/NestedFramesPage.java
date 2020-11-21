package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {

    private WebDriver driver;
    private String topFrame = "frame-top"; // name string
    private String leftFrame = "frame-left";
    private String middleFrame = "frame-middle";
    private String rightFrame = "frame-right";
    private String bottomFrame = "frame-bottom";

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLeftFrameText() {
        driver.switchTo().frame(topFrame).switchTo().frame(leftFrame);
        String text = getBodyText();
        switchToMainContent();
        return text;
    }

    public String getMiddleFrameText() {
        driver.switchTo().frame(topFrame).switchTo().frame(middleFrame);
        String text = getBodyText();
        switchToMainContent();
        return text;
    }

    public String getRightFrameText() {
        driver.switchTo().frame(topFrame).switchTo().frame(rightFrame);
        String text = getBodyText();
        switchToMainContent();
        return text;
    }

    public String getBottomFrameText() {
        driver.switchTo().frame(bottomFrame);
        String text = getBodyText();
        switchToMainContent();
        return text;
    }

    private void switchToMainContent() {
        driver.switchTo().defaultContent();
    }

    private String getBodyText() {
        return driver.findElement(By.tagName("body")).getText();
    }
}
