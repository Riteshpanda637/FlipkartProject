package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Action;
import com.qa.base.TestBase;

public class AddtoCardPage extends TestBase {
    
    @FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
    WebElement clickongotocardbtn;
    
    /**
     * Constructor to initialize the elements of the AddtoCardPage class
     */
    public AddtoCardPage() {
        PageFactory.initElements(driver, this);
    }
    
    /**
     * Method to click on the "Go to Cart" button
     * @throws InterruptedException
     */
    public void clickOnGtoCardbtn() throws InterruptedException {
        try {
            Action action = new Action();
            //action.scrollIntoView(clickongotocardbtn);
            action.highlightElement(clickongotocardbtn);
            Action.sleep(3000);
            action.jsClick(clickongotocardbtn);
            //action.clickOn(clickongotocardbtn);
            //assertTrue(driver.getTitle().contains("Shopping Cart | Flipkart.com"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Action.sleep(3000);
    }
}
