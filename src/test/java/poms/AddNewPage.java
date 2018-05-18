package poms;

import controls.WebButton;
import controls.WebTextBlock;
import controls.WebTextInput;
import core.AbstractPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewPage extends AbstractPOM {
    WebDriver driver;
    public AddNewPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(className = "wp-heading-inline")
    public WebTextBlock pageTitle;

    @FindBy(id = "title")
    public WebTextInput postTitleInput;

    @FindBy(xpath = "//*[@id=\"tinymce\"]/p")
    public WebTextInput contentInput;

    @FindBy(id = "publish")
    public WebButton publishButton;

    @FindBy(id = "post-preview")
    public WebButton previewButton;

    @FindBy(xpath = "//*[@id=\"delete-action\"]/a")
    public WebButton moveToTrash;

    public void enterContent(String content){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        contentInput.click();
        wait.until(ExpectedConditions.elementToBeClickable(contentInput));
        contentInput.sendKeys(content);
    }
}
