package delete;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class LoginWordPressCom {
	
	public void test() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.get("https://apchimeow.wordpress.com/wp-admin/");
		
		WebElement login = driver.findElement(By.xpath("//input[@id='usernameOrEmail']"));
		//поле ввода логина не доступно сначала, поэтому жду пока оно станет доступно
		wait.until(ExpectedConditions.elementToBeClickable(login));
		login.sendKeys("angelbeats9632@gmail.com");
		
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		submit.click();
		
		WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(pass));
		pass.sendKeys("C!FcWWG@XegsF2Z");

		submit.click();

		WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-my-account\"]/a/img"));
		wait.until(ExpectedConditions.visibilityOfAllElements(myAccount));
		myAccount.click();
		WebElement signOut = driver.findElement(By.xpath("//*[@class='ab-sign-out']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(signOut));
		signOut.click();
		
	}
}