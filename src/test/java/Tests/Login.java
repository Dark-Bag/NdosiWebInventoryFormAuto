package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class Login extends BaseTest {

    @Test
    public void loginWithValidCredentials() throws InterruptedException{

        loginPage.clickLoginButton();
        loginPage.enterUsername("WaitUntilSam@fullytest.com");
        loginPage.enterPassword("Samkelo#7");
        loginPage.clickSubmitButton();
        loginPage.verifyLoginSuccess("Here's who's working today");
    }
}
