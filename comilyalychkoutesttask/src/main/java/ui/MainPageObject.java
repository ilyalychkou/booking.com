package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {

    protected RemoteWebDriver driver;

    public MainPageObject(){
    }

    public MainPageObject(RemoteWebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement waitForElementPresent(String locator, String error_message, long timeOutInSeconds)
        {
            By by = this.getLocatorByString(locator);

            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.withMessage(error_message + "\n");
            return wait.until(
                    ExpectedConditions.presenceOfElementLocated(by));
        }

    public WebElement waitForElementPresent (String locator, String error_message)
        {
            return waitForElementPresent(locator, error_message,20);
        }

    public WebElement waitForElementAndClick(String locator, String error_message, long timeOutInSeconds)
        {
            WebElement element = waitForElementPresent(locator, error_message, timeOutInSeconds);
            element.click();
            return element;
        }

    public WebElement waitForElementAndDoubleClick(String locator, String error_message, long timeOutInSeconds)
        {
            WebElement element = waitForElementPresent(locator, error_message, timeOutInSeconds);
            element.click();
            element.click();
            return element;
        }

    public WebElement waitForElementAndSendKeys(String locator, String value, String error_message, long timeOutInSeconds)
        {
            WebElement element = waitForElementPresent(locator, error_message, timeOutInSeconds);
            element.sendKeys(value);
            return element;
        }

    public int getAmountOfElements(String locator)
        {
            By by = this.getLocatorByString(locator);
            List elements = driver.findElements(by);
            return elements.size();
        }

    public By getLocatorByString(String locator_with_type)
        {
            String[] exploded_locator = locator_with_type.split(Pattern.quote(":"),2);
            String by_type = exploded_locator[0];
            String locator = exploded_locator[1];

            if(by_type.equals("xpath"))
            {
                return By.xpath(locator);
            } else  if (by_type.equals("id"))
            {
                return By.id(locator);
            } else  if (by_type.equals("css")) // для MOBILE_WEB
            {
                return By.cssSelector(locator); // для MOBILE_WEB
            } else throw new IllegalArgumentException("Cannot get type of locator. Locator: " + locator_with_type);
        }
}

