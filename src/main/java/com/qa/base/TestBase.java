package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
    
    public static Properties prop;
    public static WebDriver driver;
    public static final int TEST_DATA_SOURCE_AUTOMATED = 0;
    
    // Load configuration from config.properties file
    public void loadConfig() {
        
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir")+ "\\Configuartions\\config.properties");
            prop.load(ip);
            System.out.println("driver:" + driver);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    // Initialize WebDriver based on configuration
    @SuppressWarnings("deprecation") 
    public static void initializationBrowser() {
        // Load configuration
        new TestBase().loadConfig();
        
        String browsername = prop.getProperty("browser");
        
        if (browsername.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            
        } else if (browsername.contains("FF")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxoptions = new FirefoxOptions();
            driver = new FirefoxDriver(firefoxoptions);
        } else if (browsername.contains("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        
        // Maximize window, delete cookies, and navigate to the specified URL
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
    }
}
