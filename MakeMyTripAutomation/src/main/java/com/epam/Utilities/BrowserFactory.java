package com.epam.Utilities;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browserName, String url) {
		switch (browserName) {
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		case "Chrome":
			driver = chromeBrowser();
			break;
		default:
			driver = chromeBrowser();
			break;
		}
       driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	private static WebDriver chromeBrowser() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//		Map<String,Object> prefs=new HashMap<String,Object>();
//		prefs.put("profile.default_content_setting_values.notifications", 2);
	ChromeOptions options=new ChromeOptions();
			
	
//	options.merge(capabilities);
		options.addArguments("--disable-popup-blocking");
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
 		
		driver = new ChromeDriver(options);
		return driver;
	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

}
