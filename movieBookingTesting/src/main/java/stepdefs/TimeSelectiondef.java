package stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import steps.TimeSelectionSteps;
import utilities.ConfigDataprovider;

public class TimeSelectiondef {
	TimeSelectionSteps timestep;
	WebDriver driver;

	ConfigDataprovider config;

	@Given("^user should be in Time page$")
	public void userShouldBeInTimePage() {
		config = new ConfigDataprovider();
		timestep = new TimeSelectionSteps();
		driver = timestep.openHomePage();
		timestep.enterCredentials();
		timestep.clickNext();
		timestep.selectLocation();
		timestep.clickNextOfLocation();
		timestep.selectMovie();
		timestep.clickNextOfMoviePage();
		timestep.selectTheater();
		timestep.selectNextOftheater();
		timestep.selectDate();
		timestep.selectNextofDatePage();

	}

	@When("^user Selct Time$")
	public void userSelctsTime() {
		timestep.selectTime();

	}

	@Then("^user should redirect to seats page$")
	public void userShouldRedirectToSeatsPage() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("date"));
		driver.quit();
	}

	@When("^user clicks on  next button  directly on TimePage$")
	public void userClicksOnNextButtonDirectlyOnTimePage() {
		timestep.clicknextOfTime();
	}

	@Then("^it should be in Time page$")
	public void itShouldBeInTimePage() {
		timestep.checkPage();
		driver.quit();
	}

}
