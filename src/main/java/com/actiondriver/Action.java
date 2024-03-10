package com.actiondriver;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class Action extends TestBase {

    // Scrolls the specified WebElement into view
    public void scrollIntoView(final WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Checks if the WebElement is displayed
    public boolean isDisplayed(final WebElement element) {
        return element.isDisplayed();
    }

    // Highlights the specified WebElement temporarily
    public static void highlightElement(final WebElement element) {
        final JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    // Highlights the specified WebElement permanently
    public static JavascriptExecutor highlightElementPermanently(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: #cdcdcd; border: 1px solid red;');", element);
        return js;
    }

    // Highlights the specified WebElement with a different style
    public static void highlighterMethod(final WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 3px solid blue;');", element);
    }

    // Clicks on the specified WebElement
    public void clickOn(WebElement element) {
        try {
            if (isDisplayed(element)) {
                highlightElement(element);
                element.click();
            } else {
                System.out.println("The field is not visible");
            }
            sleep(3000);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    // Pauses the execution for the specified duration
    public static void sleep(final long millis) throws InterruptedException {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException e) {
        }
    }

    // Performs a click action using Actions class on the specified WebElement
    public void actionClickMethod(final WebElement element) {
        Actions act = new Actions(driver);
        act.moveToElement(element).click().build().perform();
    }

    // Performs a click action using JavaScript on the specified WebElement
    public void jsClick(final WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].click();", element);
    }

    // Enters text into the specified WebElement using JavaScript
    public void jsInputMethod(WebElement element, String texttoInput) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1]", element, texttoInput);
        element.sendKeys(Keys.TAB);
        element.sendKeys(Keys.SHIFT, Keys.TAB);
        element.sendKeys(Keys.ENTER);
    }

    // Enters text into the specified WebElement
    public void inputText(WebElement webElement, String texttoInput)
            throws InterruptedException {
        try {
            if (isDisplayed(webElement)) {
                System.out.println("Ritesh1");
                sleep(3000);
                highlightElement(webElement);
                sleep(2000);
                webElement.sendKeys(texttoInput);
                sleep(3000);
                System.out.println("riteshpanda1");

            } else {
                System.out.println("The inputfield is not visible");
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    // Waits for the visibility of the WebElement
    protected static void waitForElementVisibility(final WebElement element, final Duration timeoutInSeconds) {
        final WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Waits for the WebElement to be clickable
    protected static void Clickability(final WebElement element, final Duration timeoutInSeconds) {
        final WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Sets the implicit wait time for the driver
    public static void implicityMethod(WebElement element, Duration timeoutInSeconds) {
        driver.manage().timeouts().implicitlyWait(timeoutInSeconds);
    }

    // Sets the page load timeout for the driver
    public static void pageLoadTime(WebElement element, Duration timeoutInSeconds) {
        driver.manage().timeouts().pageLoadTimeout(timeoutInSeconds);
    }

}
