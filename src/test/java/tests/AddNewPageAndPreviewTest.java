package tests;

import core.BaseTest;
import core.WordPress;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

@Test
public class AddNewPageAndPreviewTest extends BaseTest {

    public void test() throws InterruptedException {
        WordPress wp = WordPress.init(driver);
        wp.loginPage.login(getLogin(), getPassword());
        wp.dashboardPage.pageTitle.equals("Dashboard");
        wp.leftMenu.pagesLnk.click();
        wp.pages.pageTitle.checkIfDisplayed();
        wp.pages.addNewPageLnk.click();
        wp.addNewPage.pageTitle.checkIfDisplayed();
        String generatedTitle = RandomStringUtils.randomAlphabetic(10);
        wp.addNewPage.postTitleInput.sendKeys(generatedTitle);
        //не получается найти текстовое поле
        //wp.addNewPost.enterContent("Test content");
        wp.addNewPage.previewButton.click();
        wp.mySite.findPageContent(generatedTitle);
        driver.switchTo();
        wp.addNewPage.publishButton.click();
        wp.leftMenu.pagesLnk.click();
        wp.pages.findPageTitle(generatedTitle);
        wp.dashboardPage.adminBar.click();
        wp.dashboardPage.signOut.click();
        wp.homePage.pageLogo.checkIfDisplayed();
    }
}