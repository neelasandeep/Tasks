package steps;

import org.openqa.selenium.WebDriver;

import moviebookingpages.BaseClass;
import moviebookingpages.LoginPage;
import moviebookingpages.MovieLocationsPage;
import utilities.ConfigDataprovider;

public class MovieselectionStep {
	WebDriver driver;
	BaseClass bs;
	String selectedLocation;
	MovieLocationsPage selectlocation;
	ConfigDataprovider config;
	LoginPage login;
	public WebDriver openHomePage() {
		bs=new BaseClass();
		config=new ConfigDataprovider();
		driver=bs.getDriver(config.getmovieURL());
		return driver;
	}
	public void enterCredentials() {
		 login=new LoginPage(driver);
		  login.enterCredentials("shubhi","1234");
	}
	public void clickNext() {
		 login.clickLoginButton();
	}
	public void selectLocation() {
		 selectlocation=new MovieLocationsPage(driver);
		  selectlocation.selectLocation("111-hyderabad");
	}
	public void clickNextOfmoviepage() {
		selectlocation.clickNext();
	}

}
