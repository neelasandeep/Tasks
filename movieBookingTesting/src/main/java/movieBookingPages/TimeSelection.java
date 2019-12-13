package moviebookingpages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimeSelection {

	WebDriver driver;
	BaseClass bs;
	Logger logger = Logger.getLogger(TimeSelection.class);
	@FindBy(xpath = "//input[@name='time']")
	List<WebElement> seats;
	@FindBy(xpath = "//button[@value='Create']")
	WebElement nextButton;
	String selectedTime;

	public TimeSelection(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
		bs = new BaseClass();
	}

	public void selectTime() {
		for (int time = 0; time < seats.size(); time++) {
			if (bs.waitforDisplayOfElment(seats.get(time), driver)) {
				selectedTime = seats.get(time).getAttribute("value");
				logger.info(selectedTime);
				seats.get(time).click();
				nextButton.click();
				String url = driver.getCurrentUrl();
				logger.info(url);

				if (url.contains("time")) {
					driver.navigate().back();
				}
			}
		}
	}

	public String selectSingleTime() {
		if (bs.waitforDisplayOfElment(seats.get(0), driver)) {
			selectedTime = seats.get(0).getAttribute("value");
			seats.get(0).click();
		}
		return selectedTime;
	}

	public void clickNext() {

		if (bs.waitforDisplayOfElment(nextButton, driver)) {
			nextButton.click();

		}
	}

}
