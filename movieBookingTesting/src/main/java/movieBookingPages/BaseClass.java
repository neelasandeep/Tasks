package movieBookingPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import utilities.BrowserFactory;

public class BaseClass {
	protected WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriver getDriver(String url) {
		driver = BrowserFactory.startBrowser();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;

	}
}
