package moviebookingpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MovieSelectionPage {
	WebDriver driver;
	BaseClass bs;
	Logger logger = Logger.getLogger(MovieSelectionPage.class);
	@FindBy(xpath = "//button[@value='Create']")
	WebElement nextButton;
	public MovieSelectionPage(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
		bs = new BaseClass();
	}

	public void selectMovie(String movie) {
		

		if (bs.waitwithLocator(driver, "//input[@value='" + movie + "']")) {
			
			driver.findElement(By.xpath("//input[@value='" + movie + "']")).click();
		}

	}

	public void clickNext() {
		
		if(bs.waitforDisplayOfElment(nextButton, driver)) {
			nextButton.click();
			
	}
	}

}
