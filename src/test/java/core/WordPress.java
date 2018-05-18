package core;

import org.openqa.selenium.WebDriver;

import poms.*;

public class WordPress {
	private static WordPress wordPress;
	
	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	public LeftMenu leftMenu;
	public Posts posts;
	public AddNewPost addNewPost;
	public HomePage homePage;
	public Pages pages;
	public AddNewPage addNewPage;
	public MySite mySite;
	public AddNewUser addNewUser;
	public Users users;
	
	private WordPress(WebDriver driver) {
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		leftMenu = new LeftMenu(driver);
		posts = new Posts(driver);
		addNewPost = new AddNewPost(driver);
		homePage = new HomePage(driver);
		pages = new Pages(driver);
		addNewPage = new AddNewPage(driver);
		mySite = new MySite(driver);
		addNewUser = new AddNewUser(driver);
        users = new Users(driver);
	}
	
	public static WordPress init(WebDriver driver) {
		if(wordPress==null) {
			wordPress = new WordPress(driver);
		}
		return wordPress;
	}
}
