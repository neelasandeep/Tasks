package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;




public class BrowserFactory {
	private BrowserFactory() {
		
	}
	public static final String USERNAME = "sandeepneela1";
	public static final String AUTOMATE_KEY = "rpL2HhuqqTR5CVqf4Ukx";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	static DesiredCapabilities caps = new DesiredCapabilities();

	
	public static WebDriver startBrowser() {

		System.setProperty("webdriver.chrome.driver", "src/main/java/drivers/chromedriver.exe");

		return new ChromeDriver();
		 
	}

	

}
