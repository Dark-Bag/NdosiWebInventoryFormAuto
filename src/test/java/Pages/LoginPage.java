package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickLoginButton() {
        WebElement loginButt = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/button/span[2]"))
        );
        loginButt.click();
    }

    public void enterUsername(String username) {

        WebElement user = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login-email"))
        );
        user.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement pass = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login-password"))
        );
        pass.sendKeys(password);
    }

    public void clickSubmitButton() {
        WebElement butt = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login-submit"))
        );
        butt.click();
    }


    public void verifyLoginSuccess(String expectedMessage) {

        WebElement welcomeMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app-main-content\"]/section/div[1]/p"))
        );
        String actualMessage = welcomeMessage.getText();
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected message: " + expectedMessage + ", but got: " + actualMessage);
        }
    }





}
