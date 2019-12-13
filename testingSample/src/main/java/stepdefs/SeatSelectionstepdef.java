package stepdefs;

import org.openqa.selenium.WebDriver;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import moviebookingpages.MovieSelectionPage;
import moviebookingpages.TheaterSelectionPage;
import steps.SeatSelectionSteps;
import steps.TimeSelectionSteps;
import utilities.ConfigDataprovider;

public class SeatSelectionstepdef {
	SeatSelectionSteps seats;
	TimeSelectionSteps timestep;
	WebDriver driver;
	String selectedTheater;
	MovieSelectionPage selectmovie;
	TheaterSelectionPage selectTheater;
	ConfigDataprovider config;
	SeatSelectionSteps seatstep;

	@Given("^user should seats page$")
	public void userShouldSeatsPage() {
		 seatstep=new SeatSelectionSteps();
		config = new ConfigDataprovider();
		driver=seatstep.openHomePage();
	
	}

	@And("^user login with credentials \"(.*?)\" and password \"(.*?)\"$")
	public void userLoginWithCredentialsAndPassword(String userName, String passWord)  {
		seatstep.enterCredentials(userName, passWord);
		seatstep.clickNext();
	}

	@And("^user enterss location \"(.*?)\"$")
	public void userEntersLocation(String location) {
		seatstep.selectLocation(location);
		seatstep.clickNextOfLocation();
	}

	@And("^user selects movie \"(.*?)\"$")
	public void userSelectsMovie(String movieName)  {
		seatstep.selectMovie(movieName);
		seatstep.clickNextOfMoviePage();
	}

	@And("^user selects theater \"(.*?)\"$")
	public void userSelectsTheater(String theaterName) {
		seatstep.selectTheater(theaterName);
		seatstep.selectNextOftheater();
	}

	@And("^user selects date \"(.*?)\"$")
	public void userSelectsDate(String date)  {
		seatstep.selectDate(date);
		seatstep.selectNextofDatePage();
	}

	@And("^user selects time \"(.*?)\"$")
	public void userSelectsTime(String time)  {
		seatstep.selectTime(time);
		seatstep.clicknextOfTime();
	}

	@When("^user selects seat \"(.*?)\"$")
	public void userSelectsSeat(String seatNo) {
		seatstep.selectSeat(seatNo);
	}

	@Then("^user moves to payment and validates info in ticket$")
	public void userMovesToPaymentAndValidatesInfoInTicket()  {
		seatstep.checkUrl();
	}

	@When("^user clicks on next button directly in seatspage$")
	public void userClicksOnNextButtonDirectlyInSeatspage() {
		seatstep.clickNextSeat();
	}

	@Then("^it should be in seats page$")
	public void itShouldBeInSeatsPage() {
		seatstep.checkSamePageUrl();
	}
	

}
