package com.epam.makeMytriptestcasesPages;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Dimension;

public class HotelBookingPage extends BaseClass {
	WebDriver driver;
	Logger logger = Logger.getLogger(FlightsFilterPage.class);

	public HotelBookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	List<String> personal;
	@FindBy(xpath = "//nav/ul/li")
	List<WebElement> Flights;
	@FindBy(xpath = "//input[@id='city']")
	WebElement city;
	@FindBy(xpath = "//input[@placeholder='Enter city/ Hotel/ Area/ Building']")
	WebElement cityname;
	@FindBy(xpath = "//input[@id='checkin']")
	WebElement startDate;
	@FindBy(xpath = "//input[@id='checkout']")
	WebElement endDate;
	@FindBy(xpath = "//li[@id='react-autowhatever-1-section-0-item-0']")
	WebElement select;
	@FindBy(xpath = "//input[@id='guest']")
	WebElement RoomsAndguest;
	@FindBy(xpath = "//div[@class='hsw_inner']//ul[1]//li")
	List<WebElement> Rooms;
	@FindBy(xpath = "//div[contains(@class,'padding20 makeFlex column')]/p[@class='latoBlack font26 blackText appendBottom5']")
	List<WebElement> Hotels;

	@FindBy(xpath = "//span[@class='numbering progress']")
	WebElement progressBar;
	@FindBy(xpath = "//span[@id='detpg_book_combo_btn']")
	WebElement bokkCombo;

	public void checkoutHotels(List<String> data, List<String> personaldata) throws InterruptedException {
		try {
			MakeMytripFlightsPage.waitForAD("webklipper-publisher-widget-container-notification-frame",
					"//a[@id='webklipper-publisher-widget-container-notification-close-div']");
		} catch (Exception e) {
		
			System.out.println("no rame proceed");
		}
		personal = personaldata;
		String[] data1 = data.get(0).split("%");
		Flights.get(1).click();
		city.click();
		cityname.sendKeys(data1[0]);
		Thread.sleep(1000);
		select.click();
		startDate.click();
		this.SetDate(data1[1]);
		endDate.click();
		this.SetDate(data1[2]);
		RoomsAndguest.click();
		int count = Integer.parseInt(data1[3].substring(0, 1));
		Rooms.get(count).click();
		int childrenCount = Integer.parseInt(data1[4].substring(0, 1));
		driver.findElement(By.xpath("//li[@data-cy='children-" + childrenCount + "']")).click();
		driver.findElement(By.xpath("//button[@data-cy='submitGuest']")).click();
		driver.findElement(By.xpath("//button[@id='hsw_search_button']")).click();
		Thread.sleep(2000);

	}

	public void SetDate(String date) throws InterruptedException {

		String datar[] = date.split("-");
		int day = Integer.parseInt(datar[0]);
		String month = datar[1] + " " + datar[2];

		String text = driver.findElement(By.xpath("//div[@class=\"DayPicker-Caption\"]/div")).getText();

		while (true) {

			text = driver.findElement(By.xpath("//div[@class=\"DayPicker-Caption\"]/div")).getText();
			String datenew[] = text.split(" ");

			text = datenew[0].substring(0, 3) + " "
					+ datenew[0].substring(datenew[0].length() - 4, datenew[0].length());

			if (text.equals(month)) {
				break;
			} else {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='DayPicker-Day' and contains(text()," + day + ")]")).click();

	}

	public void applyFilters() throws InterruptedException {

		try {
			if (driver.findElement(By.xpath("//div/a[contains(text(),'SHOW HOTELS')]")).isDisplayed()) {
				driver.findElement(By.xpath("//div/a[contains(text(),'SHOW HOTELS')]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//body[@class='bodyFixed overlayWholeBlack']")).click();
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			
			System.out.println("Yo can proceed");
		}
		System.out.println("wow its displayed");
		driver.findElement(By.xpath("//label[contains(text(),'MMT Assured')]")).click();
		Thread.sleep(4000);
		WebElement slider = driver.findElement(By.xpath("//div[@id='hlistpg_fr_price_per_night']//span[1]//div[1]"));
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(slider, +60, 0).perform();
		Hotels.get(2).click();

	}

	public void ContinueToBookHotel() {
		String parentwindow = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();

		for (String handle : allwindow) {
			if (!handle.equals(parentwindow)) {
				driver.switchTo().window(handle);
				if (driver.findElements(By.xpath("//a[@id='detpg_headerright_book_now']")).size() > 0) {
					driver.findElement(By.xpath("//a[@id='detpg_headerright_book_now']")).click();
				}
				if (driver.findElements(By.xpath("//span[@id='detpg_book_combo_btn']")).size() > 0) {
					bokkCombo.click();
				}
			}
		}
	}


	public void fillPersonalData() {
		String[] personalinfo = personal.get(0).split("%");
		if (progressBar.getText().equals("2")) {
		driver.findElement(By.xpath("//input[@placeholder='Enter First Name']")).sendKeys(personalinfo[0]);
		driver.findElement(By.xpath("//input[@placeholder='Enter Last Name']")).sendKeys(personalinfo[1]);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(personalinfo[2]);
		driver.findElement(By.xpath("//input[@id='mNo']")).sendKeys("9876546786");
		driver.findElement(By.xpath("//a[@class='primaryBtn btnPayNow']")).click();

	}
	}
}
