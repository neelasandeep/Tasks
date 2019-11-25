package Stepdefs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.epam.Utilities.BrowserFactory;
import com.epam.Utilities.Helper;
import com.epam.makeMytriptestcasesPagess.BaseClass;
import com.epam.makeMytriptestcasesPagess.HomePage;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class HomePageFunctionalitiesStepdef extends BaseClass{
	List<String> urlString;
	List<String> urls;
   List<String> moreurl=new ArrayList<String>();
@Given("^User should be in HomePage$")
public void user_should_be_in_HomePage() throws Throwable {
	//localSetup();
	setupSuite();
	

	open("https://www.makemytrip.com/");
}

@When("^User clicks on any Option \"(.*?)\"$")
public void user_clicks_on_any_Option(String choice) throws Throwable {
    if(choice.equalsIgnoreCase("NavBar")) {
    	urlString = excel.getStringData(0);
		 urls = homePage.checkNavbarAction();	
    	
    }else {
    	urlString = excel.getStringData(6);
    	
    	for (int i = 0; i < urlString.size(); i++) {
    		
    		String[] data = urlString.get(i).split("%");
    
    	moreurl.add(homePage.checkMoreOptions(data[0]));
    
    	}
    }
}


@Then("^it should redirect to Selected page \"(.*?)\"$")
public void it_should_redirect_to_Selected_page(String choice) throws Throwable {
	if(choice.equalsIgnoreCase("NavBar")){
		for (int i = 0; i < urls.size(); i++) {
			String[] data = urlString.get(i).split("%");

			Assert.assertTrue(urls.get(i).contains(data[0]), "error in " + data[0] + " link");
		}
		}else {
			for (int i = 0; i < moreurl.size(); i++) {
				String[] data = urlString.get(i).split("%");
				System.out.println(data[1]);
			Assert.assertTrue(moreurl.get(i).contains(data[1]), "error in"+data[1]+"Link");
			}
		}
	
	
}
@When("^user select any footerlinks it should give response$")
public void user_select_any_footerlinks_it_should_give_response() {
    homePage.BrokenLinksList();
}


}
