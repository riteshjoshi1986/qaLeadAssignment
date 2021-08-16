package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSearchButton() {
        driver.findElement(By.name("submit_search")).click();
    }

    public void checkAlertWarningMessages(String alertWarningText, String counterSearchText) {
        WebElement centerColumn = driver.findElement(By.id("center_column"));
        Assert.assertEquals(alertWarningText, centerColumn.findElement(By.className("alert-warning")).getText());
        Assert.assertEquals(counterSearchText, centerColumn.findElement(By.className("heading-counter")).getText());
    }

    public void fillTheSearchField(String text) {
        driver.findElement(By.id("search_query_top")).clear();
        driver.findElement(By.id("search_query_top")).sendKeys(text);
        driver.findElement(By.name("submit_search")).click();
    }

    public void checkSearchMessages(String message) {
        WebElement centerColumn = driver.findElement(By.id("center_column"));
        Assert.assertEquals(message, centerColumn.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText());
    }

    public void checkSearchMessagesForDataProvider(String message) {
        WebElement centerColumn = driver.findElement(By.id("center_column"));
        Assert.assertEquals(message, centerColumn.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span")).getText());
    }

    public void checkIsDisplayedElements(String search) {
        if (search.equals("dress")) {
            WebElement centerColumn = driver.findElement(By.id("center_column"));
            centerColumn.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]")).isDisplayed();
            centerColumn.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]")).isDisplayed();
            centerColumn.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]")).isDisplayed();
            centerColumn.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[4]")).isDisplayed();
            centerColumn.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[5]")).isDisplayed();
            centerColumn.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[6]")).isDisplayed();
            centerColumn.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[7]")).isDisplayed();
        }
    }

    public void clickItem(String search, int index) {
        if (search.equals("dress")) {
            switch (index){
                case 10:
                    WebElement centerColumn10 = driver.findElement(By.id("center_column"));
                    centerColumn10.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]")).click();
                    break;

                case 11:
                    WebElement centerColumn11 = driver.findElement(By.id("center_column"));
                    centerColumn11.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]")).click();
                    break;
            }
        }
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

    }

    public void clickAddToCartButton(int itemNum) {
        WebElement element = driver.findElement(By.name("Submit"));
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",element);

        driver.findElement(By.name("Submit")).click();
    }

    public void clickProceedToCheckout() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.waitForElementVisible(driver,"//*[@id=\"layer_cart\"]//*[@title=\"Proceed to checkout\"]");
        WebElement ele = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]//*[@title=\"Proceed to checkout\"]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", ele);
    }
}
