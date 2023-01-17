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

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;

public class TestSteps {
	HomePage homePage;
	ProductPage productPage;
	CartPage cartPage;
	PageObjectManager pageObjectManager;
	ConfigFileData configFileData;
	protected WebDriver driver = Hooks.getDriver();
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		configFileData = new ConfigFileData();
		driver.get(configFileData.getUrl());
	}

	@When("User enters name and password")
	public void user_enters_name_and_password() {
		pageObjectManager = new PageObjectManager(driver);
		homePage = pageObjectManager.getHomePage();
		homePage.login(configFileData.getName(), configFileData.getPassword());
	}
	@Then("User is redirected to inventory page")
	public void user_is_redirected_to_inventory_page() {
		productPage = pageObjectManager.getProductPage();
		assertEquals(productPage.title_getText(), "PRODUCTS");
	}

	@Given("User is on Product Page")
	public void user_is_on_product_page() {
		configFileData = new ConfigFileData();
		driver.get(configFileData.getUrl());
		pageObjectManager = new PageObjectManager(driver);
		homePage = pageObjectManager.getHomePage();
		homePage.login(configFileData.getName(), configFileData.getPassword());
	}
	@When("User click on add to cart on a certain product")
	public void user_click_on_add_to_cart_on_a_certain_product() {
		productPage = pageObjectManager.getProductPage();
		productPage.addProduct();
	}
	@When("User goes to shopping cart")
	public void user_goes_to_shopping_cart() {
		productPage.clickCart();
	}
	@Then("Selected product is on the cart")
	public void selected_product_is_on_the_cart() {
		cartPage = pageObjectManager.getCartPage();
		cartPage.printProducts();
		assertTrue(cartPage.containsProduct("Sauce Labs Backpack"));
	}

}
