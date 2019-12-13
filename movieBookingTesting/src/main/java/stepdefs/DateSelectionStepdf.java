package stepdefs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import moviebookingpages.BaseClass;
import moviebookingpages.DateSelectionPage;
import moviebookingpages.MovieLocationsPage;
import moviebookingpages.MovieSelectionPage;
import steps.DateSelectionStep;
import utilities.ConfigDataprovider;

public class DateSelectionStepdf {
	WebDriver driver;
	BaseClass bs;
	String selectedTheater;
	MovieLocationsPage selectlocation;
	MovieSelectionPage selectmovie;
	DateSelectionStep datestep;
	DateSelectionPage selectDate;
	ConfigDataprovider config;
	Logger logger = Logger.getLogger(DateSelectionStepdf.class);

	@Given("^user should be in DateSelection page$")
	public void userShouldBeInDateSelectionPage() {

		config = new ConfigDataprovider();
		 datestep = new DateSelectionStep();
		driver = datestep.openHomePage();
		datestep.enterCredentials();
		datestep.clickNext();
		datestep.selectLocation();
		datestep.clickNextOfLocation();
		datestep.selectMovie();
		datestep.clickNextOfMoviePage();
		datestep.selectTheater();
		datestep.selectNextOftheater();

		selectDate = new DateSelectionPage(driver);
	}

	@When("^user select date from Options$")
	public void userSelectDateFromOptions() {
		selectDate.selectDate();
	}

	@Then("^it should Display Show timings of that Date$")
	public void itShouldDisplayShowTimingsOfThatDate() {
		logger.info("timings");

	}
}
