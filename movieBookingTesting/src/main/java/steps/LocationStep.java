package steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import moviebookingpages.BaseClass;
import moviebookingpages.LoginPage;
import moviebookingpages.MovieLocationsPage;

import utilities.ConfigDataprovider;

public class LocationStep {
	WebDriver driver;
	BaseClass bs;
	String selectedLocation;
	MovieLocationsPage selectlocation;
	
	ConfigDataprovider config;
	Logger logger = Logger.getLogger(LocationStep.class);
	LoginPage login;
	public WebDriver openHomePage() {
		bs=new BaseClass();
		config=new ConfigDataprovider();
		driver=bs.getDriver(config.getmovieURL());
		selectlocation = new MovieLocationsPage(driver);
		return driver;
	}
	public void enterCredentials(String userName,String password) {
		 login=new LoginPage(driver);
		  login.enterCredentials(userName,password);
	}
	public void clickNext() {
		 login.clickLoginButton();
	}
	public void selectLocation(String location) {
		
		selectedLocation = location;
		logger.info("Selecting" + location + "Theater from list");
		
		selectlocation.selectLocation(location);
	}
	public void redirectToMoviePage(){
		selectlocation.clickNext();
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains(selectedLocation));
	}
	public void clickNextButton() {
		logger.info("Clicking nextButton of Location page directly");
		selectlocation.clickNext();
	}

}
