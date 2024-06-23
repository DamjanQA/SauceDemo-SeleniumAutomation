package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SidebarTests extends BaseTest {

    @BeforeMethod
    public void pageSetup() {
        driver.get("https://www.saucedemo.com/");
        loginMethod();
        // ^so we don't repeat too many lines of code
    }

    @Test (priority = 10)
    public void hamburgerMenuButtonWorks() {
        // first we make sure the hamburger menu is visible on main page
        Assert.assertTrue(sidebarPage.getBurgerMenuButton().isDisplayed());
        sidebarPage.clickOnBurgerMenuButton();
        wait.until(ExpectedConditions.visibilityOf(sidebarPage.getCloseButton()));
        // we wait to make sure all the buttons load properly
        Assert.assertTrue(sidebarPage.allHamburgerButtonsArePresent());
        // first we check whether all the buttons are present
        // next we check whether the appropriate text is displayed for each
        Assert.assertEquals(sidebarPage.getAllItemsButton().getText(), sidebarPage.getAllItemsText());
        Assert.assertEquals(sidebarPage.getAboutButton().getText(), sidebarPage.getAboutText());
        Assert.assertEquals(sidebarPage.getLogoutButton().getText(), sidebarPage.getLogoutText());
        Assert.assertEquals(sidebarPage.getResetButton().getText(), sidebarPage.getResetAppStateText());
    }
    @Test (priority = 20)
    public void hamburgerMenuCloseButtonWorks() {
        sidebarPage.clickOnBurgerMenuButton();
        // we wait to make sure all the buttons load properly
        wait.until(ExpectedConditions.visibilityOf(sidebarPage.getCloseButton()));
        // first we check whether all the buttons are present (so we can check again after we close; control test)
        Assert.assertTrue(sidebarPage.allHamburgerButtonsArePresent());
        Assert.assertTrue(sidebarPage.getCloseButton().isDisplayed());
        // we make sure the close button is actually present before clicking
        sidebarPage.clickOnCloseButton();
        // we wait to make sure everything is properly closed
        wait.until(ExpectedConditions.invisibilityOf(sidebarPage.getCloseButton()));
        // we make sure that the previously visible buttons are not visible anymore
        Assert.assertFalse(sidebarPage.allHamburgerButtonsArePresent());
        Assert.assertFalse(sidebarPage.hamburgerMenuCloseButtonIsVisible());
    }

    @Test (priority = 30)
    public void hamburgerMenuAboutButtonWorks() {
        sidebarPage.clickOnBurgerMenuButton();
        // we wait to make sure all the buttons load properly
        wait.until(ExpectedConditions.visibilityOf(sidebarPage.getCloseButton()));
        // first we make sure the about button is properly displayed
        Assert.assertEquals(sidebarPage.getAboutButton().getText(), sidebarPage.getAboutText());
        Assert.assertTrue(sidebarPage.hamburgerMenuAboutButtonIsVisible());
        sidebarPage.clickOnAboutButton();
        // we should be redirected to the about page (note: there is none for this test site, just sauce labs homepage)
        Assert.assertEquals(driver.getCurrentUrl(), sidebarPage.getExpectedURLAboutPage());
    }
    @Test (priority = 40)
    public void hamburgerMenuLogoutButtonWorks() {
        sidebarPage.clickOnBurgerMenuButton();
        // we wait to make sure all the buttons load properly
        wait.until(ExpectedConditions.visibilityOf(sidebarPage.getCloseButton()));
        // first we make sure the logout button is properly displayed
        Assert.assertEquals(sidebarPage.getLogoutButton().getText(), sidebarPage.getLogoutText());
        Assert.assertTrue(sidebarPage.hamburgerMenuLogoutButtonIsVisible());
        sidebarPage.clickOnLogoutButton();
        // we should be redirected to the login page and there should be a login button
        Assert.assertEquals(driver.getCurrentUrl(), sidebarPage.getExpectedURLLogout());
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
    }





}
