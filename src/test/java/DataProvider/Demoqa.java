package DataProvider;

import core.WordPress;
import org.openqa.selenium.WebDriver;
import poms.*;

public class Demoqa {
    private static Demoqa demoqa;

    public DemoqaRegistration demoqaRegistration;

    private Demoqa(WebDriver driver) {
        demoqaRegistration = new DemoqaRegistration(driver);
    }

    public static Demoqa init(WebDriver driver) {
        if(demoqa==null) {
            demoqa = new Demoqa(driver);
        }
        return demoqa;
    }
}
