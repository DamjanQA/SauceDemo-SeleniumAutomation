package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void pageSetup() {
        driver.get("https://www.saucedemo.com/");
    }

    @Test(priority = 10)
    public void userCanLogInWithValidCredentials() {
        // first we make sure we're on the right page, otherwise the test will instantly fail
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getExpectedURL());
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        // now we fill in the valid login credentials and press login
        loginPage.usernameFieldInput("standard_user");
        loginPage.passwordFieldInput("secret_sauce");
        loginPage.clickOnLoginButton();
        // after this we should get redirected to the main page of the site, with the following elements:
        Assert.assertEquals(driver.getCurrentUrl(), mainPage.getExpectedURL());
        Assert.assertEquals(mainPage.getPageHeader().getText(), mainPage.getExpectedText());
        wait.until(ExpectedConditions.visibilityOf(sidebarPage.getBurgerMenuButton()));
        // we also assert that there is a logout button, implying that we are, in fact, logged in
        sidebarPage.clickOnBurgerMenuButton();
        wait.until(ExpectedConditions.visibilityOf(sidebarPage.getLogoutButton()));
        Assert.assertTrue(sidebarPage.getLogoutButton().isDisplayed());
    }

    @Test(priority = 20)
    public void userCannotLogInWithInvalidUsername() {
        // first we make sure we're on the right page, otherwise the test will instantly fail
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getExpectedURL());
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        // now we fill in the invalid username, valid password, and then we press login
        loginPage.usernameFieldInput("invalid_user");
        loginPage.passwordFieldInput("secret_sauce");
        loginPage.clickOnLoginButton();
        // we should get the following error message:
        Assert.assertEquals(loginPage.getErrorMessage().getText(), loginPage.getErrorText());
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        // if we're not logged in, that means we are still on the login page and there is a login button
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getExpectedURL());
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
    }

    @Test(priority = 30)
    public void userCannotLogInWithInvalidPassword() {
        // first we make sure we're on the right page, otherwise the test will instantly fail
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getExpectedURL());
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        // now we fill in the valid username, invalid password, and then we press login
        loginPage.usernameFieldInput("standard_user");
        loginPage.passwordFieldInput("invalid_pass");
        loginPage.clickOnLoginButton();
        // we should get the following error message:
        Assert.assertEquals(loginPage.getErrorMessage().getText(), loginPage.getErrorText());
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        // if we're not logged in, that means we are still on the login page and there is a login button
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getExpectedURL());
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
    }

    @Test(priority = 40)
    public void userCannotLogInWithEmptyCredentials() {
        // first we make sure we're on the right page, otherwise the test will instantly fail
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getExpectedURL());
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        // we leave all the input fields empty and press login
        Assert.assertTrue(loginPage.getUsernameField().getText().isEmpty());
        Assert.assertTrue(loginPage.getPasswordField().getText().isEmpty());
        loginPage.clickOnLoginButton();
        // we should get the following error message:
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), loginPage.getErrorTextEmptyUsername());
        // if we're not logged in, that means we are still on the login page and there is a login button
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getExpectedURL());
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
    }

    @Test(priority = 50)
    public void userCannotLogInWithEmptyUsernameField() {
        // first we make sure we're on the right page, otherwise the test will instantly fail
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getExpectedURL());
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        // we leave the username field empty, input the valid password, and then press login
        Assert.assertTrue(loginPage.getUsernameField().getText().isEmpty());
        loginPage.passwordFieldInput("secret_sauce");
        loginPage.clickOnLoginButton();
        // we should get the following error message:
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), loginPage.getErrorTextEmptyUsername());
        // if we're not logged in, that means we are still on the login page and there is a login button
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getExpectedURL());
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
    }

    @Test(priority = 60)
    public void userCannotLogInWithEmptyPasswordField() {
        // first we make sure we're on the right page, otherwise the test will instantly fail
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getExpectedURL());
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
        // we input the valid username, leave the password field empty, and then press login
        loginPage.usernameFieldInput("standard_user");
        Assert.assertTrue(loginPage.getPasswordField().getText().isEmpty());
        loginPage.clickOnLoginButton();
        // we should get the following error message:
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginPage.getErrorMessage().getText(), loginPage.getErrorTextEmptyPassword());
        // if we're not logged in, that means we are still on the login page and there is a login button
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getExpectedURL());
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
    }


}
