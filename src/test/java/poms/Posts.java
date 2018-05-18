package poms;

import controls.WebButton;
import controls.WebTypifiedElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import controls.WebTextBlock;
import core.AbstractPOM;
import java.util.List;

public class Posts extends AbstractPOM{

	WebDriver driver;
	private static final Logger log = LogManager.getLogger(WebTypifiedElement.class);
	public Posts(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//*[@id=\"wpbody-content\"]/div[3]/h1")
	public WebTextBlock pageTitle;

	@FindBy(className = "page-title-action")
	public WebButton addNewPostLnk;

	public WebElement findPostTitle(String postTitle){
		log.info("Check if " + postTitle + " is in table");
		List<WebElement> postTitles = driver.findElements(By.className("row-title"));
		if(postTitles.stream().filter(r -> r.getText().equals(postTitle)).findFirst() != null){
			log.info("Post " + postTitle + " found");
			return postTitles.stream().filter(r -> r.getText().equals(postTitle)).findFirst().get();
		}
		log.info("Post " + postTitle + " not found");
		return null;
	}

	public WebElement findPostTitle(){
		log.info("Get first post in table");
		List<WebElement> postTitles = driver.findElements(By.className("row-title"));
		if(postTitles != null){
			log.info("Post found");
			return postTitles.stream().findFirst().get();
		}
		log.info("Posts not found");
		return null;
	}
	
}
