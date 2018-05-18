package poms;

import controls.WebButton;
import controls.WebTextBlock;
import controls.WebTextInput;
import controls.WebTypifiedElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import core.AbstractPOM;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.Select;

public class AddNewUser extends AbstractPOM {

	WebDriver driver;
	private static final Logger log = LogManager.getLogger(WebTypifiedElement.class);
	public AddNewUser(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//*[@id=\"primary\"]/main/div[2]/div/a")
	public WebButton inviteButton;

	@FindBy(xpath = "//*[@id=\"primary\"]/main/div[2]/div/form/div/div/div")
	public WebTextInput userNameInput;

	@FindBy(xpath = "//*[@id=\"primary\"]/main/div[2]/div/form/button")
	public WebButton sendInvitationButton;

	@FindBy(xpath = "//*[@id=\"notices\"]/div/span[2]/span")
	public WebButton notice;


	public void chooseRole(String role){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Select userRoles = new Select(driver.findElement(By.id("role")));
		wait.until(ExpectedConditions.elementToBeClickable(userRoles));
		userRoles.selectByVisibleText(role);
	}

	public void inviteButtonClick(){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(inviteButton));
		inviteButton.click();
	}
    public void enterEmail(String email){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(userNameInput));
		userNameInput.sendWithoutClear(email + Keys.ENTER);
    }
    public void sendInvitationButtonClick(){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(sendInvitationButton));
        sendInvitationButton.click();
    }

	public void checkNotice(){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(notice));
		String str = notice.getText();
		log.info(str);
	}
}
