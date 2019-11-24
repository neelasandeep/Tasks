package com.epam.Utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigDataprovider {
	Properties properties;
	Logger logger = Logger.getLogger(ConfigDataprovider.class);

	public ConfigDataprovider() {
		File src = new File("./configurations/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			properties = new Properties();
			properties.load(fis);
		} catch (Exception e) {
			logger.warn("Unable to load config File", e);
		}

	}

	public String getDataFromConfig(String key) {
		return properties.getProperty(key);
	}

	public String getBrowser() {

		return properties.getProperty("Browser");
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
}
