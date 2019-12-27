package stepdefs;


import com.epam.makemytriptestcasespagess.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApplyFilters extends BaseClass {
	
	
	@Given("^user should be in Flights page \"(.*?)\"$")
	public void userShouldBeInFlightsPage(String arg1) {
		setupSuite();
		try {
			if(arg1.equalsIgnoreCase("Home")) {
				homeFlights();
		     	
			}else {
				dealsPageFlights();
			}
		} catch (Exception e) {
			
			logger.info("price range error");
		}
		
	   
	}

	@When("^User adjust the price Range He wants$")
	public void userAdjustThePriceRangeHeWants() {
		urlString = excel.getStringData(2);
		try {
			filter.applyFilters(urlString);
		} catch (Exception e) {
			
			logger.info("price range error");
		}
	}

	@Then("^User clicks On Specific Flight based on His price Range$")
	public void userClicksOnSpecificFlightBasedOnHisPriceSRange()  {
		filter.selectFlight(2);
	}

}
