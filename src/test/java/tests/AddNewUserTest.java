package tests;

import core.BaseTest;
import core.WordPress;
import org.testng.annotations.Test;

@Test
public class AddNewUserTest extends BaseTest{
    public void test() throws InterruptedException {
        WordPress wp = WordPress.init(driver);
        wp.loginPage.login(getLogin(), getPassword());
        wp.dashboardPage.pageTitle.equals("Dashboard");
        wp.leftMenu.usersLnk.click();
        wp.users.pageTitle.checkIfDisplayed();
        wp.users.addNewLnk.click();
        wp.addNewUser.inviteButtonClick();
        wp.addNewUser.enterEmail("angel_beats96@mail.ru");
        wp.addNewUser.chooseRole("Follower");
        wp.addNewUser.sendInvitationButtonClick();
        wp.addNewUser.checkNotice();
    }
}
