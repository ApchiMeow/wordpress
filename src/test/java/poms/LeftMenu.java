package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import controls.WebLink;
import core.AbstractPOM;

public class LeftMenu extends AbstractPOM{
	
	public LeftMenu(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"menu-posts\"]/a/div[3]")
	public WebLink postsLnk;

	@FindBy(xpath = "//*[@id=\"menu-pages\"]/a/div[3]")
	public WebLink pagesLnk;
	
	@FindBy(xpath = "//div[@id='adminmenuwrap']/ul/li[a/div[text()='Posts']]/ul/li/a[contains(text(),'Add New')]")
	public WebLink addNewPostNotHoverLnk;
	
	@FindBy(xpath = "//*[@id=\"menu-users\"]/a/div[3]")
	public WebLink usersLnk;
	
//	@FindBy(xpath = "//div[@id='adminmenuwrap']/ul/li[./a/div[contains(text(),'Posts')]]/ul/li/a[text()='All Posts']")
//	public WebElement allPostsLnk;
//	
//	@FindBy(xpath = "//div[@id='adminmenuwrap']/ul/li[./a/div[contains(text(),'Posts')]]/ul/li/a[text()='Add New']")
//	public WebElement addNewLnk;
	

}
