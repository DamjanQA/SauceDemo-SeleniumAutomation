package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class MainPage {

    WebDriver driver;
    String expectedURL = "https://www.saucedemo.com/inventory.html";
    List<WebElement> itemNames;
    List<WebElement> addButtons;
    List<WebElement> removeButtons;
    WebElement removeButton;
    WebElement cartIcon;
    WebElement emptyCartIcon;
    int itemNumber = 0;
    List<WebElement> inventory;
    WebElement pageHeader;
    String expectedText = "Swag Labs";
    String savedItemName = "";
    String mainPageHeaderText = "Products";
    WebElement sortIcon;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getExpectedURL() {
        return expectedURL;
    }

    public List<WebElement> getItemNames() {
        return driver.findElements(By.className("inventory_item_name"));
    }

    public List<WebElement> getAddButtons() {
        return driver.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
    }

    public List<WebElement> getRemoveButtons() {
        return driver.findElements(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory"));
    }

    public WebElement getRemoveButton() {
        return driver.findElement(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory"));
    }

    public WebElement getCartIcon() {
        return driver.findElement(By.className("shopping_cart_badge"));
    }

    public WebElement getEmptyCartIcon() {
        return driver.findElement(By.className("shopping_cart_link"));
    }

    public List<WebElement> getInventory() {
        return driver.findElements(By.className("inventory_item"));
    }

    public WebElement getPageHeader() {
        return driver.findElement(By.className("header_label"));
    }

    public String getExpectedText() {
        return expectedText;
    }

    public String getSavedItemName() {
        return savedItemName;
    }

    public String getMainPageHeaderText() {
        return mainPageHeaderText;
    }

    public WebElement getSortIcon() {
        return driver.findElement(By.className("product_sort_container"));
    }

    // ---------------------------------

    public void goToPageOfSelectedItem() {
        Random random = new Random();
        itemNumber = random.nextInt(0, getItemNames().size());
        // first it saves the name of the item
        savedItemName = getItemNames().get(itemNumber).getText();
        // then it goes to its description page
        getItemNames().get(itemNumber).click();
    }

    public void clickOnCartIcon() {
        getCartIcon().click();
    }

    public void clickOnEmptyCartIcon() {
        getEmptyCartIcon().click();
    }

    public void addRandomItemToCart() {
        Random random = new Random();
        itemNumber = random.nextInt(0, getItemNames().size());
        getAddButtons().get(itemNumber).click();
    }

    public boolean thereIsRemoveButton() {
        boolean result = false;
        if (getInventory().get(itemNumber).findElement(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory")).isDisplayed()) {
            result = true;
        }
        return result;
    }

    public boolean thereIsAddToCartButton() {
        boolean result = false;
        if (getInventory().get(itemNumber).findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory")).isDisplayed()) {
            result = true;
        }
        return result;
    }

    public void clickOnRemoveButton() {
        getInventory().get(itemNumber).findElement(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory")).click();
    }

    public boolean cartIsEmpty() {
        boolean result = true;
        try {
            if (getCartIcon().isDisplayed()) {
                result = false;
            }
        } catch (Exception ignore) {
        }
        return true;
    }

    public void addAllItemsToCart() {
        int buttons = getAddButtons().size() - 1;
        for (int i = buttons; i >= 0; i--) {
            getAddButtons().get(i).click();
        }
    }


}
