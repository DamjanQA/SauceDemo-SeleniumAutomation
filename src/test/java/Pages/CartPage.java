package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    WebDriver driver;
    String expectedURL = "https://www.saucedemo.com/cart.html";
    WebElement continueShoppingButton;
    WebElement checkoutButton;
    List<WebElement> itemNames;
    String itemNameOne = "Test.allTheThings() T-Shirt (Red)";
    String itemNameTwo = "Sauce Labs Onesie";
    String itemNameThree = "Sauce Labs Fleece Jacket";
    String itemNameFour = "Sauce Labs Bolt T-Shirt";
    String itemNameFive = "Sauce Labs Bike Light";
    String itemNameSix = "Sauce Labs Backpack";
    String cartHeader = "Your Cart";
    List<WebElement> removeButtons;


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getExpectedURL() {
        return expectedURL;
    }

    public WebElement getContinueShoppingButton() {
        return driver.findElement(By.cssSelector(".btn.btn_secondary.back.btn_medium"));
    }

    public WebElement getCheckoutButton() {
        return driver.findElement(By.cssSelector(".btn.btn_action.btn_medium.checkout_button"));
    }

    public List<WebElement> getItemDisplayNames() {
        return driver.findElements(By.className("inventory_item_name"));
    }

    public ArrayList<String> getItemStringNames() {
        ArrayList<String> list = new ArrayList<>();
        list.add(itemNameOne);
        list.add(itemNameTwo);
        list.add(itemNameThree);
        list.add(itemNameFour);
        list.add(itemNameFive);
        list.add(itemNameSix);
        return list;
    }

    public String getCartHeader() {
        return cartHeader;
    }

    public List<WebElement> getRemoveButtons() {
        return driver.findElements(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));
    }



    // ----------------------------

    public void clickOnContinueShoppingButton() {
        getContinueShoppingButton().click();
    }

    public void clickOnCheckoutButton() {
        getCheckoutButton().click();
    }

    public void clickOnRemoveButtons(int numberOfItems) {
        getRemoveButtons().get(numberOfItems - 1);
    }

    public boolean allItemsAreDisplayed() {
        boolean result = false;
        int count = 0;
        for (int i = 0; i < getItemDisplayNames().size(); i++) {
            if (getItemDisplayNames().get(i).getText().equals(getItemStringNames().get(i))) {
                count++;
            }
        }
        if (count == getItemStringNames().size()) {
            result = true;
        }
        return result;
    }




}
