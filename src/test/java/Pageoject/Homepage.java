package Pageoject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Constants;
import utilities.Driver;

public class Homepage {

	WebDriver driver = Driver.getDriver();

	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='nav-tools']/a[2]")
	public WebElement signinMenu;

	@FindBy(xpath = "//input[@id='ap_email']")
	public WebElement signinEmailInput;

	@FindBy(xpath = "//input[@id='continue']")
	public WebElement continueBtn;

	@FindBy(xpath = "//input[@id='ap_password']")
	public WebElement signinPasswordInput;

	@FindBy(xpath = "//input[@id='signInSubmit']")
	public WebElement signinBtn;

	@FindBy(xpath = "//div[@class='nav-line-1-container']/span")
	public WebElement greeting;

	public void login(String EmailUsername, String password) {
		signinMenu.click();
		signinEmailInput.sendKeys(EmailUsername);
		continueBtn.click();
		signinPasswordInput.sendKeys(password);
		signinBtn.click();

		String actualGreetingText = greeting.getText();
		Assert.assertNotEquals(Constants.greetingBeforeSignIn, actualGreetingText);
	}

}
