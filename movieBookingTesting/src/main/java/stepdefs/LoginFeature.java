package stepdefs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import moviebookingpages.BaseClass;
import moviebookingpages.LoginPage;
import utilities.ConfigDataprovider;

public class LoginFeature {
	WebDriver driver;
	BaseClass bs;
	ConfigDataprovider config;
	Logger logger = Logger.getLogger(LoginFeature.class);

	@Given("^user should be in Login page$")
	public void userShouldBeInLoginPage() {
		bs = new BaseClass();
		config = new ConfigDataprovider();
		driver = bs.getDriver(config.getmovieURL());

	}

	@When("^user enter credential and clicks  \"(.*?)\" and \"(.*?)\"$")
	public void userEnterCredentialAndClicksNext(String arg1, String arg2) {
		LoginPage login = new LoginPage(driver);
		login.enterCredentials(arg1, arg2);
		login.clickLoginButton();
	}

	@Then("^user should redirect to Home page$")
	public void userShouldRedirectToHomePage() {
		String url = driver.getCurrentUrl();
		logger.info(url);
		Assert.assertTrue(url.contains("8080"));
		driver.quit();
	}

	@When("^user enters wrong credential and clicks \"(.*?)\" and \"(.*?)\"$")
	public void userEntersWrongCredentialAndClicksNext(String arg1, String arg2) {

		userEnterCredentialAndClicksNext(arg1, arg2);
	}

	@Then("^it should diplay a wrong password$")
	public void itShouldDiplayWrongPasswordOrUsernameMsg() {
		String url = driver.getCurrentUrl();
		logger.info(url);
		Assert.assertTrue(url.contains("error"));
		driver.quit();
	}
	@Then("^it should be in Login Page$")
	public void itShouldBeInLoginPage() {
		String url = driver.getCurrentUrl();
		logger.info(url);
		Assert.assertTrue(url.contains("login"));
		driver.quit();
	}
	

}
