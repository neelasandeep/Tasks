package steps;



import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

import moviebookingpages.BaseClass;
import moviebookingpages.DateSelectionPage;
import moviebookingpages.LoginPage;
import moviebookingpages.MovieLocationsPage;
import moviebookingpages.MovieSelectionPage;
import moviebookingpages.TheaterSelectionPage;
import moviebookingpages.TimeSelection;
import utilities.ConfigDataprovider;

public class TimeSelectionSteps {

	WebDriver driver;
	BaseClass bs;
	String selectedTheater;
	MovieLocationsPage selectlocation;
	MovieSelectionPage selectmovie;
	TheaterSelectionPage selectTheater;
	DateSelectionPage selectDate;
	TimeSelection selectTimeAndSeats;
	ConfigDataprovider config;
	WebElement dateelement;
	String date;
	LoginPage login;
	Logger logger = Logger.getLogger(TimeSelectionSteps.class);
	
	public WebDriver openHomePage() {
		bs=new BaseClass();
		config=new ConfigDataprovider();
		driver=bs.getDriver(config.getmovieURL());
		selectTimeAndSeats= new TimeSelection(driver);
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
  public void selectDate() {
	  selectDate=new DateSelectionPage(driver);
	  selectDate.selectSingleDate();
	  
   }
  public void selectNextofDatePage() {
	  selectDate.clicknextOfDatePage();
 }
	public void selectTime() {
		
		selectTimeAndSeats.selectTime();

	}
	
	public void clicknextOfTime() {
		selectTimeAndSeats.clickNext();
	}
	public void checkPage() {
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("date"));
		 driver.quit();
	}
}
