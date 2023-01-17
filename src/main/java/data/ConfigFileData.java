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
	
	public String getName(){
		String name = properties.getProperty("name");
		if(name!= null) return name;
		else throw new RuntimeException("name not specified in the Configuration.properties file.");
	}

	public String getPassword(){
		String password = properties.getProperty("password");
		if(password!= null) return password;
		else throw new RuntimeException("password not specified in the Configuration.properties file.");
	}


}
