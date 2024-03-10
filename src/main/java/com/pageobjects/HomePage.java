package com.pageobjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Action;
import com.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//img[@title='Flipkart']")
	WebElement flipkattitlelogo;
	
	@FindBy(xpath="//input[@class='Pke_EE']")
	WebElement searchinputfield;
	
	@FindBy(xpath="//button[@class='_2iLD__']")
	WebElement searchbtn;
	
	Action action = new Action();
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// Validates the logo of the Flipkart website
	public void validateLogo() throws InterruptedException {
		try {
			action.isDisplayed(flipkattitlelogo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Action.sleep(3000);
	}
	
	// Enters "Laptop" in the search input field
	public void searchInput() throws InterruptedException {
		action.inputText(searchinputfield, "Laptop");
		Action.sleep(2000);
		System.out.println("riteshpanda");
	} 
	
	// Clicks on the search button
	public void clickOnSearchBtn() {
		try {
			action.clickOn(searchbtn);
			Action.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
