package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;

public class PageObjectManager {
	
	private WebDriver driver;
	private HomePage homePage;
	private ProductPage productPage;
	private CartPage cartPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage getHomePage(){
		 return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	
	public ProductPage getProductPage(){
		 return (productPage == null) ? productPage = new ProductPage(driver) : productPage;
	}

	public CartPage getCartPage(){
		return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;
	}

}
