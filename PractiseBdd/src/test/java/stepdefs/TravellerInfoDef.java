package stepdefs;



import com.epam.makemytriptestcasespagess.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TravellerInfoDef extends BaseClass {
	
	@Given("^User should be in Traveller Details page \"(.*?)\"$")
	public void userShouldBeInTravellerDetailsPage(String arg1) throws InterruptedException  {
		setupSuite();
		if(arg1.equalsIgnoreCase("Home")) {
			homeFlights();
			
	     	
		}else {
			dealsPageFlights();
		}
		urlString = excel.getStringData(2);
		filter.applyFilters(urlString);
		filter.selectFlight(2);
		filter.reviewDetails(driver);
		filter.checkProgressBar();
		filter.acceptTermsAndConditions();
	}

	@Then("^user Fills Name, Mail, phno, Gender$")
	public void userFillsNameMailphnoGender() throws InterruptedException  {
		filter.fillUserDetails();
	}

	@Then("^Clicks On Continue$")
	public void clicksOnContinue()  {
	   logger.info("clicks continue");
	}

}
