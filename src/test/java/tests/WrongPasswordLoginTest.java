package tests;

import org.testng.annotations.Test;

import core.BaseTest;
import poms.LoginPage;

@Test
public class WrongPasswordLoginTest extends BaseTest {
	
	public void test() {
		LoginPage lp = new LoginPage(driver);
		String username = "admin";
		String password = "admin_pass1";
		lp.login(username, password);
		String errorLine = "ERROR: The password you entered for the username " + username + " is incorrect. Lost your password?";
		lp.errorMsg.equals(errorLine);
	}
}
