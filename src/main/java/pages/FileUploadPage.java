package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class FileUploadPage {

    private WebDriver driver;
    private By inputField = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickUploadButton() {
        driver.findElement(uploadButton).click();
    }

    /**
     * Provides path of the file to the form then clicks the Upload button.
     * @param path Absolute or Relative path to the file.
     */
    public void uploadFile(String path) {
        String absolutePath = new File(path).getAbsolutePath();

        driver.findElement(inputField).sendKeys(absolutePath);
        clickUploadButton();
    }

    public String getUploadedFiles() {
        return driver.findElement(uploadedFiles).getText();
    }
}
