package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @BeforeMethod
    public void pageSetup() {
        driver.get("https://www.saucedemo.com/");
        loginMethod();
        // ^so we don't repeat too many lines of code
    }

    @Test(priority = 10)
    public void userCanAddItemToCartOnMainPage() {
        // first we make sure we're actually on the correct page before testing
        Assert.assertEquals(driver.getCurrentUrl(), mainPage.getExpectedURL());
        Assert.assertEquals(mainPage.getPageHeader().getText(), mainPage.getExpectedText());
        // then we make sure the cart is empty and that there is an "Add to Cart" button displayed
        Assert.assertTrue(mainPage.cartIsEmpty());
        Assert.assertTrue(mainPage.thereIsAddToCartButton());
        // we select a random item and add it to our cart
        mainPage.addRandomItemToCart();
        // we check that a remove button is displayed on the proper item
        Assert.assertTrue(mainPage.thereIsRemoveButton());
        // we also make sure that the cart pop-out appears with the correct number (1)
        Assert.assertTrue(mainPage.getCartIcon().isDisplayed());
        Assert.assertEquals(mainPage.getCartIcon().getText(), "1");
    }

    @Test(priority = 20)
    public void userCanRemoveItemFromCartOnMainPage() {
        // first we make sure we're actually on the correct page before testing
        Assert.assertEquals(driver.getCurrentUrl(), mainPage.getExpectedURL());
        Assert.assertEquals(mainPage.getPageHeader().getText(), mainPage.getExpectedText());
        Assert.assertTrue(mainPage.cartIsEmpty());
        // we make sure the cart is empty before adding a random item
        mainPage.addRandomItemToCart();
        Assert.assertTrue(mainPage.thereIsRemoveButton());
        // we check that a remove button is displayed on the proper item
        // we also make sure that the cart pop-out appears with the correct number (1)
        Assert.assertTrue(mainPage.getCartIcon().isDisplayed());
        Assert.assertEquals(mainPage.getCartIcon().getText(), "1");
        mainPage.clickOnRemoveButton();
        // the cart should be empty and the "Add to Cart" button should appear for our item
        Assert.assertTrue(mainPage.cartIsEmpty());
        Assert.assertTrue(mainPage.thereIsAddToCartButton());
    }

    @Test(priority = 30)
    public void cartHasAllSelectedItemsDisplayedOnCartPage() {
        // first we make sure we're actually on the correct page before testing
        Assert.assertEquals(driver.getCurrentUrl(), mainPage.getExpectedURL());
        Assert.assertEquals(mainPage.getPageHeader().getText(), mainPage.getExpectedText());
        Assert.assertTrue(mainPage.cartIsEmpty());
        // we make sure the cart is empty before adding all the items
        mainPage.addAllItemsToCart();
        // the cart pop-out appears with the correct number (6)
        Assert.assertTrue(mainPage.getCartIcon().isDisplayed());
        Assert.assertEquals(mainPage.getCartIcon().getText(), "6");
        mainPage.clickOnCartIcon();
        // now we go to the cart page
        // we make sure we're actually on the cart page
        Assert.assertEquals(driver.getCurrentUrl(), cartPage.getExpectedURL());
        Assert.assertTrue(cartPage.getContinueShoppingButton().isDisplayed());
        // apart from the URL, the "Continue Shopping" button proves that we're on the correct page
        Assert.assertTrue(cartPage.allItemsAreDisplayed());
        // this method compares the names of all the listed items vs those on the main page
    }

    @Test(priority = 40)
    public void continueShoppingButtonWorks() {
        mainPage.clickOnEmptyCartIcon();
        // we make sure we're on the correct page and that the button is there before testing
        Assert.assertEquals(driver.getCurrentUrl(), cartPage.getExpectedURL());
        Assert.assertTrue(cartPage.getContinueShoppingButton().isDisplayed());
        cartPage.clickOnContinueShoppingButton();
        // we should get redirected back to the main page
        Assert.assertEquals(driver.getCurrentUrl(), mainPage.getExpectedURL());
        Assert.assertEquals(mainPage.getPageHeader().getText(), mainPage.getExpectedText());
    }

    @Test(priority = 50)
    public void checkoutButtonWorks() {
        mainPage.clickOnEmptyCartIcon();
        // we make sure we're on the correct page and that the button is there before testing
        Assert.assertEquals(driver.getCurrentUrl(), cartPage.getExpectedURL());
        Assert.assertTrue(cartPage.getCheckoutButton().isDisplayed());
        cartPage.clickOnCheckoutButton();
        // we should get redirected to the checkout page
        Assert.assertEquals(driver.getCurrentUrl(), checkoutPage.getFirstExpectedURL());
        Assert.assertEquals(checkoutPage.getCheckoutHeader().getText(), checkoutPage.getFirstCheckoutHeaderText());
    }

    @Test(priority = 60)
    public void removeButtonOnCartPageWorks() throws InterruptedException {
        // we add a random item and then proceed to cart page
        mainPage.addRandomItemToCart();
        mainPage.clickOnEmptyCartIcon();
        // we make sure we're actually on the cart page
        Assert.assertEquals(driver.getCurrentUrl(), cartPage.getExpectedURL());
        Assert.assertTrue(cartPage.getContinueShoppingButton().isDisplayed());
        cartPage.clickOnRemoveButtons(1);
        // we check the cart to see whether it's empty
        Assert.assertTrue(mainPage.cartIsEmpty());
    }


    @AfterMethod
    public void resetPage (){
        resetMethod();
        // we use the site's reset button before continuing testing
    }


}
