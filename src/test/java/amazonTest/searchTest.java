package amazonTest;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Pageoject.Homepage;
import Pageoject.ResultItem;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigurationProperties;
import utilities.Driver;

public class searchTest {

	WebDriver driver;
	Homepage homepage = new Homepage();
    ResultItem resultItem = new ResultItem();


    @BeforeSuite
    public void goToAmazonSite() {
        WebDriverManager.chromedriver().setup();
        driver = Driver.getDriver();
        homepage.login(ConfigurationProperties.getProperty("EmailUsername"), ConfigurationProperties.getProperty("password"));
        
    }
    
    
    @Test
    public void searchItem() {
    	resultItem.searchItem(ConfigurationProperties.getProperty("itemSearch"));
    }
    
    
    @AfterClass
    public void teardown() {
        driver.quit();
    }
    
}

