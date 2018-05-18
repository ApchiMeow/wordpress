package poms;

import controls.WebTextBlock;
import controls.WebTypifiedElement;
import core.AbstractPOM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MySite extends AbstractPOM {
    WebDriver driver;
    private static final Logger log = LogManager.getLogger(WebTypifiedElement.class);
    public MySite(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(className = "entry-title")
    public WebTextBlock myPageTitle;

    public boolean findPageContent(String content){
        log.info("Check if " + content + " is in table");
        List<WebElement> postTitles = driver.findElements(By.className("entry-title"));
        if(postTitles.stream().filter(r -> r.getText().equals(content)).findFirst() != null){
            log.info("Post " + content + " found");
            return true;
        }
        log.info("Post " + content + " not found");
        return false;
    }
}
