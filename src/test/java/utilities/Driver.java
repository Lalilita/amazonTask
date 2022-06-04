package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	public static WebDriver driver;

	public static WebDriver getDriver() {

		if (driver == null) {

			switch (ConfigurationProperties.getProperty("browser")) {

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();	
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				break;

			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();	
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				break;

			case "safari":
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				driver.manage().window().maximize();	
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				break;
			}

			driver.get(ConfigurationProperties.getProperty("amazonUrl"));
		}

		return driver;
	}

	public static void tearDown() {
		if (driver != null) {
			driver.close();
			driver = null;
		}
	}

}
