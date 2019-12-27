package stepdefs;



import com.epam.makemytriptestcasespagess.BaseClass;
import com.epam.makemytriptestcasespagess.CheckingDealsPage;
import com.epam.makemytriptestcasespagess.MakeMytripFlightsPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FlightsSearchstepdef extends BaseClass {
	
	

	@Given("^user Should be in Home Page \"(.*?)\"$")
	public void userShouldbeinHomePage(String arg1)   {
		
		setupSuite();
	if(arg1.equalsIgnoreCase("Home")) {
		
     	driver=open(config.getappUrl());
     	flightsPage = new MakeMytripFlightsPage(driver);
	}else {
		driver=open("https://www.makemytrip.com/daily-deals/");
		checkDeals = new CheckingDealsPage(driver);
	}
		
	}

	@When("^User enters trip details \"(.*?)\"$")
	public void userEntersTripDetails(String arg1) throws InterruptedException  {
		if(arg1.equalsIgnoreCase("Home")) {
			urlString = excel.getStringData(1);
			flightsPage.checkFlights(urlString);
		}else {
		urlString = excel.getStringData(5);
		checkDeals.searchInDeals(urlString);
		}
	   
	}

	@Then("^clicks On Search Button \"(.*?)\"$")
	public void clicksOnSearchButton(String arg1)  {
		if(arg1.equalsIgnoreCase("Home")) {
			flightsPage.search();
		}else {
		checkDeals.dealsSearch();
		}
	}
	

}
