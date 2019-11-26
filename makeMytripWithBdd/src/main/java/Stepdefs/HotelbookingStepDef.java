package Stepdefs;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.epam.Utilities.BrowserFactory;
import com.epam.Utilities.ExcelDataProvider;
import com.epam.Utilities.Helper;
import com.epam.makeMytriptestcasesPagess.BaseClass;
import com.epam.makeMytriptestcasesPagess.HotelBookingPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class HotelbookingStepDef  {
	  WebDriver hoteldriver;
	  public  HotelBookingPage hotelPage;
	  public ExcelDataProvider excel;
	List<String> urlString;
	@Given("^User Should be in Hotels page$")
	public void user_Should_be_in_Hotels_page() throws Throwable {
		//localSetup();
		BaseClass bs=new BaseClass();
		bs.setupSuite();
		//localSetup();
	
		hoteldriver=bs.open("https://www.makemytrip.com/");
		hotelPage = new HotelBookingPage(hoteldriver);
		hotelPage.Hotelspage();
		excel = new ExcelDataProvider();
	}

	@Then("^User enters Place and date to book hotel$")
	public void user_enters_Place_and_date_to_book_hotel() throws InterruptedException {
		urlString = excel.getStringData(3);
		List<String> personal = excel.getStringData(4);
	    hotelPage.checkoutHotels(urlString, personal);
	}

	@Then("^clicks on search Button$")
	public void clicks_on_search_Button() throws InterruptedException  {
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
   hotelPage.fillPersonalData();
	}
	@Then("^it will moves to userdetails page$")
	public void it_will_moves_to_userdetails_page() throws Throwable {
		// hotelPage.fillPersonalData();
	}
	

	
	
}
