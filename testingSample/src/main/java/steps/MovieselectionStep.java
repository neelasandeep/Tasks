package steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import moviebookingpages.BaseClass;
import moviebookingpages.LoginPage;
import moviebookingpages.MovieLocationsPage;
import moviebookingpages.MovieSelectionPage;

import utilities.ConfigDataprovider;

public class MovieselectionStep {
	WebDriver driver;
	BaseClass bs;
	String selectedLocation;
	MovieLocationsPage selectlocation;
	ConfigDataprovider config;
	LoginPage login;
	MovieSelectionPage selectmovie;
	Logger logger = Logger.getLogger(MovieselectionStep.class);
	public MovieselectionStep(WebDriver driver1) {
		driver=driver1;
		selectmovie = new MovieSelectionPage(driver);
	}
	public void selectMovie(String moviename) {
		logger.info("Selecting" + moviename + "Movie from list");
		selectmovie.selectMovie(moviename);
	}
	public void clickNextOfmoviepage() {
		selectmovie.clickNext();
	}

}
