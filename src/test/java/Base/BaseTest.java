package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    public WebDriver driver;
    public WebDriverWait wait;
    public LoginPage loginPage;
    public MainPage mainPage;
    public SidebarPage sidebarPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public DescriptionPage descriptionPage;
    public FooterPage footerPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        sidebarPage = new SidebarPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        descriptionPage = new DescriptionPage(driver);
        footerPage = new FooterPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    // -------------------------

    public void loginMethod() {
        loginPage.usernameFieldInput("standard_user");
        loginPage.passwordFieldInput("secret_sauce");
        loginPage.clickOnLoginButton();
    }

    public void resetMethod() {
        sidebarPage.clickOnBurgerMenuButton();
        sidebarPage.clickOnResetButton();
    }

}
