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


	@FindBy(how = How.ID, using = "user-name")
	private WebElement txtbx_Name;

	@FindBy(how = How.ID, using = "password")
	private WebElement txtbx_Pass;

	@FindBy(how = How.ID, using = "login-button")
	private WebElement btn_Login;


	public void login(String name, String pass) {
		txtbx_Name.sendKeys(name);
		txtbx_Pass.sendKeys(pass);
		btn_Login.click();
	}

}
