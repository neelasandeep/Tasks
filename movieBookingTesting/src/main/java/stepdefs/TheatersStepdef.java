package stepdefs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import moviebookingpages.TheaterSelectionPage;
import steps.TheaterStep;
import utilities.ConfigDataprovider;

public class TheatersStepdef {

	WebDriver driver;
	String selectedTheater;

	TheaterSelectionPage selectTheater;
	ConfigDataprovider config;
	Logger logger = Logger.getLogger(TheatersStepdef.class);

	@Given("^user should be in Theater page$")
	public void userShouldBeInTheaterPage() {
		TheaterStep theaterstep = new TheaterStep();
		config = new ConfigDataprovider();
		driver = theaterstep.openHomePage();
		theaterstep.enterCredentials();
		theaterstep.clickNext();
		theaterstep.selectLocation();
		theaterstep.clickNextOfLocation();
		theaterstep.selectMovie();
		theaterstep.clickNextOfMoviePage();
		selectTheater = new TheaterSelectionPage(driver);
	}

	@When("^user Selct Theater \"(.*?)\"$")
	public void userSelctsTheater(String theaterName) {
		selectedTheater = theaterName;
		logger.info("Selecting" + theaterName + "Theater from list");
		selectTheater.selectTheater(theaterName);

	}

	@Then("^user should redirect to DateSelection page$")
	public void userShouldRedirectToDateSelectionPage() {
		selectTheater.clickNext();
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains(config.getDataFromConfig("theatername")));
		driver.quit();
	}

	@When("^user clicks on  next button  directly on theaterPage$")
	public void userClicksOnNextButtonDirectlyOnTheaterPage() {
		logger.info("Clicking nextButton of Theaters page directly");
		selectTheater.clickNext();
	}

	@Then("^it should be in theater page$")
	public void itShouldBeInTheaterPage() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("23456-baahubali"));
		driver.quit();
	}

}
