package utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigDataprovider {
	Properties properties;
	Logger logger = Logger.getLogger(ConfigDataprovider.class);

	public ConfigDataprovider() {
		File src = new File("./src/main/resources/configurations/Config.properties");
		try (FileInputStream fis = new FileInputStream(src);) {

			properties = new Properties();
			properties.load(fis);
		} catch (Exception e) {
			logger.warn("Unable to load config File", e);
		}

	}

	

	public String username() {
		return properties.getProperty("username");

	}

	public String password() {
		return properties.getProperty("password");
	}

	public String getdriverManager() {
		return properties.getProperty("drivermanager");
	}
	public String getDriver() {
		return properties.getProperty("driver");
	}
	public String getExcelPath() {
		return properties.getProperty("excelpath");
	}
	public String getLogprop() {
		return properties.getProperty("log4j");
	}
}
