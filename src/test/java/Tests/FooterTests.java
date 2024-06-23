package Tests;

import Base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FooterTests extends BaseTest {

    @BeforeMethod
    public void pageSetup() {
        driver.get("https://www.saucedemo.com/");
        loginMethod();
        // ^so we don't repeat too many lines of code
    }

    @Test(priority = 10)
    public void twitterIconIsProperlyHyperlinked() {
        // first we make sure that we're actually on the main page
        Assert.assertEquals(driver.getCurrentUrl(), mainPage.getExpectedURL());
        Assert.assertEquals(mainPage.getPageHeader().getText(), mainPage.getExpectedText());
        footerPage.clickOnTwitterIcon();
        footerPage.switchToNewTabWindow(1);
        // we switch to the newly opened tab and wait for the URL to load properly before asserting
        wait.until(ExpectedConditions.urlToBe(footerPage.getExpectedURLTwitter()));
        Assert.assertEquals(driver.getCurrentUrl(), footerPage.getExpectedURLTwitter());
        // we should be on sauce labs Twitter profile page
    }

    @Test(priority = 20)
    public void facebookIconIsProperlyHyperlinked() {
        // first we make sure that we're actually on the main page
        Assert.assertEquals(driver.getCurrentUrl(), mainPage.getExpectedURL());
        Assert.assertEquals(mainPage.getPageHeader().getText(), mainPage.getExpectedText());
        footerPage.clickOnFacebookIcon();
        footerPage.switchToNewTabWindow(1);
        // we switch to the newly opened tab and wait for the URL to load properly before asserting
        wait.until(ExpectedConditions.urlToBe(footerPage.getExpectedURLFacebook()));
        Assert.assertEquals(driver.getCurrentUrl(), footerPage.getExpectedURLFacebook());
        // we should be on sauce labs Facebook profile page
    }

    @Test(priority = 30)
    public void linkedInIconIsProperlyHyperlinked() {
        // first we make sure that we're actually on the main page
        Assert.assertEquals(driver.getCurrentUrl(), mainPage.getExpectedURL());
        Assert.assertEquals(mainPage.getPageHeader().getText(), mainPage.getExpectedText());
        footerPage.clickOnLinkedInIcon();
        footerPage.switchToNewTabWindow(1);
        // we switch to the newly opened tab and wait for the URL to load properly before asserting
        wait.until(ExpectedConditions.urlToBe(footerPage.getExpectedURLLinkedIn()));
        Assert.assertEquals(driver.getCurrentUrl(), footerPage.getExpectedURLLinkedIn());
        // we should be on sauce labs LinkedIn profile page
    }

    @AfterMethod
    public void resetPage() {
        driver.close();
        // after each test we close the newly opened tab
        // then we switch back to the main tab
        footerPage.switchToNewTabWindow(0);
    }

}
