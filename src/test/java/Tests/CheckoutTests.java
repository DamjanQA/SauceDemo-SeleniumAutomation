package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @BeforeMethod
    public void pageSetup() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        loginMethod();
        mainPage.clickOnEmptyCartIcon();
        cartPage.clickOnCheckoutButton();
        // ^so we don't repeat too many lines of code
    }

    @Test (priority = 10)
    public void userCannotSubmitFormWithoutFillingMandatoryFields() {
        // first we make sure we're actually on the correct page before testing
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage.getFirstExpectedURL());
        Assert.assertEquals(checkoutPage.getCheckoutHeader().getText(), checkoutPage.getFirstCheckoutHeaderText());
        Assert.assertTrue(checkoutPage.getContinueButton().isDisplayed());
        // then we make sure that all the mandatory fields are actually empty
        Assert.assertTrue(checkoutPage.getFirstNameField().getText().isEmpty());
        Assert.assertTrue(checkoutPage.getLastNameField().getText().isEmpty());
        Assert.assertTrue(checkoutPage.getPostalCodeField().getText().isEmpty());
        checkoutPage.clickOnContinueButton();
        // we should get the proper error message
        Assert.assertTrue(checkoutPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), checkoutPage.getErrorMessageFirstName());
        // now we assert that we're still on the same page
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage.getFirstExpectedURL());
        Assert.assertEquals(checkoutPage.getCheckoutHeader().getText(), checkoutPage.getFirstCheckoutHeaderText());
        Assert.assertTrue(checkoutPage.getContinueButton().isDisplayed());
    }

    @Test (priority = 20)
    public void userCanSubmitFormWithFilledMandatoryFields() {
        // first we make sure we're actually on the correct page before testing
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage.getFirstExpectedURL());
        Assert.assertEquals(checkoutPage.getCheckoutHeader().getText(), checkoutPage.getFirstCheckoutHeaderText());
        Assert.assertTrue(checkoutPage.getContinueButton().isDisplayed());
        checkoutPage.firstNameFieldInput("Test");
        checkoutPage.lastNameFieldInput("Testing");
        checkoutPage.postalCodeFieldInput("20000");
        checkoutPage.clickOnContinueButton();
        // we should get redirected to the second checkout page
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage.getSecondExpectedURL());
        Assert.assertEquals(checkoutPage.getCheckoutHeader().getText(), checkoutPage.getSecondCheckoutHeaderText());
        Assert.assertTrue(checkoutPage.getFinishButton().isDisplayed());
    }

    @Test (priority = 30)
    public void cancelButtonWorks() {
        // first we make sure we're actually on the correct page before testing
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage.getFirstExpectedURL());
        Assert.assertEquals(checkoutPage.getCheckoutHeader().getText(), checkoutPage.getFirstCheckoutHeaderText());
        Assert.assertTrue(checkoutPage.getCancelButton().isDisplayed());
        checkoutPage.clickOnCancelButton();
        // we should get redirected back to the cart page
        Assert.assertEquals(driver.getCurrentUrl(), cartPage.getExpectedURL());
        Assert.assertEquals(checkoutPage.getCheckoutHeader().getText(), cartPage.getCartHeader());
        Assert.assertTrue(cartPage.getContinueShoppingButton().isDisplayed());
        Assert.assertTrue(cartPage.getCheckoutButton().isDisplayed());
    }

    @Test(priority = 40)
    public void userCannotSubmitFormWithoutFillingFirstNameField() {
        // first we make sure we're actually on the correct page before testing
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage.getFirstExpectedURL());
        Assert.assertEquals(checkoutPage.getCheckoutHeader().getText(), checkoutPage.getFirstCheckoutHeaderText());
        // we leave the first name field empty and input the rest
        Assert.assertTrue(checkoutPage.getFirstNameField().getText().isEmpty());
        checkoutPage.lastNameFieldInput("Testing");
        checkoutPage.postalCodeFieldInput("20000");
        checkoutPage.clickOnContinueButton();
        // we should get the appropriate error message
        Assert.assertTrue(checkoutPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), checkoutPage.getErrorMessageFirstName());
        // now we assert that we're still on the same page
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage.getFirstExpectedURL());
        Assert.assertEquals(checkoutPage.getCheckoutHeader().getText(), checkoutPage.getFirstCheckoutHeaderText());
        Assert.assertTrue(checkoutPage.getContinueButton().isDisplayed());
    }

    @Test(priority = 50)
    public void userCannotSubmitFormWithoutFillingLastNameField() {
        // first we make sure we're actually on the correct page before testing
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage.getFirstExpectedURL());
        Assert.assertEquals(checkoutPage.getCheckoutHeader().getText(), checkoutPage.getFirstCheckoutHeaderText());
        // we leave the last name field empty and input the rest
        Assert.assertTrue(checkoutPage.getLastNameField().getText().isEmpty());
        checkoutPage.firstNameFieldInput("Test");
        checkoutPage.postalCodeFieldInput("20000");
        checkoutPage.clickOnContinueButton();
        // we should get the appropriate error message
        Assert.assertTrue(checkoutPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), checkoutPage.getErrorMessageLastName());
        // now we assert that we're still on the same page
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage.getFirstExpectedURL());
        Assert.assertEquals(checkoutPage.getCheckoutHeader().getText(), checkoutPage.getFirstCheckoutHeaderText());
        Assert.assertTrue(checkoutPage.getContinueButton().isDisplayed());
    }

    @Test(priority = 60)
    public void userCannotSubmitFormWithoutFillingPostalCodeField() {
        // first we make sure we're actually on the correct page before testing
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage.getFirstExpectedURL());
        Assert.assertEquals(checkoutPage.getCheckoutHeader().getText(), checkoutPage.getFirstCheckoutHeaderText());
        Assert.assertTrue(checkoutPage.getPostalCodeField().getText().isEmpty());
        // we leave the postal code field empty and input the rest
        checkoutPage.firstNameFieldInput("Test");
        checkoutPage.lastNameFieldInput("Testing");
        checkoutPage.clickOnContinueButton();
        // we should get the appropriate error message
        Assert.assertTrue(checkoutPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), checkoutPage.getErrorMessagePostalCode());
        // now we assert that we're still on the same page
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage.getFirstExpectedURL());
        Assert.assertEquals(checkoutPage.getCheckoutHeader().getText(), checkoutPage.getFirstCheckoutHeaderText());
        Assert.assertTrue(checkoutPage.getContinueButton().isDisplayed());
    }

    @Test(priority = 70)
    public void userCanFinishPurchase() {
        // we skip straight to the finish button
        checkoutPage.firstNameFieldInput("Test");
        checkoutPage.lastNameFieldInput("Testing");
        checkoutPage.postalCodeFieldInput("20000");
        checkoutPage.clickOnContinueButton();
        checkoutPage.clickOnFinishButton();
        // now we assert that we're on the proper page
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage.getThirdExpectedURL());
        Assert.assertEquals(checkoutPage.getCheckoutHeader().getText(), checkoutPage.getThirdCheckoutHeaderText());
        Assert.assertEquals(checkoutPage.getThankYouNote().getText(), checkoutPage.getThankYouText());
        Assert.assertTrue(checkoutPage.getCheckmarkImage().isDisplayed());
        Assert.assertTrue(checkoutPage.getBackHomeButton().isDisplayed());
    }

    @Test(priority = 80)
    public void backHomeButtonWorks() {
        // we skip straight to the finish button
        checkoutPage.firstNameFieldInput("Test");
        checkoutPage.lastNameFieldInput("Testing");
        checkoutPage.postalCodeFieldInput("20000");
        checkoutPage.clickOnContinueButton();
        checkoutPage.clickOnFinishButton();
        // now we assert that we're on the proper page
        Assert.assertTrue(checkoutPage.getBackHomeButton().isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage.getThirdExpectedURL());
        Assert.assertEquals(checkoutPage.getCheckoutHeader().getText(), checkoutPage.getThirdCheckoutHeaderText());
        checkoutPage.clickOnBackHomeButton();
        // after that we assert that we're redirected back to the main page
        Assert.assertEquals(driver.getCurrentUrl(), mainPage.getExpectedURL());
        Assert.assertEquals(checkoutPage.getCheckoutHeader().getText(), mainPage.getMainPageHeaderText());
    }

    // place for future price check tests


    @AfterMethod
    public void resetPage (){
        resetMethod();
        // we use the site's reset button before continuing testing
    }




}
