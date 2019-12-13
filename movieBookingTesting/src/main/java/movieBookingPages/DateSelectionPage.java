package moviebookingpages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DateSelectionPage {
	WebDriver driver;
	BaseClass bs;
	Logger logger = Logger.getLogger(DateSelectionPage.class);
	@FindBy(xpath = "//input[@name='date']")
	List<WebElement> totalDates;
	@FindBy(xpath = "//button[@value='Create']")
	WebElement nextButton;
	String selectedDate;

	public DateSelectionPage(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
		bs = new BaseClass();
	}

	public void selectDate() {
		for (int dateCount = 0; dateCount < totalDates.size(); dateCount++) {
			if (bs.waitforDisplayOfElment(totalDates.get(dateCount), driver)) {
				selectedDate = totalDates.get(dateCount).getAttribute("value");
				logger.info(selectedDate);
				totalDates.get(dateCount).click();
				nextButton.click();
				String url = driver.getCurrentUrl();
				logger.info(url);

				if (url.contains(selectedDate)) {
					driver.navigate().back();
				}
			}
		}
	}

	public String selectSingleDate() {

		if (bs.waitforDisplayOfElment(totalDates.get(0), driver)) {

			totalDates.get(0).click();
			selectedDate = totalDates.get(0).getAttribute("value");

		}
		return selectedDate;
	}

	public void clicknextOfDatePage() {
		nextButton.click();
	}

}
