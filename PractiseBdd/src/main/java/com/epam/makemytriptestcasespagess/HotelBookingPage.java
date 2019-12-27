package com.epam.makemytriptestcasespagess;

import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HotelBookingPage extends BaseClass {
	WebDriver driver1;
	
	MakeMytripFlightsPage flightspageObject;
	public HotelBookingPage(WebDriver driver) {
		this.driver1 = driver;
		PageFactory.initElements(driver, this);
		flightspageObject=new MakeMytripFlightsPage(driver1);
	}

	List<String> personal;
	@FindBy(xpath = "//nav/ul/li")
	List<WebElement> flights;
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
	WebElement roomsandguest;
	@FindBy(xpath = "//div[@class='hsw_inner']//ul[1]//li")
	List<WebElement> rooms;
	@FindBy(xpath = "//div[contains(@class,'padding20 makeFlex column')]")
	List<WebElement> hotels;

	@FindBy(xpath = "//span[@class='numbering progress']")
	WebElement progressBar;
	@FindBy(xpath = "//span[@id='detpg_book_combo_btn']")
	WebElement bokkCombo;
	@FindBy(xpath = "//div[@class='filterRow'][2]//li[2]//label")
	WebElement mmtfilter;
	String text;
	
   public void hotelspage() {
	   flights.get(1).click();
   }
	public void checkoutHotels(List<String> data, List<String> personaldata) throws InterruptedException {
		try {
			flightspageObject.waitForAD("webklipper-publisher-widget-container-notification-frame",
					"//a[@id='webklipper-publisher-widget-container-notification-close-div']");
		} catch (Exception e) {

			logger.info("no rame proceed");
		}
		personal = personaldata;
		String[] data1 = data.get(0).split("%");
	    city.click();
	    cityname.sendKeys(data1[0]);
		sleep(1000);
		select.click();
		startDate.click();
		this.setDate(data1[1]);
		endDate.click();
		this.setDate(data1[2]);
		roomsandguest.click();
		int count = Integer.parseInt(data1[3].substring(0, 1));
		rooms.get(count).click();
		int childrenCount = Integer.parseInt(data1[4].substring(0, 1));
		driver1.findElement(By.xpath("//li[@data-cy='children-" + childrenCount + "']")).click();
		driver1.findElement(By.xpath("//button[@data-cy='submitGuest']")).click();
		
		sleep(2000);

	}
	public void searchHotels() {
		driver1.findElement(By.xpath("//button[@id='hsw_search_button']")).click();
	}

	public void setDate(String date) throws InterruptedException {

		String[] datar = date.split("-");
		int day = Integer.parseInt(datar[0]);
		String month = datar[1] + " " + datar[2];

		

		while (true) {

			text = driver1.findElement(By.xpath("//div[@class=\"DayPicker-Caption\"]/div")).getText();
			String[] datenew = text.split(" ");

			text = datenew[0].substring(0, 3) + " "
					+ datenew[0].substring(datenew[0].length() - 4, datenew[0].length());

			if (text.equals(month)) {
				break;
			} else {
				driver1.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}
		}
		sleep(2000);
		driver1.findElement(By.xpath("//div[@class='DayPicker-Day' and contains(text()," + day + ")]")).click();

	}

	public void applyFilters() throws InterruptedException {

		try {
			if (driver1.findElement(By.xpath("//div/a[contains(text(),'SHOW HOTELS')]")).isDisplayed()) {
				driver1.findElement(By.xpath("//div/a[contains(text(),'SHOW HOTELS')]")).click();
				
				driver1.findElement(By.xpath("//body[@class='bodyFixed overlayWholeBlack']")).click();
				
			}
		} catch (Exception e) {

			logger.info("Yo can proceed");
		}
		logger.info("wow its displayed");
		sleep(1000);
		
		driver1.findElement(By.xpath("//div[@class='filterRow'][2]//li[2]//label")).click();
		
		
		sleep(1000);
		WebElement slider = driver1.findElement(By.xpath("//div[@id='hlistpg_fr_price_per_night']//span[1]//div[1]"));
		Actions actions = new Actions(driver1);
		actions.dragAndDropBy(slider, +60, 0).perform();
		sleep(1000);
		

	}
	public void selectHotel() {
		hotels.get(2).click();
	}

	public void continueToBookHotel() {
		String parentwindow = driver1.getWindowHandle();
		Set<String> allwindow = driver1.getWindowHandles();

		for (String handle : allwindow) {
			if (!handle.equals(parentwindow)) {
				driver1.switchTo().window(handle);
				if (!driver1.findElements(By.xpath("//a[@id='detpg_headerright_book_now']")).isEmpty()) {
					driver1.findElement(By.xpath("//a[@id='detpg_headerright_book_now']")).click();
				}
				if (!driver1.findElements(By.xpath("//span[@id='detpg_book_combo_btn']")).isEmpty()) {
					bokkCombo.click();
				}
			}
		}
	}

	public void fillPersonalData() {
		String[] personalinfo = personal.get(0).split("%");
		if (progressBar.getText().equals("2")) {
			driver1.findElement(By.xpath("//input[@placeholder='Enter First Name']")).sendKeys(personalinfo[0]);
			driver1.findElement(By.xpath("//input[@placeholder='Enter Last Name']")).sendKeys(personalinfo[1]);
			driver1.findElement(By.xpath("//input[@id='email']")).sendKeys(personalinfo[2]);
			driver1.findElement(By.xpath("//input[@id='mNo']")).sendKeys("9876546786");
			driver1.findElement(By.xpath("//a[@class='primaryBtn btnPayNow']")).click();

		}
	}
}
