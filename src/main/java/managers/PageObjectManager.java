package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.ResultsPage;

public class PageObjectManager {
	
	private WebDriver driver;
	private HomePage homePage;
	private ResultsPage resultsPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage getHomePage(){
		 return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	
	public ResultsPage getResultsPage(){
		 return (resultsPage == null) ? resultsPage = new ResultsPage(driver) : resultsPage;
	}

}
