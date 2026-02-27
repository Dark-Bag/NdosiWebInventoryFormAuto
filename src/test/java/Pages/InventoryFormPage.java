package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class InventoryFormPage {

    WebDriver driver;
    WebDriverWait wait;

    public InventoryFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }



    public void clickDeviceTypeDrop() {
        WebElement deviceTypeDrop = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("deviceType"))
        );
        deviceTypeDrop.click();
    }

    public void selectIphone() {
        WebElement pickIphone = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"deviceType\"]/option[2]"))
        );
        pickIphone.click();
    }

    public void brandDropClickable() {
        WebElement brandDropClickable = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("brand"))
        );
        Assert.assertTrue(brandDropClickable.isEnabled());    }

    public void clickBrandDrop() {
        WebElement brandDrop = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("brand"))
        );
        brandDrop.click();   }

    public void selectBrand() {
        WebElement pickBrand = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"brand\"]/option[2]"))
        );
        pickBrand.click();
    }

    public void verifySelectedDevice(String expectedMessage) {

        WebElement welcomeMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"device-preview\"]/div/div/div[2]"))
        );
        String actualMessage = welcomeMessage.getText();
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected message: " + expectedMessage + ", but got: " + actualMessage);
        }
    }

    public void selectStorage() {
        WebElement pickStorage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"inventory-form-grid\"]/div[4]/div/label[2]"))
        );
        pickStorage.click();
    }

    public void verifyUnitPriceAfterSelectingStorage(String expectedMessage) {

        WebElement welcomeMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("unit-price-value"))
        );
        String actualMessage = welcomeMessage.getText();
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected message: " + expectedMessage + ", but got: " + actualMessage);
        }
    }

    public void clickColorDrop() {
        WebElement colorDrop = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("color"))
        );
        colorDrop.click();   }

    public void selectColor() {
        WebElement pickColor = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"color\"]/option[4]"))
        );
        pickColor.click();
    }

    public void verifySelectedColor(String expectedMessage) {

        WebElement welcomeMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"device-preview\"]/div/div/div[3]/strong[1]"))
        );
        String actualMessage = welcomeMessage.getText();
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected message: " + expectedMessage + ", but got: " + actualMessage);
        }
    }

    public void enterQuantity(Integer quantity) {
        WebElement quant = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("quantity"))
        );
        quant.sendKeys(String.valueOf(quantity));
    }

    public void verifySubTotalAfterEnteringQuantity(String expectedMessage) {

        WebElement welcomeMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("subtotal-value"))
        );
        String actualMessage = welcomeMessage.getText();
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected message: " + expectedMessage + ", but got: " + actualMessage);
        }
    }

    public void enterAddress(String address) {
        WebElement addr = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("address"))
        );
        addr.sendKeys(address);
    }

    public void verifyAddressFieldFilled() {
        WebElement filledField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("address"))
        );
        String fieldValue = filledField.getAttribute("value");
        Assert.assertFalse(fieldValue == null || fieldValue.isEmpty(), "Address field should not be empty");
    }

    public void clickNextButton() {
        WebElement butt = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("inventory-next-btn"))
        );
        butt.click();
    }

    public void verifyReviewPage(String expectedMessage) {

        WebElement welcomeMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("review-section-title"))
        );
        String actualMessage = welcomeMessage.getText();
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected message: " + expectedMessage + ", but got: " + actualMessage);
        }
    }

}
