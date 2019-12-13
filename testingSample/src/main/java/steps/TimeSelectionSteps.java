package steps;



import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;


import org.testng.Assert;


import moviebookingpages.TimeSelection;


public class TimeSelectionSteps {

	WebDriver driver;
	
	TimeSelection selectTimeAndSeats;

	Logger logger = Logger.getLogger(TimeSelectionSteps.class);
	
	public TimeSelectionSteps(WebDriver driver1) {
		driver=driver1;
		selectTimeAndSeats= new TimeSelection(driver);
	}
	
	
	
	
	public void selectTime() {
		
		selectTimeAndSeats.selectTime();

	}
	
	public void clicknextOfTime() {
		selectTimeAndSeats.clickNext();
	}
	public void checkPage() {
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("date"));
		 driver.quit();
	}
}
