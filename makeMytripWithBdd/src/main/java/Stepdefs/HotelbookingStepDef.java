package Stepdefs;

import java.util.List;

import com.epam.makeMytriptestcasesPagess.BaseClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class HotelbookingStepDef extends BaseClass {
	
	
	
	List<String> urlString;
	@Given("^User Should be in Hotels page$")
	public void user_Should_be_in_Hotels_page() throws Throwable {
		setupSuite();
		//localSetup();
		open(config.getappUrl());
		
		hotelPage.Hotelspage();
	}

	@Then("^User enters Place and date to book hotel$")
	public void user_enters_Place_and_date_to_book_hotel() throws InterruptedException {
		urlString = excel.getStringData(3);
		List<String> personal = excel.getStringData(4);
	    hotelPage.checkoutHotels(urlString, personal);
	}

	@Then("^clicks on search Button$")
	public void clicks_on_search_Button()  {
	   hotelPage.searchHotels();
	}

	@Then("^user provided with Multiple Filters to apply for hotel$")
	public void user_provided_with_Multiple_Filters_to_apply_for_hotel() throws Throwable {
	  hotelPage.applyFilters();
	}

	@When("^User clicks on specific hotel$")
	public void user_clicks_on_specific_hotel() throws Throwable {
	    hotelPage.selectHotel();
	}

	@Then("^it will shows Book hotel option to click$")
	public void it_will_shows_Book_hotel_option_to_click() throws Throwable {
	   hotelPage.ContinueToBookHotel();
	}

	

	@Then("^it will moves to userdetails page$")
	public void it_will_moves_to_userdetails_page() throws Throwable {
	   hotelPage.fillPersonalData();
	}

}
