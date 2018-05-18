package tests;

import org.testng.annotations.Test;

import core.BaseTest;
import poms.LoginPage;

@Test
public class WrongUserNameLoginTest extends BaseTest{
	
	public void test() {
		LoginPage lp = new LoginPage(driver);
		String username = "admin1";
		String password = "123456";
		lp.login(username, password);
		String errorLine = "ERROR: Invalid username. Lost your password?";
		lp.errorMsg.equals(errorLine);
	}
}
