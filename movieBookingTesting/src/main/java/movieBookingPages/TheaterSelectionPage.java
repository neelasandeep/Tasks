package moviebookingpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class TheaterSelectionPage {
	
	WebDriver driver;
	BaseClass bs;
	Logger logger = Logger.getLogger(TheaterSelectionPage.class);
	@FindBy(xpath = "//button[@value='Create']")
	WebElement nextButton;
	public TheaterSelectionPage(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
		bs = new BaseClass();
	}
    @Step("Selecting Theater from list")

	public void selectTheater(String theater) {
      

		if (bs.waitwithLocator(driver, "//input[@value='" + theater + "']")) {
			
			driver.findElement(By.xpath("//input[@value='" + theater + "']")).click();
		}

	}
    @Step("Clicking nextButton of Theaters page")
	public void clickNext() {
    	 
		if(bs.waitforDisplayOfElment(nextButton, driver)) {
			nextButton.click();
			
	}
	}

}
