package Stepdefs;

import java.io.IOException;
import java.util.List;

import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.epam.Utilities.BrowserFactory;
import com.epam.Utilities.Helper;
import com.epam.makeMytriptestcasesPagess.BaseClass;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlightsSearchDef extends BaseClass {

	List<String> urlString;
	
	@Given("^User in Home page \"(.*?)\"$")
	public void user_in_Home_page(String arg1) throws Throwable {
		
		setupSuite();
		

		
		if(arg1.equalsIgnoreCase("Home")) {
			open("https://www.makemytrip.com/");
		}else {
		
			open("https://www.makemytrip.com/daily-deals/");
		}
	}

	@Then("^User enter trip details \"(.*?)\"$")
	public void user_enter_trip_details(String arg1) throws Throwable {
		if(arg1.equalsIgnoreCase("Home")) {
			urlString = excel.getStringData(1);
			flightsPage.checkFlights(urlString);
		}else {
		urlString = excel.getStringData(5);
		checkDeals.SearchInDeals(urlString);
		}
	}

	@Then("^User clicks on serach Flights \"(.*?)\"$")
	public void user_clicks_on_serach_Flights(String arg1) throws Throwable {
		if(arg1.equalsIgnoreCase("Home")) {
			flightsPage.search();
		}else {
		checkDeals.dealsSearch();
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
		filter.reviewDetails(driver);
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
