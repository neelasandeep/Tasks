package com.epam.utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {
	public static final String USERNAME = "sandeepneela1";
	public static final String AUTOMATE_KEY = "rpL2HhuqqTR5CVqf4Ukx";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public static final String CHROME="Chrome";
	static DesiredCapabilities caps = new DesiredCapabilities();
     WebDriver newDriver;
	public BrowserFactory() {

	}

	public  WebDriver startApplication( String browserName) throws MalformedURLException {
		switch (browserName) {
		case "Firefox":

			caps.setBrowserName("Firefox");

			caps.setVersion("52.0");

			caps.setPlatform(Platform.WINDOWS);

			newDriver = new RemoteWebDriver(new URL(URL), caps);
			break;
		case "Safari":

			caps.setBrowserName("Safari");

			caps.setVersion("12.0");

			caps.setPlatform(Platform.MAC);

			newDriver = new RemoteWebDriver(new URL(URL), caps);
			break;
		case CHROME:

			caps.setBrowserName(CHROME);

			caps.setVersion("55.0");

			caps.setPlatform(Platform.WINDOWS);

			newDriver = new RemoteWebDriver(new URL(URL), caps);
			break;
			default:caps.setBrowserName(CHROME);

			caps.setVersion("55.0");

			caps.setPlatform(Platform.WINDOWS);

			newDriver = new RemoteWebDriver(new URL(URL), caps);
            
		}
		

		return newDriver;
	}

	public static WebDriver startBrowser() {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		return new ChromeDriver();
	}

	

}
