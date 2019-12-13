package stepdefs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import moviebookingpages.BaseClass;

import moviebookingpages.TimeSelection;
import steps.DateSelectionStep;
import steps.LocationStep;
import steps.MovieselectionStep;
import steps.TheaterStep;
import steps.TimeSelectionSteps;
import utilities.ConfigDataprovider;

public class LocationStepDef {

	WebDriver driver;
	BaseClass bs;
	String selectedLocation;
	
	LocationStep locationStep;
	ConfigDataprovider config;
	String selectedMovie;
	String selectedTheater;
	
	
	
	TimeSelection selectTimeAndSeats;
	MovieselectionStep moviestep;
	TheaterStep theaterStep;
	DateSelectionStep dateStep;
	TimeSelectionSteps timeStep;
	Logger logger = Logger.getLogger(LocationStepDef.class);
	
	@Given("^user should be in Location page$")
	public void userShouldBeInLocationPage() {

		locationStep = new LocationStep();
		driver = locationStep.openHomePage();
		config = new ConfigDataprovider();
		 moviestep=new MovieselectionStep(driver);
		 theaterStep= new TheaterStep(driver);
		 dateStep=new DateSelectionStep(driver);
		
		timeStep= new TimeSelectionSteps(driver);
	}

	@When("^user login with credentials \"(.*?)\" and password \"(.*?)\" in HomePage$")
	public void userLoginWithCredentialsAndPasswordInHomePage(String userName, String password) {
		locationStep.enterCredentials(userName, password);
		locationStep.clickNext();
	}

	@When("^user Selct Location \"(.*?)\"$")
	public void userSelctsLocation(String location) {
		locationStep.selectLocation(location);
	}

	@Then("^user should redirect to Movies page$")
	public void userShouldRedirectToMoviespPage() {
		locationStep.redirectToMoviePage();
		
	}
	@When("^user clicks on next button directly$")
	public void userClicksOnNextButtonDirectly() {
		locationStep.clickNextButton();

	}

	@Then("^it should be in same page$")
	public void itShouldBeInSamePage() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("8080"));
		driver.quit();
	}
	@When("^user Selct movie \"(.*?)\"$")
	public void userSelctMovie(String moviename) {
		
		selectedMovie = moviename;
		moviestep.selectMovie(moviename);
		

	}

	@Then("^user should redirect to Theaterpage page$")
	public void userShouldRedirectToTheaterPage() {
		moviestep.clickNextOfmoviepage();
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains(selectedMovie));
		
	}

	@When("^user clicks on  next button  directly on moviepage$")
	public void userClicksOnNextButtonDirectlyOnMoviepage() {
		logger.info("Clicking nextButton of Movie page directly");
		moviestep.clickNextOfmoviepage();

	}

	@Then("^it should be in movie page$")
	public void itShouldBeInMoviePage() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("111-hyderabad"));
		
	}
	@When("^user Selct Theater \"(.*?)\"$")
	public void userSelctsTheater(String theaterName) {
		selectedTheater = theaterName;
		theaterStep.selectTheater(theaterName);

	}

	@Then("^user should redirect to DateSelection page$")
	public void userShouldRedirectToDateSelectionPage() {
		theaterStep.clickNextoftheaterpage();
		String url = driver.getCurrentUrl();
		logger.info(url);
		Assert.assertTrue(url.contains(config.getDataFromConfig("theatername")));
		
	}

	@When("^user clicks on  next button  directly on theaterPage$")
	public void userClicksOnNextButtonDirectlyOnTheaterPage() {
		logger.info("Clicking nextButton of Theaters page directly");
		theaterStep.clickNextoftheaterpage();
	}

	@Then("^it should be in theater page$")
	public void itShouldBeInTheaterPage() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("89564-antman"));
		
	}
	@When("^user select date from Options$")
	public void userSelectDateFromOptions() {
		dateStep.selectDatefromOptions();
	}

	@Then("^it should Display Show timings of that Date$")
	public void itShouldDisplayShowTimingsOfThatDate() {
		logger.info("timings");
		

	}
	@When("^user clicks next without Selecting date$")
	public void userClicksNextWithoutSelectingDate()  {
		dateStep.clickNextButtonOfDatePage();
	}

	@Then("^it should Be in Same page$")
	public void ittShouldBeInSamePage()  {
	   String url=driver.getCurrentUrl();
	   Assert.assertTrue(url.contains("theater"));
	}
	@When("^user select one date from Options$")
	public void userSelectOneDateFromOptions()  {
		dateStep.selectOneDate();
		dateStep.clickNextButtonOfDatePage();
	}
	@When("^user Selct Time$")
	public void userSelctsTime() {
		
		timeStep.selectTime();


	}
	@Then("^user should redirect to seats page$")
	public void userShouldRedirectToSeatsPage() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("date"));
	
	}

	@When("^user clicks on  next button  directly on TimePage$")
	public void userClicksOnNextButtonDirectlyOnTimePage() {
		timeStep.clicknextOfTime();
	}

	@Then("^it should be in Time page$")
	public void itShouldBeInTimePage() {
		
		timeStep.checkPage();
		
	}
	@And("^close the Browser$")
	public void closeTheBrowser()  {
	  driver.quit();
	}
	

}
