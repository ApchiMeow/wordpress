package poms;

import controls.WebButton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import controls.WebTextBlock;
import core.AbstractPOM;

public class DashboardPage extends AbstractPOM{

	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="//*[@id=\"wpbody-content\"]/div[3]/h1")
	public WebTextBlock pageTitle;

	@FindBy(xpath ="//*[@id=\"wp-admin-bar-my-account\"]/a/img")
	public WebButton adminBar;

	@FindBy(xpath ="//*[@id=\"wp-admin-bar-user-info\"]/div/form/button")
	public WebButton signOut;
	
//	@FindBy(xpath ="//div[@class='welcome-panel-content']/h2")
//	public WebTextBlock welcomeMsg;
	
//	By homePageName = By.xpath("//div[@id='welcome-panel']/div/h2");
//	
//	@FindBy(xpath = "//a[not(contains(@class,'hide-if-customize')) and text()='Customise Your Site']")
//	public WebElement customizeBtn;
//	
//	@FindBy(xpath = "//div[@class='wrap']/h1")
//	public WebElement pageName;
//	
//	public DashboardPage(WebDriver driver){
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//	}
//	
//	//Get the Page name from Home Page
//	public String getHomePageDashboardName(){
//		 return	driver.findElement(homePageName).getText();
//	}
//	
//	public void clickCustomize(){
//		customizeBtn.click();
//	}

}
