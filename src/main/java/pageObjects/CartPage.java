package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartPage {


    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindAll(@FindBy(how = How.CSS, using = ".inventory_item_name"))
    private List<WebElement> selectedProducts_List;

    public void printProducts(){
        for (WebElement webElement : selectedProducts_List) {
            String name = webElement.getText();
            System.out.println(name);
        }
    }

    public boolean containsProduct(String product) {
        ArrayList<String> products = new ArrayList<String>();
        for (WebElement webElement : selectedProducts_List) {
            String name = webElement.getText();
            products.add(name);
        }
        if (products.contains(product)){
            return true;
        } else{
            return false;
        }
    }
}
