package stepdefs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import moviebookingpages.BaseClass;
import moviebookingpages.RegistrationPage;
import utilities.ConfigDataprovider;

public class RegistrationStepdef {
	WebDriver driver;
	BaseClass bs;
	ConfigDataprovider config;
	Logger logger = Logger.getLogger(RegistrationStepdef.class);
	RegistrationPage registration;
	@Given("^user should be in Home page$")
	public void userShouldBeInHomePage() {
		bs=new BaseClass();
		config=new ConfigDataprovider();
		driver=bs.getDriver(config.getmovieURL());
		
	}

	@When("^user clicks on Registert$")
	public void userClicksOnRegistert()  {
		registration=new RegistrationPage(driver);
	    registration.clickOnRegister();
	}

	@When("^user enters username \"(.*?)\"$")
	public void userEntersUsername(String userName)  {
		registration.enteruserName(userName);
	}

	@When("^user enters Password \"(.*?)\"$")
	public void userEntersPassword(String password) {
		registration.enterPassword(password);
	}

	@When("^clicks on Register now$")
	public void clicksOnRegisterNow() {
	    logger.info("not implemented");
	}

	@Then("^it should display successful message$")
	public void itShouldDisplaySuccessfulMessage() {
		 logger.info("not implemented yet");
	}

	@Then("^it should display unsuccesful message$")
	public void itShouldDisplayUnsuccesfulMessage()  {
		 logger.info("not yet implemented ");
	}



}
