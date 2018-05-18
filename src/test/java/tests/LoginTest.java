package tests;

import core.BaseTest;
import core.WordPress;
import org.testng.annotations.Test;

@Test
public class LoginTest extends BaseTest {

	public void test(){
		WordPress wp = WordPress.init(driver);
		wp.loginPage.login(getLogin(),getPassword());
		wp.dashboardPage.pageTitle.equals("Dashboard");
		wp.dashboardPage.adminBar.click();
		wp.dashboardPage.signOut.click();
		wp.homePage.pageLogo.checkIfDisplayed();
	}
}
