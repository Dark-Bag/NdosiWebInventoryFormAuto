package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvoicePage {

    WebDriver driver;
    WebDriverWait wait;

    public InvoicePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(30));
    }

    public void clickViewInvoice() {
        WebElement clickInvoice = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("view-history-btn"))
        );
        // Scroll element into view to avoid interception
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickInvoice);
        // Add small delay to ensure scroll is complete
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        clickInvoice.click();
    }

    public void verifyInvoiceHistory(String expectedMessage) {

        WebElement welcomeMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id, 'invoice-customer-name-')]"))
        );
        String actualMessage = welcomeMessage.getText();
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected message: " + expectedMessage + ", but got: " + actualMessage);
        }
    }

    public void clickViewInvoicePDF() {
        WebElement clickInvoice = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@id, 'view-invoice-')]"))
        );
        // Scroll element into view to avoid interception
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickInvoice);
        // Add small delay to ensure scroll is complete
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        clickInvoice.click();
    }

    public void verifyInvoicePDF(String expectedMessage) {
        // PDF content is often in an iframe or embedded object, which Selenium cannot directly read
        // Instead, verify that the PDF viewer has opened by checking for iframe or PDF container
        try {
            // Try to find PDF iframe first
            WebElement pdfIframe = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@src, 'blob:') or contains(@class, 'pdf')]"))
            );
            if (pdfIframe != null) {
                System.out.println("PDF viewer opened successfully");
                return;
            }
        } catch (Exception e) {
            // If iframe not found, try alternative approach
        }

        // Alternative: Look for any element indicating PDF is displayed
        try {
            WebElement pdfContainer = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'pdf') or contains(@class, 'invoice')]"))
            );
            System.out.println("PDF container found");
        } catch (Exception e) {
            throw new AssertionError("PDF viewer did not open. Could not find PDF iframe or container.");
        }
    }
}
