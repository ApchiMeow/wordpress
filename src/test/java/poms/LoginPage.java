package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import controls.WebButton;
import controls.WebTextBlock;
import controls.WebTextInput;
import core.AbstractPOM;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPOM{
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@id='usernameOrEmail']")
	public WebTextInput userNameInput;
	
	@FindBy(xpath = "//input[@id='password']")
	public WebTextInput userPassInput;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebButton submitBtn;
	
	@FindBy(xpath = "//div[@id='login_error']")
	public WebTextBlock errorMsg;
	
	public void login(String strUserName, String strPasword) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		//поле ввода логина не доступно сначала, поэтому жду пока оно станет доступно
		wait.until(ExpectedConditions.elementToBeClickable(userNameInput));
		userNameInput.sendKeys(strUserName);
		submitBtn.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(userPassInput));
		userPassInput.sendKeys(strPasword);
		submitBtn.click();
	}
}