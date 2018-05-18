package poms;

import controls.WebButton;
import controls.WebTextBlock;
import controls.WebTypifiedElement;
import core.AbstractPOM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Pages extends AbstractPOM {

    WebDriver driver;
    private static final Logger log = LogManager.getLogger(WebTypifiedElement.class);
    public Pages(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"wpbody-content\"]/div[3]/h1")
    public WebTextBlock pageTitle;

    @FindBy(className = "page-title-action")
    public WebButton addNewPageLnk;

    public WebElement findPageTitle(String pageTitle){
        log.info("Check if " + pageTitle + " is in table");
        List<WebElement> pageTitles = driver.findElements(By.className("row-title"));
        if(pageTitles != null){
            log.info("Page " + pageTitle + " found");
            return pageTitles.stream().filter(r -> r.getText().equals(pageTitle)).findFirst().get();
        }
        log.info("Page " + pageTitle + " not found");
        return null;
    }
}
