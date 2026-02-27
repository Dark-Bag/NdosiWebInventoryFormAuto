package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoToInventoryPage {

    WebDriver driver;
    WebDriverWait wait;

    public GoToInventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickLearningDrop() {
        WebElement learnDrop = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/button"))
        );
        learnDrop.click();
    }

    public void selectLearningMaterial() {
        WebElement learningMaterialOpt = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]/span[2]"))
        );
        learningMaterialOpt.click();
    }

    public void selectWebAutoAdvance() {
        WebElement webAutoAdvance = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("tab-btn-web"))
        );
        webAutoAdvance.click();
    }

    public void verifyInventoryForm(String expectedMessage) {

        WebElement welcomeMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("inventory-title"))
        );
        String actualMessage = welcomeMessage.getText();
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected message: " + expectedMessage + ", but got: " + actualMessage);
        }
    }

}
