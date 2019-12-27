package stepdefs;



import com.epam.makemytriptestcasespagess.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class FlightsReview extends BaseClass {
	
	
	
	@Given("^user should Be in Review Page \"(.*?)\"$")
	public void userShouldBeInReviewPage(String arg1) throws InterruptedException {
		setupSuite();
		if(arg1.equalsIgnoreCase("Home")) {
			homeFlights();
	     	
		}else {
			dealsPageFlights();
		}
		urlString = excel.getStringData(2);
		filter.applyFilters(urlString);
		filter.selectFlight(2);
	}

	@Then("^user will be in review page Tocheck Flight details$")
	public void userWillBeInReviewPageTocheckFlightDetails() {
		try {
			filter.reviewDetails(driver);
		} catch (Exception e) {
			logger.info("terms and condition error");
		}
		filter.checkProgressBar();
	}

	@Then("^user Accepts T&c and Clicks Continue$")
	public void userAcceptsTcandClicksContinue(){
		try {
			filter.acceptTermsAndConditions();
		} catch (Exception e) {
			logger.info("terms and condition error");
		}
	}


}
