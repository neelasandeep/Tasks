package com.epam.makemytriptestcasespagess;

import java.time.Duration;
import java.util.List;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class MakeMytripFlightsPage extends BaseClass {
	WebDriver driver1;

	public MakeMytripFlightsPage(WebDriver driver) {
		this.driver1 = driver;
		PageFactory.initElements(this.driver1, this);
	}

	String adframe;
	String btn;
	@FindBy(xpath = "//input[@id='fromCity']")
	WebElement from;
	@FindBy(xpath = "//input[@id='toCity']")
	WebElement to;
	@FindBy(xpath = "//input[@placeholder='From']")
	WebElement fromCity;
	@FindBy(xpath = "//input[@placeholder='To']")
	WebElement toCity;
	@FindBy(xpath = "//div[@class='calc60']/p")
	WebElement select;

	@FindBy(xpath = "//span[contains(text(),'DEPARTURE')]")
	WebElement departure;
	@FindBy(xpath = "//div[@class='DayPicker-Caption']/div")
	List<WebElement> vdate;
	@FindBy(xpath = "//div[@data-cy='flightTraveller']")
	WebElement travellers;

	@FindBy(xpath = "//ul[@class='guestCounter font12 darkText']/li")
	List<WebElement> adults;
	@FindBy(xpath = "//div[@class='makeFlex appendBottom25']/div[1]/ul/li")
	List<WebElement> children;
	@FindBy(xpath = "//div[@class='makeFlex appendBottom25']/div[2]/ul/li")
	List<WebElement> infants;
	@FindBy(xpath = "//ul[@class='guestCounter classSelect font12 darkText']/li")
	List<WebElement> travelClassTypes;
	@FindBy(xpath = "//button[@data-cy='travellerApplyBtn']")
	WebElement travelApplyButton;
	@FindBy(xpath = "//a[contains(@class,'primaryBtn font24 latoBlack widgetSearchBtn')]")
	WebElement searchButton;

	public WebDriver checkFlights(List<String> data) throws InterruptedException {

		try {
			waitForAD("webklipper-publisher-widget-container-notification-frame",
					"//a[@id='webklipper-publisher-widget-container-notification-close-div']");
		} catch (Exception e) {

			logger.info("no frame proceed");
		}
		for (int i = 0; i < data.size(); i++) {
			String[] data1 = data.get(i).split("%");
			sleep(2000);
			driver1.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(data1[0]);
			sleep(1000);
			select.click();

			sleep(500);
			to.sendKeys(data1[1]);
			sleep(1000);
			to.sendKeys(Keys.ENTER);
			departure.click();
			setDate(data1[2], "//div[@class=\"DayPicker-Caption\"]/div",
					"//span[@class='DayPicker-NavButton DayPicker-NavButton--next']",
					"//div[@class='DayPicker-Month'][1]/div[3]/div/div[@role='gridcell'][#]");

			setPassengers(2, 0, 0, data1[6]);

		}
		return driver1;
	}

	public void search() {
		searchButton.click();
	}

	public void setDate(String date, String month1, String next, String datetoPick) throws InterruptedException {

		String[] datar = date.split("-");
		int day = Integer.parseInt(datar[0]) - 1;
		String month = datar[1].toUpperCase() + " " + datar[2];

		String text = driver1.findElement(By.xpath(month1)).getText();
		logger.info(text);
		while (true) {

			text = driver1.findElement(By.xpath(month1)).getText();
			logger.info(text + "mine");
			String[] datenew = text.split(" ");

			text = datenew[0].substring(0, 3).toUpperCase() + " " + datenew[1];

			if (text.equals(month)) {
				break;
			} else {
				driver1.findElement(By.xpath(next)).click();
			}

		}
		sleep(2000);
		String[] daypath = datetoPick.split("#");
		driver1.findElement(By.xpath(daypath[0] + day + daypath[1])).click();

	}

	private void setPassengers(int adultsCount, int childrenCount, int infantsCount, String travelClass) {

		travellers.click();

		adults.get(adultsCount).click();

		children.get(childrenCount).click();

		infants.get(infantsCount).click();

		int number = 0;
		for (int index = 0; index < travelClassTypes.size(); index++) {
			if (travelClassTypes.get(index).getText().equals(travelClass))
				number = index;
			logger.info(travelClassTypes.get(index).getText());
		}
		travelClassTypes.get(number).click();
		travelApplyButton.click();
	}

	public void waitForAD(String frame, String clsBtn) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver1).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		adframe = frame;
		btn = clsBtn;
		WebElement closeAd = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				driver.switchTo().frame(adframe);
				return driver.findElement(By.xpath(btn));
			}
		});
		if (closeAd != null) {
			closeAd.click();
		}
	}

}
