package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import data.ConfigFileData;
import managers.PageObjectManager;

import pageObjects.HomePage;
import pageObjects.ResultsPage;

public class TestSteps {
	HomePage homePage;
	ResultsPage resultsPage;
	PageObjectManager pageObjectManager;
	ConfigFileData configFileData;
	protected WebDriver driver = Hooks.getDriver();
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		configFileData = new ConfigFileData();
		driver.get(configFileData.getUrl());
	}

	@When("^User enters destination and dates$")
	public void user_enters_destination_and_dates() throws Throwable {
		pageObjectManager = new PageObjectManager(driver);
		homePage = pageObjectManager.getHomePage();
		homePage.completeForm(configFileData.getSearchQuery(), configFileData.getCheckin(), configFileData.getCheckout());
	}

	@Then("^User is redirected to results page for that destination and dates$")
	public void user_is_redirected_to_results_page_for_that_destination_and_dates() throws Throwable {
		resultsPage = pageObjectManager.getResultsPage();
		assertEquals(resultsPage.query_getText(), configFileData.getSearchQuery());
		assertEquals(resultsPage.checkin_getFormattedValue(), configFileData.getCheckin());
		assertEquals(resultsPage.checkout_getFormattedValue(), configFileData.getCheckout());
	}
	
	@Then("User can see at least one result in the list of Hotels")
	public void user_can_see_at_least_one_result_in_the_list_of_hotels() {
		resultsPage = pageObjectManager.getResultsPage();
		assertTrue(resultsPage.isListNotEmpty());
	}
	
	@Then("User cannot see any result")
	public void user_cannot_see_any_result() {
		resultsPage = pageObjectManager.getResultsPage();
		assertFalse(resultsPage.isListNotEmpty());
	}

}
