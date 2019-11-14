package com.epam.seleniumHomeTask_2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class MakeMyTripFactory {
	WebDriver driver;
	String msg;
	HomePage homePage;
	private static Logger logger= Logger.getLogger(MakeMyTripFactory.class.getClass());
	@BeforeMethod
	public void setup() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.makemytrip.com");
		homePage = new HomePage(driver);

	}

	@Test
	public void TestflightNavBar() throws InterruptedException {

		msg = homePage.checkFlightNavbarAction();
		Assert.assertTrue(msg.contains("flights"), "error in flight link");

		msg = homePage.checkHotelNavbarAction();
		Assert.assertTrue(msg.contains("hotels"), "error in hotel link");

		msg = homePage.checkVillaApptsNavbarAction();
		Assert.assertTrue(msg.contains("homestays"), "error in villa link");

		msg = homePage.checkHolidaysNavbarAction();
		Assert.assertTrue(msg.contains("holidays-india"), "error in holidays link");

		msg = homePage.checktrainsNavbarAction();
		Assert.assertTrue(msg.contains("railways"), "error in railways link");

		msg = homePage.checkBusNavbarAction();
		Assert.assertTrue(msg.contains("bus-tickets"), "error in bus link");

		msg = homePage.checkCabNavbarAction();
		Assert.assertTrue(msg.contains("cabs"), "error in cabs link");

		msg = homePage.checkVisaNavbarAction();
		Assert.assertTrue(msg.contains("visa"), "error in visa link");

		msg = homePage.checkGiftcardNavbarAction();
		Assert.assertTrue(msg.contains("gift-cards"), "error in gift-cards link");

		msg = homePage.checkMoreOptions("mybiz");
		Assert.assertTrue(msg.contains("v2"), "error in moreBiz-cards link");
		
		msg = homePage.checkMoreOptions("internationalflights");
		Assert.assertTrue(msg.contains("international-flights"), "error in international-flights link");
		
		msg = homePage.checkMoreOptions("internationalHotels");
		Assert.assertTrue(msg.contains("hotels-international"), "error in hotels-international link");
		
		msg = homePage.checkMoreOptions("deals");
		Assert.assertTrue(msg.contains("daily-deals/"), "error in daily-deals link");
		
		msg = homePage.checkMoreOptions("blogs");
		Assert.assertTrue(msg.contains("blog"), "error in blog link");

	}
	@Test
	public void checkBrokenLinks() {
		logger.info("hello");
		homePage.BrokenLinksList();
	}

}
