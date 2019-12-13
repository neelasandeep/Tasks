package moviebookingpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MovieLocationsPage {

	WebDriver driver;
	BaseClass bs;
	Logger logger = Logger.getLogger(MovieLocationsPage.class);
	@FindBy(xpath = "//button[@value='Create']")
	WebElement nextButton;
	public MovieLocationsPage(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
		bs = new BaseClass();
	}

	public void selectLocation(String location) {
		

		if (bs.waitwithLocator(driver, "//input[@value='" + location + "']")) {
			
			driver.findElement(By.xpath("//input[@value='" + location + "']")).click();
		}

	}

	public void clickNext() {
		
		if(bs.waitforDisplayOfElment(nextButton, driver)) {
			nextButton.click();
			
	}
	}

}
