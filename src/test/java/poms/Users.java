package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import controls.WebLink;
import controls.WebTextBlock;
import core.AbstractPOM;

public class Users extends AbstractPOM {

	public Users(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*[@id=\"wpbody-content\"]/div[3]/h1")
	public WebTextBlock pageTitle;
	
	@FindBy(className = "page-title-action")
	public WebLink addNewLnk;

}
