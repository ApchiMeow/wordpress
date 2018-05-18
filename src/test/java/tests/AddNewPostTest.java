package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import core.BaseTest;
import core.WordPress;

@Test
public class AddNewPostTest extends BaseTest {
	
	public void test() throws InterruptedException {
		//System.setProperty("webdriver.gecko.driver", "src\\geckodriver.exe");
		WordPress wp = WordPress.init(driver);
		wp.loginPage.login(getLogin(),getPassword());
		wp.dashboardPage.pageTitle.equals("Dashboard");
		wp.leftMenu.postsLnk.click();
		wp.posts.pageTitle.checkIfDisplayed();
		wp.posts.addNewPostLnk.click();
		wp.addNewPost.pageTitle.checkIfDisplayed();
		String generatedTitle = RandomStringUtils.randomAlphabetic(10);
		wp.addNewPost.postTitleInput.sendKeys(generatedTitle);
		//не получается найти текстовое поле
        //wp.addNewPost.enterContent("Test content");
        wp.addNewPost.publishButton.click();
		wp.leftMenu.postsLnk.click();
		wp.posts.findPostTitle(generatedTitle);
		wp.dashboardPage.adminBar.click();
		wp.dashboardPage.signOut.click();
		wp.homePage.pageLogo.checkIfDisplayed();

//		Helpers.click(driver, lm.postsLnk, lm.addNewPostLnk);
//		
//		Thread.sleep(5000);
//		
//		AddNewPost anp = new AddNewPost(driver);
//		Assert.assertTrue(anp.pageNameLabel.isDisplayed(), "Page label is displayed for Add New post page");
//		check2StringIfEquals(anp.pageNameLabel, "Add a New Post");

	}
}