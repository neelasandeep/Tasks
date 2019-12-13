package moviebookingpages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import utilities.ConfigDataprovider;

public class SeatSelection {
	WebDriver driver;
	BaseClass bs;
	ConfigDataprovider config;
	static final String SEATPATH="seatPath";
	Logger logger = Logger.getLogger(SeatSelection.class);
	@FindBy(xpath = "//button[@value='Create']")
	WebElement nextButton;
	@FindBy(xpath = "//form/p")
	List<WebElement> actual;
	
	public SeatSelection(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
		bs = new BaseClass();
	}
	public boolean selectSeat(String seat) {
	boolean	seatAvailability=false;
	config = new ConfigDataprovider();
		if (bs.waitwithLocator(driver, config.getDataFromConfig(SEATPATH) + seat + "']")) {
			if(driver.findElement(By.xpath(config.getDataFromConfig(SEATPATH) + seat + "']")).isEnabled()) {
			driver.findElement(By.xpath(config.getDataFromConfig(SEATPATH)+ seat + "']")).click();
			seatAvailability=true;
			}else {
			logger.info(seat+"  is already Booked");
			}
			
		}
return seatAvailability;
	}
	public void validateTicketInfo(String expectedTicket) {
		SoftAssert asert=new SoftAssert();
		String[]expected=expectedTicket.split("%");
		System.out.println(actual.get(1).getText().split(": ")[1]);
		asert.assertEquals(actual.get(1).getText().split(": ")[1], expected[0]);
		asert.assertEquals(actual.get(2).getText().split(": ")[1], expected[1]);
		asert.assertEquals(actual.get(3).getText().split(": ")[1], expected[2]);
		asert.assertEquals(actual.get(4).getText().split(": ")[1], expected[3]);
		asert.assertAll();
	}

	public void clickNext() {
		
		if(bs.waitforDisplayOfElment(nextButton, driver)) {
			nextButton.click();
			
	}
	}

}
