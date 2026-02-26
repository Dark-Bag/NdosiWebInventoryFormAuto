package Base;

import Pages.LoginPage;
import Utils.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    BrowserFactory browserFactory = new BrowserFactory();

    public final String URL = "https://ndosisimplifiedautomation.vercel.app/";
    public final String BROWSER = "chrome";

    public WebDriver driver;
    public LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = browserFactory.startBrowser(BROWSER, URL);
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        browserFactory.closeBrowser();
    }
}
