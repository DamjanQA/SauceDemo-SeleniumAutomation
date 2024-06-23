package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DescriptionTests extends BaseTest {

    @BeforeMethod
    public void pageSetup() {
        driver.get("https://www.saucedemo.com/");
        loginMethod();
        // ^ so we don't repeat too many lines of code
        mainPage.goToPageOfSelectedItem();
        // this saves the name of a randomly selected item before going to its description page
        // we do this because we want to make sure that the item's description page name matches the one on the main page
    }

    @Test(priority = 10)
    public void itemHasDescriptionPage() {
        // we compare the description page name of an item with its main page name
        Assert.assertEquals(descriptionPage.getItemName().getText(), mainPage.getSavedItemName());
        // we also make sure we're on the correct page (description page but without individual IDs)
        // the back to products button also indicates that we are on a description page
        Assert.assertEquals(descriptionPage.getCurrentURLWithoutIDNumber(), descriptionPage.getExpectedURL());
        Assert.assertTrue(descriptionPage.getBackToProductsButton().isDisplayed());
    }

    @Test(priority = 20)
    public void itemCanBeAddedToCartOnDescriptionPage() {
        // we compare the description page name of an item with its main page name
        Assert.assertEquals(descriptionPage.getItemName().getText(), mainPage.getSavedItemName());
        // we also make sure we're on the correct page (description page but without individual IDs)
        // the back to products button also indicates that we are on a description page
        Assert.assertEquals(descriptionPage.getCurrentURLWithoutIDNumber(), descriptionPage.getExpectedURL());
        Assert.assertTrue(descriptionPage.getBackToProductsButton().isDisplayed());
        // we also make sure the cart is empty before testing it
        Assert.assertTrue(mainPage.cartIsEmpty());
        // after that we try to add the item to our cart
        descriptionPage.clickOnAddToCartButton();
        // we should get a cart icon pop-out with the number 1 displayed on it
        Assert.assertTrue(mainPage.getCartIcon().isDisplayed());
        Assert.assertEquals(mainPage.getCartIcon().getText(), "1");
        Assert.assertTrue(descriptionPage.getRemoveButton().isDisplayed());
        // we also assert that the "Remove" button appears after we add the item
    }

    @Test(priority = 30)
    public void itemCanBeRemovedFromCartOnDescriptionPage() {
        // we just go straight to adding the item and testing the remove feature
        // we also make sure the cart is empty before testing it
        Assert.assertTrue(mainPage.cartIsEmpty());
        descriptionPage.clickOnAddToCartButton();
        // we first assert that the item has been properly added to our cart
        // we should get a cart icon pop-out with the number 1 displayed on it
        Assert.assertTrue(mainPage.getCartIcon().isDisplayed());
        Assert.assertEquals(mainPage.getCartIcon().getText(), "1");
        Assert.assertTrue(descriptionPage.getRemoveButton().isDisplayed());
        // we also assert that the "Remove" button appears after we add the item
        descriptionPage.clickOnRemoveButton();
        // now we can proceed to assert whether the remove button works or not
        Assert.assertTrue(mainPage.cartIsEmpty());
        Assert.assertTrue(descriptionPage.getAddToCartButton().isDisplayed());
    }

    @Test(priority = 40)
    public void backToProductsButtonWorksOnDescriptionPage() {
        // first we make sure that we're actually on a description page
        Assert.assertEquals(descriptionPage.getCurrentURLWithoutIDNumber(), descriptionPage.getExpectedURL());
        Assert.assertTrue(descriptionPage.getBackToProductsButton().isDisplayed());
        descriptionPage.clickOnBackToProductsButton();
        Assert.assertEquals(driver.getCurrentUrl(), mainPage.getExpectedURL());
        // we assert that we are now back on the main page
    }

    @AfterMethod
    public void resetPage() {
        resetMethod();
        // we use the site's reset button before continuing testing
    }
}
