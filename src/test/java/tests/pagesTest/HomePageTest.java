package tests.pagesTest;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.pages.HomePage;
import tests.setups.Setups;
import org.testng.Assert;

import java.io.File;

public class HomePageTest {
    private WebDriver driver;
    private HomePage browser;
    private Setups setups = new Setups();

    @BeforeTest
    public void setUp() {
        setups.setPropertyOS();
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        this.browser = new HomePage(driver);
        setups.homePageSetup(driver);
    }

    @AfterMethod
    public void captureScreenFailed(ITestResult result) {

        if(ITestResult.FAILURE==result.getStatus()) {
            setups.captureScreenShot(driver,result.getName());
        }
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test_emptySearchForAnItem_checkMessages() {
        browser.clickSearchButton();
        browser.checkAlertWarningMessages("Please enter a search keyword", "0 results have been found.");
    }

    @Test
    public void test_searchForExistingItems() {
        browser.fillTheSearchField("dress");
        browser.clickSearchButton();
        browser.checkSearchMessages("SEARCH  \"DRESS\"\n" + "7 results have been found.");
    }

    @Test
    public void test_searchForNonExistingItems_checkMessages() {
        browser.fillTheSearchField("test");
        browser.checkAlertWarningMessages("No results were found for your search \"best\"", "0 results have been found.");
    }

    @Test
    public void test_searchForReturnItems_checkIsDiplayedItems() {
        test_searchForExistingItems();
        browser.checkIsDisplayedElements("dress");
    }


    @Test
    public void testaddItemToCart(){
        browser.fillTheSearchField("dress");
        browser.clickSearchButton();
        browser.clickItem("dress", 10);
        browser.waitForElementVisible(driver,"//*[@id=\"our_price_display\"]");
        String itemPrice = driver.findElement(By.id("our_price_display")).getText();
        System.out.println(itemPrice);
        browser.clickAddToCartButton(1);
        browser.clickProceedToCheckout();
        browser.waitForElementVisible(driver,"//*[@id=\"total_product_price_5_19_0\"]");
        String finalPrice = driver.findElement(By.id("total_product_price_5_19_0")).getText();
        System.out.println(finalPrice);
        Assert.assertEquals(itemPrice,finalPrice);
    }


}
