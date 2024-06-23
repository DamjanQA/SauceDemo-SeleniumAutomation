package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SidebarPage {
    WebDriver driver;
    WebElement logoutButton;
    WebElement burgerMenuButton;
    WebElement resetButton;
    WebElement allItemsButton;
    WebElement aboutButton;
    WebElement closeButton;
    String allItemsText = "All Items";
    String aboutText = "About";
    String logoutText = "Logout";
    String resetAppStateText = "Reset App State";
    String expectedURLAboutPage = "https://saucelabs.com/";
    String expectedURLLogout = "https://www.saucedemo.com/";

    public SidebarPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.id("logout_sidebar_link"));
    }

    public WebElement getBurgerMenuButton() {
        return driver.findElement(By.id("react-burger-menu-btn"));
    }

    public WebElement getResetButton() {
        return driver.findElement(By.id("reset_sidebar_link"));
    }

    public WebElement getAllItemsButton() {
        return driver.findElement(By.id("inventory_sidebar_link"));
    }

    public WebElement getAboutButton() {
        return driver.findElement(By.id("about_sidebar_link"));
    }

    public WebElement getCloseButton() {
        return driver.findElement(By.id("react-burger-cross-btn"));
    }

    public String getAllItemsText() {
        return allItemsText;
    }

    public String getAboutText() {
        return aboutText;
    }

    public String getLogoutText() {
        return logoutText;
    }

    public String getResetAppStateText() {
        return resetAppStateText;
    }

    public String getExpectedURLAboutPage() {
        return expectedURLAboutPage;
    }

    public String getExpectedURLLogout() {
        return expectedURLLogout;
    }

    // ---------------------------

    public void clickOnBurgerMenuButton() {
        getBurgerMenuButton().click();
    }

    public void clickOnResetButton() {
        getResetButton().click();
    }

    public void clickOnCloseButton() {
        getCloseButton().click();
    }

    public void clickOnAboutButton() {
        getAboutButton().click();
    }

    public void clickOnLogoutButton() {
        getLogoutButton().click();
    }

    public boolean hamburgerMenuCloseButtonIsVisible() {
        boolean result = false;
        try {
            if (getCloseButton().isDisplayed()) {
                result = true;
            }
        } catch (Exception ignore) {
        }
        return result;
    }

    public boolean hamburgerMenuAboutButtonIsVisible() {
        boolean result = false;
        try {
            if (getAboutButton().isDisplayed()) {
                result = true;
            }
        } catch (Exception ignore) {
        }
        return result;
    }

    public boolean hamburgerMenuLogoutButtonIsVisible() {
        boolean result = false;
        try {
            if (getLogoutButton().isDisplayed()) {
                result = true;
            }
        } catch (Exception ignore) {
        }
        return result;
    }

    public boolean allHamburgerButtonsArePresent() {
        boolean result = false;
        try {
            if (getAllItemsButton().isDisplayed()) {
                result = true;
                if (getAboutButton().isDisplayed()) {
                    result = true;
                    if (getLogoutButton().isDisplayed()) {
                        result = true;
                        if (getResetButton().isDisplayed()) {
                            result = true;
                            if (getCloseButton().isDisplayed()) {
                                result = true;
                            } else {
                                result = false;
                            }
                        } else {
                            result = false;
                        }
                    } else {
                        result = false;
                    }
                } else {
                    result = false;
                }
            } else {
                result = false;
            }
        } catch (Exception ignore) {
        }
        return result;
    }
}
