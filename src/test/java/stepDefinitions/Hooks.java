package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		Hooks.driver = driver;
	}

	@Before
	public static void setupClass() {
		switch (System.getProperty("browser")) {     
		case "FIREFOX" : 
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		break;
		case "CHROME" : 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 break;
		 case "EXPLORER" : 
			 //TODO
		 break;
        }
		
	}

	@After
	public void teardown(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	        scenario.attach(screenshot, "image/png", "screenshot");
	    }
		if (driver != null) {
			driver.quit();
		}
	}

}
