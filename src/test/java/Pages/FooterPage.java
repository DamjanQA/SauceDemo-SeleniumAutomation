package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class FooterPage {

    WebDriver driver;
    WebElement twitterIcon;
    WebElement facebookIcon;
    WebElement linkedinIcon;
    String expectedURLTwitter = "https://x.com/saucelabs";
    String expectedURLFacebook = "https://www.facebook.com/saucelabs";
    String expectedURLLinkedIn = "https://www.linkedin.com/company/sauce-labs/";


    public FooterPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTwitterIcon() {
        return driver.findElement(By.linkText("Twitter"));
    }

    public WebElement getFacebookIcon() {
        return driver.findElement(By.linkText("Facebook"));
    }

    public WebElement getLinkedinIcon() {
        return driver.findElement(By.linkText("LinkedIn"));
    }

    public String getExpectedURLTwitter() {
        return expectedURLTwitter;
    }

    public String getExpectedURLFacebook() {
        return expectedURLFacebook;
    }

    public String getExpectedURLLinkedIn() {
        return expectedURLLinkedIn;
    }

    // ----------------------------------

    public void clickOnTwitterIcon() {
        getTwitterIcon().click();
    }

    public void clickOnFacebookIcon() {
        getFacebookIcon().click();
    }

    public void clickOnLinkedInIcon() {
        getLinkedinIcon().click();
    }

    public void switchToNewTabWindow(int x) {
        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(x));
    }
}
