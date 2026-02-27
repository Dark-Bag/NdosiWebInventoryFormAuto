package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewPage {
    WebDriver driver;
    WebDriverWait wait;

    public ReviewPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    public void selectShipping() {
        WebElement pickShipping = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("shipping-option-express"))
        );
        pickShipping.click();
    }

    public void verifyShippingPrice(String expectedMessage) {

        WebElement welcomeMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("breakdown-shipping-value"))
        );
        String actualMessage = welcomeMessage.getText();
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected message: " + expectedMessage + ", but got: " + actualMessage);
        }
    }

    public void selectWarranty() {
        WebElement pickWarranty = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("warranty-option-1yr"))
        );
        pickWarranty.click();
    }


    public void verifyWarrantyPrice(String expectedMessage) {

        WebElement welcomeMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("breakdown-warranty-value"))
        );
        String actualMessage = welcomeMessage.getText();
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected message: " + expectedMessage + ", but got: " + actualMessage);
        }
    }

    public void enterDiscount(String discountCode) {
        WebElement discount = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("discount-code"))
        );
        discount.sendKeys(discountCode);
    }

    public void clickApplyButton() {
        WebElement butt = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("apply-discount-btn"))
        );
        butt.click();
    }
    public void verifyAppliedDiscount(String expectedMessage) {

        WebElement welcomeMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("breakdown-discount-value"))
        );
        String actualMessage = welcomeMessage.getText();
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected message: " + expectedMessage + ", but got: " + actualMessage);
        }
    }

    public void clickConfirmPurchaseButton() {
        WebElement butt = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("purchase-device-btn"))
        );
        butt.click();
    }


    public void verifyPurchaseConfirmation(String expectedMessage) {

        WebElement welcomeMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"purchase-success-toast\"]/p[1]"))
        );
        String actualMessage = welcomeMessage.getText();
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected message: " + expectedMessage + ", but got: " + actualMessage);
        }
    }


}
