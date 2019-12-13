package moviebookingpages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/main/java/resources/log4j.properties");
		return driver;

	}
	public boolean waitforDisplayOfElment(WebElement element, WebDriver webDriver) {
		boolean visible= false;
		WebDriverWait wait = new WebDriverWait(webDriver, 7);
		wait.until(ExpectedConditions.visibilityOf(element));
		if(element.isDisplayed())
			visible=true;
		
	
		return visible;
	}
	public boolean waitwithLocator(WebDriver driver,String locator) {
		boolean visible= false;
		WebDriverWait wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))); 
		
		WebElement element = driver.findElement(By.xpath(locator));
		if(element.isDisplayed())
			visible=true;
		
		
		return visible;
	}
}
