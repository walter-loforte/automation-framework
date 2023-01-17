package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	public ProductPage(WebDriver driver) {
	     PageFactory.initElements(driver, this);
	 }

	@FindBy(how = How.CSS, using =".title")
	private WebElement span_Title;

	@FindBy(how = How.ID, using ="add-to-cart-sauce-labs-backpack")
	private WebElement btn_AddBackpack;

	@FindBy(how = How.ID, using ="add-to-cart-sauce-labs-bike-light")
	private WebElement btn_AddBikeLight;

	@FindBy(how = How.ID, using ="shopping_cart_container")
	private WebElement btn_ShoppingCart;

	
	public String title_getText() {
		String text = span_Title.getText();
		return text;
	}
	public void addProduct(){
		btn_AddBackpack.click();
		btn_AddBikeLight.click();
	}

	public void clickCart(){
		btn_ShoppingCart.click();
	}
	
}
