package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {
	
	public ResultsPage(WebDriver driver) {
	     PageFactory.initElements(driver, this);
	 }
	
	@FindBy(how = How.CSS, using ="button[data-stid='hotels-destination-dialog-trigger']")
	 private WebElement txtbx_resultSearch;
	
	@FindBy(how = How.ID, using = "hotels-check-in-btn") 
	 private WebElement txtbx_Checkin;
	
	@FindBy(how = How.ID, using = "hotels-check-out-btn") 
	 private WebElement txtbx_Checkout;
	
	@FindBy(how = How.ID, using = "hotels-check-out") 
	 private WebElement txtbx_Checkout2;
	
	@FindAll(@FindBy(how = How.CSS, using = "ol.results-list li"))
	 private List<WebElement> hotel_List;
	
	public String query_getText() {
		String text = txtbx_resultSearch.getText();
		return text;
	}
	
	public String checkin_getText() {
		String text = txtbx_Checkin.getText();
		return text;
	}
	
	public String checkout_getText() {
		String text = txtbx_Checkout.getText();
		return text;
	}
	
	public String checkout_getValue() {
		String text = txtbx_Checkout2.getAttribute("value").toString();
		return text;
	}
	
	public boolean isListNotEmpty() {
		if (hotel_List.size() > 0) {
			return true;
		} else
			return false;
		
	}
	
	

	
	
	
	
}
