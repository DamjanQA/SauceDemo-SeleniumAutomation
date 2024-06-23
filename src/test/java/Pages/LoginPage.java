package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;
    WebElement usernameField;
    WebElement passwordField;
    WebElement loginButton;
    WebElement errorMessage;
    String errorText = "Epic sadface: Username and password do not match any user in this service";
    String errorTextEmptyUsername = "Epic sadface: Username is required";
    String errorTextEmptyPassword = "Epic sadface: Password is required";
    String expectedURL = "https://www.saucedemo.com/";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameField() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.id("login-button"));
    }

    public WebElement getErrorMessage() {
        return driver.findElement(By.cssSelector(".error-message-container.error"));
    }

    public String getErrorText() {
        return errorText;
    }

    public String getErrorTextEmptyUsername() {
        return errorTextEmptyUsername;
    }

    public String getErrorTextEmptyPassword() {
        return errorTextEmptyPassword;
    }

    public String getExpectedURL() {
        return expectedURL;
    }

    // --------------------------------

    public void usernameFieldInput(String username) {
        getUsernameField().clear();
        getUsernameField().sendKeys(username);
    }

    public void passwordFieldInput(String password) {
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }
}
