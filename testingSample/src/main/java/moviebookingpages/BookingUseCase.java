package moviebookingpages;


import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingUseCase {
	WebDriver driver;
	BaseClass bs;
	static final String VALUE="value";
	Logger logger = Logger.getLogger(BookingUseCase.class);

	@FindBy(xpath = "//input[@name='movie']")
	List<WebElement> movies;
	@FindBy(xpath = "//input[@name='theater']")
	List<WebElement> theaters;
	@FindBy(xpath = "//input[@name='date']")
	List<WebElement> dates;
	@FindBy(xpath = "//input[@name='time']")
	List<WebElement> times;
	@FindBy(xpath = "//input[@name='seat']")
	List<WebElement> seats;
	@FindBy(xpath = "//button[@value='Create']")
	WebElement nextButton;
	String combination="";
	String moviecombo;
	String theatercombo;
	String datecombo;
	String timecombo;
	SettestedDataintoExcell excelldata;
	public BookingUseCase(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
		bs = new BaseClass();
	}
	public void checkCombinations(String location){
       combination+=location+"%";
		if (bs.waitwithLocator(driver, "//input[@value='" + location + "']")) {

			driver.findElement(By.xpath("//input[@value='" + location + "']")).click();
		}

		nextButton.click();
		checkiMovies();
		

	}

	public void checkiMovies() {
		
		for (int movieCount = 0; movieCount < movies.size(); movieCount++) {
			 moviecombo=combination+movies.get(movieCount).getAttribute(VALUE)+"%";
		
			movies.get(movieCount).click();
			nextButton.click();
			checkTheaters();
			moviecombo="";
		}
		driver.navigate().back();
	}
	public void checkTheaters() {
		
		for (int theaterCount = 0; theaterCount < theaters.size(); theaterCount++) {
			 theatercombo=moviecombo+theaters.get(theaterCount).getAttribute(VALUE)+"%";
		
			theaters.get(theaterCount).click();
			nextButton.click();
			checkDates();
			theatercombo="";
		}
		driver.navigate().back();
	}

	public void checkDates() {
		for (int dateCount = 0; dateCount < dates.size(); dateCount++) {
			datecombo=theatercombo+dates.get(dateCount).getAttribute(VALUE)+"%";
			
			dates.get(dateCount).click();
			nextButton.click();
			checkTime();
			datecombo="";
		}
		driver.navigate().back();

	}

	public void checkTime()  {
		for (int timeCount = 0; timeCount < times.size(); timeCount++) {
			timecombo=datecombo+times.get(timeCount).getAttribute(VALUE)+"%";
			
			times.get(timeCount).click();
			nextButton.click();
			checkSeats();
			timecombo="";
		}
		driver.navigate().back();
	}

	public void checkSeats() {
		for (int seatCount = 0; seatCount < seats.size(); seatCount++) {
			
				if (seats.get(seatCount).isEnabled()) {
					logger.info(timecombo);
					excelldata=new SettestedDataintoExcell(timecombo);
					excelldata.setExcellData();
					
					seats.get(seatCount).click();
					break;
				}

			
		}
		driver.navigate().back();

	}

}
