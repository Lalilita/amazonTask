package Pageoject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigurationProperties;
import utilities.Driver;

public class ResultItem {
	
	   WebDriver driver = Driver.getDriver();

	    public ResultItem() {
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	    public WebElement searchInput;
	    
	    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
	    public WebElement goSearchBtn;
	    	    
	    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
	    public WebElement resultText;
	    
	   
	    
	    public void searchItem(String item) {
	    	searchInput.sendKeys(item);
	    	goSearchBtn.click();
	    	String resultItem = resultText.getText();
	    	String expectedResultItem = "\"" +ConfigurationProperties.getProperty("itemSearch") +"\"";
	    	Assert.assertEquals(expectedResultItem, resultItem);
	    	System.out.println("Search item \"" + item + "\" is successfully");   	
	    }
}
