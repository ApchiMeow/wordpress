package poms;

import controls.WebButton;
import controls.WebTextBlock;
import core.AbstractPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPOM {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id ="wpcom-logo")
    public WebButton pageLogo;
}
