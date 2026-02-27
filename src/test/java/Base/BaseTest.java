package Base;

import Pages.LoginPage;
import Pages.GoToInventoryPage;
import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public final String URL = "https://ndosisimplifiedautomation.vercel.app/";
    public final String BROWSER = "chrome";

    public WebDriver driver;
    public LoginPage loginPage;
    public GoToInventoryPage goToInventoryPage;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.startBrowser(BROWSER, URL);
        loginPage = new LoginPage(driver);
        goToInventoryPage = new GoToInventoryPage(driver);
    }

//    @AfterMethod
//    public void tearDown() {
//        BrowserFactory.closeBrowser();
//    }
}
