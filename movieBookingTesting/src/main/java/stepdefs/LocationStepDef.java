package stepdefs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import moviebookingpages.BaseClass;
import moviebookingpages.MovieLocationsPage;
import steps.LocationStep;
import utilities.ConfigDataprovider;

public class LocationStepDef {

	WebDriver driver;
	BaseClass bs;
	String selectedLocation;
	MovieLocationsPage selectlocation;
	LocationStep locationStep;
	ConfigDataprovider config;
	Logger logger = Logger.getLogger(LocationStepDef.class);

	@Given("^user should be in Location page$")
	public void userShouldBeInLocationPage() {

		locationStep = new LocationStep();
		driver = locationStep.openHomePage();

		

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
		driver.quit();
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

}
