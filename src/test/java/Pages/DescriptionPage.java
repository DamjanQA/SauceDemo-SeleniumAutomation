package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DescriptionPage {

    WebDriver driver;
    WebElement itemName;
    String expectedURL = "https://www.saucedemo.com/inventory-item.html?id=";
    WebElement backToProductsButton;
    WebElement addToCartButton;
    WebElement removeButton;

    public DescriptionPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getItemName() {
        return driver.findElement(By.cssSelector(".inventory_details_name.large_size"));
    }

    public String getExpectedURL() {
        return expectedURL;
    }

    public WebElement getBackToProductsButton() {
        return driver.findElement(By.id("back-to-products"));
    }

    public WebElement getAddToCartButton() {
        return driver.findElement(By.id("add-to-cart"));
    }

    public WebElement getRemoveButton() {
        return driver.findElement(By.id("remove"));
    }

    // -------------------

    public String getCurrentURLWithoutIDNumber() {
        String currentURLNoID = driver.getCurrentUrl();
        currentURLNoID = currentURLNoID.substring(0, (currentURLNoID.length() - 1));
        return currentURLNoID;
    }

    public void clickOnAddToCartButton() {
        getAddToCartButton().click();
    }

    public void clickOnRemoveButton() {
        getRemoveButton().click();
    }

    public void clickOnBackToProductsButton() {
        getBackToProductsButton().click();
    }


}
