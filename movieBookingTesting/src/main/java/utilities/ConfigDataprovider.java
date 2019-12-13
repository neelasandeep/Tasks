package utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigDataprovider {
	Properties properties;
	Logger logger = Logger.getLogger(ConfigDataprovider.class);

	public ConfigDataprovider() {
		File src = new File("src/main/java/configurations/Config2.properties");
		try (FileInputStream fis = new FileInputStream(src);){
			
			properties = new Properties();
			properties.load(fis);
		} catch (Exception e) {
			logger.warn("Unable to load config File", e);
		}

	}

	public String getDataFromConfig(String key) {
		return properties.getProperty(key);
	}

	
	public String getChrome() {

		return properties.getProperty("chromeBrowser");
	}

	public String getappUrl() {
		return properties.getProperty("appUrl");

	}
	public String getHotelUrl() {
		return properties.getProperty("hotelsUrl");

	}
	
	public String getmovieURL() {
		return properties.getProperty("moviebooking");
	}
	
	public String getLocationURI() {
		return properties.getProperty("getemployee");
	}
	public String getMovieURI() {
		return properties.getProperty("getMovies");
	}
	public String getlocationIdURI() {
		return properties.getProperty("locationId");
	}
	public String getmovieIdURI() {
		return properties.getProperty("movieid");
	}
	public String getbaseURI() {
		return properties.getProperty("moviebookbaseuri");
	}
}
