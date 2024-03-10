package com.pageobjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Action;
import com.qa.base.TestBase;

public class SearcgProductResult extends TestBase {

    // WebElement to verify the product
    @FindBy(xpath = "//div[@class='_4rR01T'][1]")
    static
    WebElement verifyproduct;

    // WebElement to click on add to cart button
//    @FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")
//    WebElement clickonaddtocard;
    @FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")
    WebElement clickonaddtocard;


    // Constructor to initialize PageFactory
    public SearcgProductResult() {
        PageFactory.initElements(driver, this);
    }

    // Method to navigate to the product page
    public static void productpage() throws InterruptedException {
        try {
            Action action = new Action();
            action.clickOn(verifyproduct);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to verify the product
    public void verifyProduct() {
        try {
            Action action = new Action();
            action.isDisplayed(verifyproduct);
            action.sleep(2000);
            action.highlightElement(verifyproduct);
            action.sleep(1000);
            assertTrue(driver.getTitle().contains("Laptop- Buy Products Online at Best Price in India - All Categories | Flipkart.com"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to click on add to cart button
    public void clickOnAddtoCard() {
        Action action = new Action();
        action.clickOn(clickonaddtocard);
    }

}
