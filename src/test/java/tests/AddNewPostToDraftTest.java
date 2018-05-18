package tests;

import core.BaseTest;
import core.WordPress;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

@Test
public class AddNewPostToDraftTest extends BaseTest {

    public void test() throws InterruptedException {
        WordPress wp = WordPress.init(driver);
        wp.loginPage.login(getLogin(), getPassword());
        wp.dashboardPage.pageTitle.equals("Dashboard");
        wp.leftMenu.postsLnk.click();
        wp.posts.pageTitle.checkIfDisplayed();
        wp.posts.addNewPostLnk.click();
        wp.addNewPost.pageTitle.checkIfDisplayed();
        String generatedTitle = RandomStringUtils.randomAlphabetic(10);
        wp.addNewPost.postTitleInput.sendKeys(generatedTitle);
        //не получается найти текстовое поле
        //wp.addNewPost.enterContent("Test content");
        wp.addNewPost.saveDraft.click();
        wp.addNewPost.postStatus.equals("Draft");
        wp.leftMenu.postsLnk.click();
        wp.posts.findPostTitle(generatedTitle);
        wp.dashboardPage.adminBar.click();
        wp.dashboardPage.signOut.click();
        wp.homePage.pageLogo.checkIfDisplayed();
    }
}
