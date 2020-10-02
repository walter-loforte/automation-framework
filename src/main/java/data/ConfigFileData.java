package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileData {
	
	private Properties properties;
	private final String propertyFilePath= "config//Configuration.properties";
	
	public ConfigFileData(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
		try {
			properties.load(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		} 
	 }
	
	public String getUrl(){
		String url = properties.getProperty("url");
		if(url!= null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file."); 
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
	}
	
	public String getSearchQuery(){
		String searchQuery = properties.getProperty("searchQuery");
		if(searchQuery!= null) return searchQuery;
		else throw new RuntimeException("searchQuery not specified in the Configuration.properties file."); 
	}
	
	public String getCheckin(){
		String checkin = properties.getProperty("checkin");
		if(checkin!= null) return checkin;
		else throw new RuntimeException("checkin not specified in the Configuration.properties file."); 
	}
	
	public String getCheckout(){
		String checkout = properties.getProperty("checkout");
		if(checkout!= null) return checkout;
		else throw new RuntimeException("checkout not specified in the Configuration.properties file."); 
	}
	
	public String getBrowser(){
		String browser = properties.getProperty("browser");
		if(browser!= null) return browser;
		else throw new RuntimeException("browser not specified in the Configuration.properties file."); 
	}
	
	public String getReportConfigPath(){
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file.");		
	}


}
