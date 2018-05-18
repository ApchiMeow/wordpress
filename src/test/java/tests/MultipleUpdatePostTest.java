package tests;

import controls.WebTextBlock;
import core.BaseTest;
import core.WordPress;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class MultipleUpdatePostTest extends BaseTest {

    public void test() throws InterruptedException {
        WordPress wp = WordPress.init(driver);
        wp.loginPage.login(getLogin(),getPassword());
        wp.dashboardPage.pageTitle.equals("Dashboard");
        wp.leftMenu.postsLnk.click();
        wp.posts.pageTitle.checkIfDisplayed();
        wp.posts.findPostTitle().click();

        for(int i = 1; i < 5; i++) {
            wp.addNewPost.pageTitle.checkIfDisplayed();
            String generatedTitle = RandomStringUtils.randomAlphabetic(10);
            wp.addNewPost.postTitleInput.sendKeys(generatedTitle);
            //не получается найти текстовое поле
            //wp.addNewPost.enterContent("Test content");
            wp.addNewPost.publishButton.click();
            wp.leftMenu.postsLnk.click();
            wp.posts.findPostTitle(generatedTitle).click();
        }
        wp.dashboardPage.adminBar.click();
        wp.dashboardPage.signOut.click();
        wp.homePage.pageLogo.checkIfDisplayed();


    }
}
