package stepdefs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import moviebookingpages.BaseClass;
import moviebookingpages.MovieLocationsPage;
import steps.BookingSteps;


public class BookingusseCaseStepdef {
	WebDriver driver;
	BaseClass bs;
	String selectedLocation;
	MovieLocationsPage selectlocation;
	
	 BookingSteps book;
	Logger logger = Logger.getLogger(BookingusseCaseStepdef.class);
	@Given("^user in the home page$")
	public void userInTheHomePage() {
	    book=new BookingSteps();
	   book.openLocationPage();
	}
	@When("^User  Selcts location-> Movie-> Theater->->date->time->seat \"(.*?)\"$")
	public void userSelctsLocationMovieTheaterdateTimeSeat(String location)  {
		book.checkCombinations(location);
	}

	

	@Then("^validates combinations$")
	public void validatesCombinations(){
	   logger.info("validated");
	}
	@And("^close browser$")
	public void closeBrowser()  {
	   driver.quit();
	}


}
