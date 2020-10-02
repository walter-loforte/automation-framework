package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
	     PageFactory.initElements(driver, this);
	 }
	
	@FindBy(how = How.ID, using = "hotel-destination-hp-hotel") 
	 private WebElement txtbx_Search;
	
	@FindBy(how = How.ID, using = "hotel-checkin-hp-hotel") 
	 private WebElement txtbx_Checkin;
	
	@FindBy(how = How.ID, using = "hotel-checkout-hp-hotel") 
	 private WebElement txtbx_Checkout;
	
	public void completeForm (String query, String checkin, String checkout) {
		txtbx_Checkin.sendKeys(checkin);
		txtbx_Checkout.sendKeys(checkout);
		txtbx_Search.sendKeys(query, Keys.ENTER);
	}

}
