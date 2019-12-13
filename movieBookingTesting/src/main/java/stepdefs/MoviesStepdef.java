package stepdefs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import moviebookingpages.BaseClass;

import moviebookingpages.MovieSelectionPage;
import steps.MovieselectionStep;


public class MoviesStepdef {

	WebDriver driver;
	BaseClass bs;
	String selectedMovie;
	
	MovieSelectionPage selectmovie;
	
	MovieselectionStep moviestep;
	Logger logger = Logger.getLogger(MoviesStepdef.class);

	@Given("^user should be in Movie page$")
	public void userShouldBeInMoviePage() {

		moviestep = new MovieselectionStep();

		driver = moviestep.openHomePage();
		moviestep.enterCredentials();
		moviestep.clickNext();
		moviestep.selectLocation();
		moviestep.clickNextOfmoviepage();
		selectmovie = new MovieSelectionPage(driver);
	}

	@When("^user Selct movie \"(.*?)\"$")
	public void userSelctMovie(String moviename) {
		selectedMovie = moviename;
		
		logger.info("Selecting" + moviename + "Theater from list");
		selectmovie.selectMovie(moviename);

	}

	@Then("^user should redirect to Theaterpage page$")
	public void userShouldRedirectToTheaterPage() {
		selectmovie.clickNext();
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains(selectedMovie));
		driver.quit();
	}

	@When("^user clicks on  next button  directly on moviepage$")
	public void userClicksOnNextButtonDirectlyOnMoviepage() {
		logger.info("Clicking nextButton of Movie page directly");
		selectmovie.clickNext();

	}

	@Then("^it should be in movie page$")
	public void itShouldBeInMoviePage() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("111-hyderabad"));
		driver.quit();
	}

}
