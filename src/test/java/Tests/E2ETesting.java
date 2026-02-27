package Tests;

import Base.BaseTest;
import org.testng.annotations.Test;

public class E2ETesting extends BaseTest {

    @Test
    public void loginWithValidCredentials() throws InterruptedException{

        loginPage.clickLoginButton();
        loginPage.enterUsername("WaitUntilSam@fullytest.com");
        loginPage.enterPassword("Samkelo#7");
        loginPage.clickSubmitButton();
        loginPage.verifyLoginSuccess("Here's who's working today");

        goToInventoryPage.clickLearningDrop();
        goToInventoryPage.selectLearningMaterial();
        goToInventoryPage.selectWebAutoAdvance();
        goToInventoryPage.verifyInventoryForm("Inventory Form");

    }
}
