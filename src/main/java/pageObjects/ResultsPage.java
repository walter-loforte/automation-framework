package pageObjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	 private WebElement btn_Checkin;
	
	@FindBy(how = How.ID, using = "hotels-check-out-btn") 
	 private WebElement btn_Checkout;
	
	@FindBy(how = How.ID, using = "hotels-check-in") 
	 private WebElement txtbx_Checkin;
	
	@FindBy(how = How.ID, using = "hotels-check-out") 
	 private WebElement txtbx_Checkout;
	
	@FindAll(@FindBy(how = How.CSS, using = "ol.results-list li"))
	 private List<WebElement> hotel_List;
	
	public String query_getText() {
		String text = txtbx_resultSearch.getText();
		return text;
	}
	
	public String checkin_getText() {
		String text = btn_Checkin.getText();
		return text;
	}
	
	public String checkout_getText() {
		String text = btn_Checkout.getText();
		return text;
	}
	
	public String checkin_getValue() {
		String text = txtbx_Checkin.getAttribute("value").toString();
		return text;
	}
	
	public String checkout_getValue() {
		String text = txtbx_Checkout.getAttribute("value").toString();
		return text;
	}
	
	public String checkin_getFormattedValue() {
		String checkInDate = txtbx_Checkin.getAttribute("value").toString();
		DateTimeFormatter oldPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    DateTimeFormatter newPattern = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	    LocalDate datetime = LocalDate.parse(checkInDate, oldPattern);
	    String output = datetime.format(newPattern);
		return output;
	}
	
	public String checkout_getFormattedValue() {
		String checkOutDate = txtbx_Checkout.getAttribute("value").toString();
		DateTimeFormatter oldPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    DateTimeFormatter newPattern = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	    LocalDate datetime = LocalDate.parse(checkOutDate, oldPattern);
	    String output = datetime.format(newPattern);
		return output;
	}
	
	public boolean isListNotEmpty() {
		if (hotel_List.size() > 0) {
			return true;
		} else
			return false;
		
	}
	
	

	
	
	
	
}
