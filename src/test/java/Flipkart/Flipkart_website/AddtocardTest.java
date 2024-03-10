package Flipkart.Flipkart_website;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actiondriver.Action;
import com.pageobjects.AddtoCardPage;
import com.pageobjects.HomePage;
import com.pageobjects.SearcgProductResult;
import com.qa.base.TestBase;

public class AddtocardTest extends TestBase {
    
    HomePage hp;
    Action ac;
    SearcgProductResult spr;
    AddtoCardPage acp;
    
    public AddtocardTest() {
        super();
    }
    
    // Method to initialize the browser and page objects before each test method
    @BeforeMethod
    public void launchApp() {
        initializationBrowser();
        hp = new HomePage(); // Initialize HomePage object
        spr = new SearcgProductResult(); // Initialize SearchProductResult object
        acp = new AddtoCardPage(); // Initialize AddtoCardPage object
    }
    
    // Method to quit the browser after each test method
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    
    // Test to verify the logo of the website
    @Test
    public void verifyLogo() throws InterruptedException {
        assertTrue(driver.getTitle().contains("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"));
    }
    
    // Test to add a product to the cart
    @Test
    public void addedcart() throws InterruptedException {
        Action.sleep(4000);
        hp.searchInput(); // Invoke serachInput() method on initialized HomePage object
        hp.clickOnSearchBtn(); // Click on the search button
        spr.productpage(); // Navigate to the product page
        Action.sleep(3000);
        System.out.println(driver.getTitle());
        assertTrue(driver.getTitle().contains("Laptop- Buy Products Online at Best Price in India - All Categories | Flipkart.com"));
        Action.sleep(3000);
        spr.clickOnAddtoCard(); // Click on the "Add to Cart" button
        Action.sleep(3000);
    }
}
