package steps;

import org.openqa.selenium.WebDriver;

import moviebookingpages.BaseClass;
import moviebookingpages.BookingUseCase;
import moviebookingpages.LoginPage;
import utilities.ConfigDataprovider;

public class BookingSteps {
	WebDriver driver;
	BaseClass bs;
	String selectedTheater;
	BookingUseCase booking;
	
	ConfigDataprovider config;
	public void openLocationPage() {
		bs=new BaseClass();
		config=new ConfigDataprovider();
		driver=bs.getDriver(config.getmovieURL());
		
		LoginPage login=new LoginPage(driver);
		  login.enterCredentials("shubhi","1234");
		  login.clickLoginButton();
		  booking=new BookingUseCase(driver);
	}
	
	public void checkCombinations(String location) {
		booking.checkCombinations(location);
		
		
	}

}
