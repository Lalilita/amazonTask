package amazonTest;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Pageoject.Homepage;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigurationProperties;
import utilities.Driver;

public class LoginTest {

	WebDriver driver;
	Homepage homepage = new Homepage();

	@BeforeSuite
	public void goToAmazonSite() {
		WebDriverManager.chromedriver().setup();
		driver = Driver.getDriver();
	}

	@Test
	public void loginToHomepage() {
		homepage.login(ConfigurationProperties.getProperty("EmailUsername"),
				ConfigurationProperties.getProperty("password"));

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
