package steps;

import org.openqa.selenium.WebDriver;


import moviebookingpages.DateSelectionPage;


public class DateSelectionStep {
	WebDriver driver;
	DateSelectionPage selectDate;
	public  DateSelectionStep(WebDriver driver1) {
		driver=driver1;
		selectDate = new DateSelectionPage(driver);
	}
	public void selectDatefromOptions() {
		selectDate.selectDate();
	}
	public void clickNextButtonOfDatePage() {
		selectDate.clicknextOfDatePage();
	}
	public void selectOneDate() {
		selectDate.selectSingleDate();
	}

}
