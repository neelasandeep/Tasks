package com.epam.Utilities;

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
	static DesiredCapabilities caps = new DesiredCapabilities();

	public static WebDriver startApplication(WebDriver driver, String browserName) throws MalformedURLException {
		switch (browserName) {
		case "Firefox":

			caps.setBrowserName("Firefox");

			caps.setVersion("52.0");

			caps.setPlatform(Platform.WINDOWS);

			driver = new RemoteWebDriver(new URL(URL), caps);
			break;
		case "Safari":

			caps.setBrowserName("Safari");

			caps.setVersion("12.0");

			caps.setPlatform(Platform.MAC);

			driver = new RemoteWebDriver(new URL(URL), caps);
			break;
		case "Chrome":
		

			caps.setBrowserName("Chrome");

			caps.setVersion("57.0");

			caps.setPlatform(Platform.WINDOWS);

			driver = new RemoteWebDriver(new URL(URL), caps);
			break;

		}

		return driver;
	}
public static WebDriver startBrowser()  {
        
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		return driver;
	}
    

//	public static WebDriver startBrowser() throws MalformedURLException {
//
//		caps = new DesiredCapabilities();
//		//caps.setCapability("browser", "Safari");
////		caps.setCapability("browser_version", "12.0");
////		caps.setCapability("os", "OS X");
////		caps.setCapability("os_version", "Mojave");
////		caps.setCapability("resolution", "1024x768");
////		caps.setCapability("name", "Bstack-[Java] Sample Test");
//		caps.setBrowserName("Chrome");
//		
//	caps.setVersion("57.0");
//		//
//			caps.setPlatform(Platform.WINDOWS);
//		//
//
//		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
//		// WebDriver driver=new ChromeDriver();
//		return driver;
//	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

}
