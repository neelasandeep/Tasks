package utilities;

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

	private BrowserFactory() {
	}

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

			
			break;
		default:

			
			break;

		}

		return driver;
	}
  
	public WebDriver callChromeBrowser() throws MalformedURLException {
		caps.setBrowserName("Chrome");

		caps.setVersion("55.0");

		caps.setPlatform(Platform.WINDOWS);

		return new RemoteWebDriver(new URL(URL), caps);
	}
	public static WebDriver startBrowser() {

		System.setProperty("webdriver.chrome.driver", "src/main/java/drivers/chromedriver.exe");

		return new ChromeDriver();
		 
	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

}
