package steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import moviebookingpages.BaseClass;
import moviebookingpages.DateSelectionPage;
import moviebookingpages.LoginPage;
import moviebookingpages.MovieLocationsPage;
import moviebookingpages.MovieSelectionPage;
import moviebookingpages.SeatSelection;
import moviebookingpages.TheaterSelectionPage;
import moviebookingpages.TimeSelection;
import utilities.ConfigDataprovider;

public class SeatSelectionSteps {

	WebDriver driver;
	BaseClass bs;
	
	MovieLocationsPage selectlocation;
	MovieSelectionPage selectmovie;
	TheaterSelectionPage selectTheater;
	DateSelectionPage selectDate;
	TimeSelection selectTimeAndSeats;
	ConfigDataprovider config;
	String ticketInfo="";
	
	SeatSelection saetSelection;

	String selectedSeat;
	LoginPage login;
	
	Logger logger = Logger.getLogger(SeatSelectionSteps.class);
   boolean seatAvailability;

   
   public WebDriver openHomePage() {
		bs=new BaseClass();
		config=new ConfigDataprovider();
		driver=bs.getDriver(config.getmovieURL());
		selectTimeAndSeats= new TimeSelection(driver);
		return driver;
	}
   public void enterCredentials(String userName,String password) {
		 login=new LoginPage(driver);
		  login.enterCredentials(userName,password);
	}
   public void clickNext() {
		 login.clickLoginButton();
	}
	
	public void selectLocation(String location) {
		 selectlocation=new MovieLocationsPage(driver);
		  selectlocation.selectLocation(location);
	}
	public void clickNextOfLocation() {
		selectlocation.clickNext();
	}
	public void selectMovie(String movieName) {
		ticketInfo+=movieName.split("-")[1]+"%";
		selectmovie = new MovieSelectionPage(driver);
		selectmovie.selectMovie(movieName);
	}
	public void clickNextOfMoviePage() {
		selectmovie.clickNext();
	}
	public void selectTheater(String theater) {
		ticketInfo+=theater.split("-")[1]+"%";
		   selectTheater = new TheaterSelectionPage(driver);
			selectTheater.selectTheater(theater);
	   }
	 public void selectNextOftheater() {
			selectTheater.clickNext();
	   }
	 public void selectDate(String date) {
		logger.info(date);
		
		  selectDate=new DateSelectionPage(driver);
		  ticketInfo+= selectDate.selectSingleDate()+"%";
		  
	   }
	 public void selectNextofDatePage() {
		  selectDate.clicknextOfDatePage();
	 }
	 public void selectTime(String time) {
		 logger.info(time);
		 selectTimeAndSeats= new TimeSelection(driver);
		 ticketInfo+=selectTimeAndSeats.selectSingleTime()+"%";

		}
	 public void clicknextOfTime() {
			selectTimeAndSeats.clickNext();
		}
	 public void selectSeat(String seat) {
		 ticketInfo+=seat+",%";
		 saetSelection=new SeatSelection(driver);
			selectedSeat=seat;
			seatAvailability=saetSelection.selectSeat(seat);
			System.out.println(ticketInfo);
			driver.findElement(By.xpath("//button[@value='Create']")).click();
		}
	 
		public void clickNextSeat() {
			
			saetSelection=new SeatSelection(driver);
			saetSelection.clickNext();
		}
		
	public String checkUrl() {
		if(seatAvailability) {
		 String url=driver.getCurrentUrl();
		 Assert.assertTrue(url.contains(selectedSeat));
		 validateTicket(ticketInfo);
		 driver.quit();
		}else {
			String url=driver.getCurrentUrl();
			 Assert.assertTrue(url.contains("time"));
			 driver.quit();
		}
		return ticketInfo;
	}
	public void validateTicket(String expectedTicket) {
		saetSelection.validateTicketInfo(expectedTicket);
	}
	
	public void checkSamePageUrl() {
		 String url=driver.getCurrentUrl();
		 Assert.assertTrue(url.contains("time"));
		 driver.quit();
		
	}
	
}
