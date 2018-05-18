package DataProvider;

import controls.WebButton;
import controls.WebTextInput;
import core.AbstractPOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.Select;

public class DemoqaRegistration extends AbstractPOM {
    WebDriver driver;
    public DemoqaRegistration(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @FindBy(id = "name_3_firstname")
    public WebTextInput firstName;
    @FindBy(id = "name_3_lastname")
    public WebTextInput lastName;

    @FindBy(xpath = "//*[@id=\"pie_register\"]/li[2]/div/div/input[1]")
    public WebTextInput single;
    @FindBy(xpath = "//*[@id=\"pie_register\"]/li[2]/div/div/input[2]")
    public WebTextInput married;
    @FindBy(xpath = "//*[@id=\"pie_register\"]/li[2]/div/div/input[3]")
    public WebTextInput divorced;

    @FindBy(xpath = "//*[@id=\"pie_register\"]/li[3]/div/div[1]/input[1]")
    public WebButton dance;
    @FindBy(xpath = "//*[@id=\"pie_register\"]/li[3]/div/div[1]/input[2]")
    public WebButton readingg;
    @FindBy(xpath = "//*[@id=\"pie_register\"]/li[3]/div/div[1]/input[3]")
    public WebButton cricket;

    public void chooseCountry(String country){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        Select countries = new Select(driver.findElement(By.id("dropdown_7")));
        wait.until(ExpectedConditions.elementToBeClickable(countries));
        countries.selectByVisibleText(country);
    }

    public void chooseMonth(String month){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        Select months = new Select(driver.findElement(By.id("mm_date_8")));
        wait.until(ExpectedConditions.elementToBeClickable(months));
        months.selectByVisibleText(month);
    }

    public void chooseDay(String day){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        Select days = new Select(driver.findElement(By.id("dd_date_8")));
        wait.until(ExpectedConditions.elementToBeClickable(days));
        days.selectByVisibleText(day);
    }

    public void chooseYear(String year){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        Select years = new Select(driver.findElement(By.id("yy_date_8")));
        wait.until(ExpectedConditions.elementToBeClickable(years));
        years.selectByVisibleText(year);
    }

    @FindBy(id = "phone_9")
    public WebTextInput phone;

    @FindBy(id = "username")
    public WebTextInput username;

    @FindBy(id = "email_1")
    public WebTextInput email;

    @FindBy(id = "description")
    public WebTextInput description;

    @FindBy(id = "password_2")
    public WebTextInput password_2;

    @FindBy(id = "confirm_password_password_2")
    public WebTextInput confirm_password_password_2;

    @FindBy(xpath = "//*[@id=\"pie_register\"]/li[14]/div/input")
    public WebTextInput submitButton;

}
