package Tests;

import Base.BaseTest;
import org.testng.annotations.Test;

public class InventoryE2ETest extends BaseTest {

//    @Test
//    public void e2eTest() throws InterruptedException{
//        loginPage.clickLoginButton();
//        loginPage.enterUsername("WaitUntilSam@fullytest.com");
//        loginPage.enterPassword("Samkelo#7");
//        loginPage.clickSubmitButton();
//        loginPage.verifyLoginSuccess("Here's who's working today");
//
//        goToInventoryPage.clickLearningDrop();
//        goToInventoryPage.selectLearningMaterial();
//        goToInventoryPage.selectWebAutoAdvance();
//        goToInventoryPage.verifyInventoryForm("Inventory Form");
//
//        inventoryForm.clickDeviceTypeDrop();
//        inventoryForm.selectIphone();
//        inventoryForm.brandDropClickable();
//        inventoryForm.clickBrandDrop();
//        inventoryForm.selectBrand();
//        inventoryForm.verifySelectedDevice("Apple");
//        inventoryForm.selectStorage();
//        inventoryForm.verifyUnitPriceAfterSelectingStorage("R480.00");
//        inventoryForm.clickColorDrop();
//        inventoryForm.selectColor();
//        inventoryForm.verifySelectedColor("blue");
//        inventoryForm.enterQuantity(2);
//        inventoryForm.verifySubTotalAfterEnteringQuantity("R960.00");
//        inventoryForm.enterAddress("123 Test Street");
//        inventoryForm.verifyAddressFieldFilled();
//        inventoryForm.clickNextButton();
//        inventoryForm.verifyReviewPage("REVIEW");
//
//        reviewPage.selectShipping();
//        reviewPage.verifyShippingPrice("R25.00");
//        reviewPage.selectWarranty();
//        reviewPage.verifyWarrantyPrice("R49.00");
//        reviewPage.enterDiscount("SAVE10");
//        reviewPage.clickApplyButton();
//        reviewPage.verifyAppliedDiscount("- R103.40");
//        reviewPage.clickConfirmPurchaseButton();
//        reviewPage.verifyPurchaseConfirmation("Shaun, your order was purchased successfully!");
//
//        invoicePage.clickViewInvoice();
//        invoicePage.verifyInvoiceHistory("Customer: Shaun Mkwenkwe");
//        invoicePage.clickViewInvoicePDF();
//        //invoicePage.verifyInvoicePDF("Bill To:");
//
//        }
    @Test()
    public void login() {
        loginPage.clickLoginButton();
        loginPage.enterUsername("WaitUntilSam@fullytest.com");
        loginPage.enterPassword("Samkelo#7");
        loginPage.clickSubmitButton();
        loginPage.verifyLoginSuccess("Here's who's working today");
    }

    @Test(priority = 1)
     public void navigateToInventoryForm() {
         goToInventoryPage.clickLearningDrop();
         goToInventoryPage.selectLearningMaterial();
         goToInventoryPage.selectWebAutoAdvance();
         goToInventoryPage.verifyInventoryForm("Inventory Form");
     }
    @Test(priority = 2)
     public void fillInventoryForm() {
         inventoryForm.clickDeviceTypeDrop();
         inventoryForm.selectIphone();
         inventoryForm.brandDropClickable();
         inventoryForm.clickBrandDrop();
         inventoryForm.selectBrand();
         inventoryForm.verifySelectedDevice("Apple");
         inventoryForm.selectStorage();
         inventoryForm.verifyUnitPriceAfterSelectingStorage("R480.00");
         inventoryForm.clickColorDrop();
         inventoryForm.selectColor();
         inventoryForm.verifySelectedColor("blue");
         inventoryForm.enterQuantity(2);
         inventoryForm.verifySubTotalAfterEnteringQuantity("R960.00");
         inventoryForm.enterAddress("123 Test Street");
         inventoryForm.verifyAddressFieldFilled();
         inventoryForm.clickNextButton();
     }
    @Test(priority = 3)
     public void reviewAndPurchase() {
         reviewPage.selectShipping();
         reviewPage.verifyShippingPrice("R25.00");
         reviewPage.selectWarranty();
         reviewPage.verifyWarrantyPrice("R49.00");
         reviewPage.enterDiscount("SAVE10");
         reviewPage.clickApplyButton();
         reviewPage.verifyAppliedDiscount("- R103.40");
         reviewPage.clickConfirmPurchaseButton();
         reviewPage.verifyPurchaseConfirmation("Shaun, your order was purchased successfully!");
     }
    @Test(priority = 4)
     public void viewInvoice() {
         invoicePage.clickViewInvoice();
         invoicePage.verifyInvoiceHistory("Customer: Shaun Mkwenkwe");
         invoicePage.clickViewInvoicePDF();
         //invoicePage.verifyInvoicePDF("Bill To:");
     }
}
