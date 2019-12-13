package steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


import moviebookingpages.TheaterSelectionPage;


public class TheaterStep {
	WebDriver driver;

	
	TheaterSelectionPage selectTheater;
	
	
	Logger logger = Logger.getLogger(TheaterStep.class);

	public TheaterStep(WebDriver driver1) {
		driver = driver1;
		selectTheater = new TheaterSelectionPage(driver);
	}
	public void selectTheater(String theaterName) {
		logger.info("Selecting" + theaterName + "Theater from list");
		selectTheater.selectTheater(theaterName);
	}
	public void clickNextoftheaterpage() {
		selectTheater.clickNext();
	}

}
