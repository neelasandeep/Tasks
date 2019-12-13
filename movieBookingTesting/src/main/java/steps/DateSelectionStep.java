package steps;

import org.openqa.selenium.WebDriver;

import moviebookingpages.BaseClass;
import moviebookingpages.LoginPage;
import moviebookingpages.MovieLocationsPage;
import moviebookingpages.MovieSelectionPage;
import moviebookingpages.TheaterSelectionPage;
import utilities.ConfigDataprovider;

public class DateSelectionStep {
	WebDriver driver;
	BaseClass bs;
	String selectedLocation;
	MovieLocationsPage selectlocation;
	ConfigDataprovider config;
	MovieSelectionPage selectmovie;
	TheaterSelectionPage selectTheater;
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
	public void clickNextOfLocation() {
		selectlocation.clickNext();
	}
	public void selectMovie() {
		selectmovie = new MovieSelectionPage(driver);
		selectmovie.selectMovie("23456-baahubali");
	}
	public void clickNextOfMoviePage() {
		selectmovie.clickNext();
	}
   public void selectTheater() {
	   selectTheater = new TheaterSelectionPage(driver);
		selectTheater.selectTheater("2233-mukta cinemas");
   }
   public void selectNextOftheater() {
		selectTheater.clickNext();
   }

}
