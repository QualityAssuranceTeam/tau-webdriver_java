package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {

    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr"; // ID String
    private By textArea = By.id("tinymce");
    private By decreaseIndentButton = By.cssSelector("#mceu_12 button");

    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clearTextArea() {
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea(); // exit the iframe - to avoid getting stuck there
    }

    public void setTextArea(String text) {
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    public String getTextFromEditor() {
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    public void decreaseIndention() {
        driver.findElement(decreaseIndentButton).click();
    }

    // temporary fix to avoid the WYSIWYG warning popup
    public void dismissWarning() {
        driver.findElement(By.id("mceu_34")).click(); // TODO: Remove when fixed
    }

    private void switchToEditArea() {
        driver.switchTo().frame(editorIframeId);
    }

    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }
}
