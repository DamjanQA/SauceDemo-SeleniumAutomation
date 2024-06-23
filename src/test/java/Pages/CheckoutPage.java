package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BaseTest {

    WebDriver driver;
    String firstExpectedURL = "https://www.saucedemo.com/checkout-step-one.html";
    String secondExpectedURL = "https://www.saucedemo.com/checkout-step-two.html";
    String thirdExpectedURL = "https://www.saucedemo.com/checkout-complete.html";
    WebElement checkoutHeader;
    String firstCheckoutHeaderText = "Checkout: Your Information";
    String secondCheckoutHeaderText = "Checkout: Overview";
    String thirdCheckoutHeaderText = "Checkout: Complete!";
    WebElement firstNameField;
    WebElement lastNameField;
    WebElement postalCodeField;
    WebElement continueButton;
    WebElement cancelButton;
    WebElement errorMessage;
    String errorMessageFirstName = "Error: First Name is required";
    String errorMessageLastName = "Error: Last Name is required";
    String errorMessagePostalCode = "Error: Postal Code is required";
    WebElement finishButton;
    WebElement backHomeButton;
    WebElement checkmarkImage;
    WebElement thankYouNote;
    String thankYouText = "Thank you for your order!";
    WebElement itemPrice;
    WebElement tax;
    WebElement totalPrice;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstExpectedURL() {
        return firstExpectedURL;
    }

    public String getSecondExpectedURL() {
        return secondExpectedURL;
    }

    public String getThirdExpectedURL() {
        return thirdExpectedURL;
    }

    public WebElement getCheckoutHeader() {
        return driver.findElement(By.className("title"));
    }

    public String getFirstCheckoutHeaderText() {
        return firstCheckoutHeaderText;
    }

    public String getSecondCheckoutHeaderText() {
        return secondCheckoutHeaderText;
    }

    public String getThirdCheckoutHeaderText() {
        return thirdCheckoutHeaderText;
    }

    public WebElement getFirstNameField() {
        return driver.findElement(By.id("first-name"));
    }

    public WebElement getLastNameField() {
        return driver.findElement(By.id("last-name"));
    }

    public WebElement getPostalCodeField() {
        return driver.findElement(By.id("postal-code"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.id("continue"));
    }

    public WebElement getCancelButton() {
        return driver.findElement(By.id("cancel"));
    }

    public WebElement getErrorMessage() {
        return driver.findElement(By.tagName("h3"));
    }

    public String getErrorMessageFirstName() {
        return errorMessageFirstName;
    }

    public String getErrorMessageLastName() {
        return errorMessageLastName;
    }

    public String getErrorMessagePostalCode() {
        return errorMessagePostalCode;
    }

    public WebElement getFinishButton() {
        return driver.findElement(By.id("finish"));
    }

    public WebElement getBackHomeButton() {
        return driver.findElement(By.id("back-to-products"));
    }

    public WebElement getCheckmarkImage() {
        return driver.findElement(By.className("pony_express"));
    }

    public WebElement getThankYouNote() {
        return driver.findElement(By.className("complete-header"));
    }

    public String getThankYouText() {
        return thankYouText;
    }

    public WebElement getItemPrice() {
        return driver.findElement(By.className("inventory_item_price"));
    }

    public WebElement getTax() {
        return driver.findElement(By.className("summary_tax_label"));
    }

    public WebElement getTotalPrice() {
        return driver.findElement(By.className("summary_total_label"));
    }

    // --------------------------------

    public void clickOnContinueButton() {
        getContinueButton().click();
    }

    public void clickOnCancelButton() {
        getCancelButton().click();
    }

    public void clickOnFinishButton() {
        getFinishButton().click();
    }

    public void clickOnBackHomeButton() {
        getBackHomeButton().click();
    }

    public void firstNameFieldInput(String firstName) {
        getFirstNameField().clear();
        getFirstNameField().sendKeys(firstName);
    }

    public void lastNameFieldInput(String lastName) {
        getLastNameField().clear();
        getLastNameField().sendKeys(lastName);
    }

    public void postalCodeFieldInput(String postalCode) {
        getPostalCodeField().clear();
        getPostalCodeField().sendKeys(postalCode);
    }




}
