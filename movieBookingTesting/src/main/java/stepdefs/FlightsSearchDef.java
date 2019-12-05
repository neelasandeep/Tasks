package stepdefs;


import java.util.List;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import movieBookingPages.BaseClass;
import movieBookingPages.FlightsFilterPage;
import movieBookingPages.MakeMytripFlightsPage;
import utilities.ExcelDataProvider;

public class FlightsSearchDef  {

	List<String> urlString;
	WebDriver homedriver;
	public  MakeMytripFlightsPage flightsPage;
	public  FlightsFilterPage filter;
	  public ExcelDataProvider excel;
	@Given("^User in Home page \"(.*?)\"$")
	public void user_in_Home_page(String arg1) throws Throwable {
		
		BaseClass bs=new BaseClass();
		
		

		
		if(arg1.equalsIgnoreCase("Home")) {
			homedriver=bs.getDriver("https://www.makemytrip.com/");
			flightsPage = new MakeMytripFlightsPage(homedriver);
			 filter=new FlightsFilterPage(homedriver);
			 excel = new ExcelDataProvider();
		}else {
		
			bs.getDriver("https://www.makemytrip.com/daily-deals/");
		}
	}

	@Then("^User enter trip details \"(.*?)\"$")
	public void user_enter_trip_details(String arg1) throws Throwable {
		if(arg1.equalsIgnoreCase("Home")) {
			urlString = excel.getStringData(1);
			flightsPage.checkFlights(urlString);
		}else {
		urlString = excel.getStringData(5);
		//checkDeals.SearchInDeals(urlString);
		}
	}

	@Then("^User clicks on serach Flights \"(.*?)\"$")
	public void user_clicks_on_serach_Flights(String arg1) throws Throwable {
		if(arg1.equalsIgnoreCase("Home")) {
			flightsPage.search();
		}else {
		//checkDeals.dealsSearch();
		}
	}

	@Then("^user can Select The Multiple-Filters and It will Apllies to the Flights$")
	public void user_can_Select_The_Multiple_Filters_and_It_will_Apllies_to_the_Flights() throws Throwable {
		urlString = excel.getStringData(2);

		filter.applyFilters(urlString);
	}

	@When("^User Click on specific Flight To Continue$")
	public void user_Click_on_specific_Flight_To_Continue() throws Throwable {
		filter.selectFlight(2);
	}

	@Then("^user will be in review page Tocheck Flight details$")
	public void user_will_be_in_review_page_Tocheck_Flight_details() throws Throwable {
		filter.reviewDetails(homedriver);
		filter.checkProgressBar();
	}

	@Then("^user accepts T&C and proceeds to furthur process and User clicks Continue$")
	public void user_accepts_T_C_and_proceeds_to_furthur_process_and_User_clicks_Continue() throws Throwable {
		filter.acceptTermsAndConditions();
	}

	@Then("^user fill his/her personal info for ticket$")
	public void user_fill_his_her_personal_info_for_ticket() throws Throwable {
		filter.fillUserDetails();
		
	}
	
}
