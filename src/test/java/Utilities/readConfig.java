package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {
	
	Properties properties;
	String path = "C:\\Users\\mayan\\eclipse-workspace\\CucumberFramworkProject\\src\\main\\resource\\Config.properties";

	// Constructor
	public readConfig() {
		try {
			properties = new Properties();

			FileInputStream fis = new FileInputStream(path);
			properties.load(fis); // load file 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 /*public String  getbaseURL() {
	String value = properties.getProperty("baseURL");
	if ( value != null)
		return value;
	else 
		throw new RuntimeException("URL not specified in config file");
 }
 */
 public String  getBrowser() {
	String value = properties.getProperty("browser");
	if ( value != null)
		return value;
	else 
		throw new RuntimeException("Browser not specified in config file");
 }
 

}
