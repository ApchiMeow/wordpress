package tests;

import core.BaseTest;



public class TestAutoQALogin extends BaseTest{

	
	
////	@Dropdown
//	public void testPostsPage() throws InterruptedException{
//		objLogin = new LoginPage(driver);
//		objLogin.login("admin", "admin_pass!");
//		objHomePage = new DashboardPage(driver);
//		LeftMenu lm = new LeftMenu(driver);
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		
//		Actions action = new Actions(driver);
////		action.pause(Duration.ofSeconds(2)).moveToElement(lm.postsLnk).pause(Duration.ofSeconds(2)).moveToElement(lm.allPostsLnk).pause(Duration.ofSeconds(1)).click().build().perform();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='adminmenuwrap']/ul/li/a[./div[contains(text(),'Posts')]]")));
//		action.moveToElement(lm.postsLnk).build().perform();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='adminmenuwrap']/ul/li[./a/div[contains(text(),'Posts')]]/ul/li/a[text()='All Posts']")));
//		action.moveToElement(lm.allPostsLnk).click().build().perform();
//		
//		PostsPage pp = new PostsPage(driver);
////		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wrap']/h1")));
//		
//		Assert.assertTrue(pp.pageName.getText().toLowerCase().contains("posts"), "Page name:'" + pp.pageName.getText() + "'");
//	}

}
