package com.epam.makeMytripTests;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.epam.Utilities.BrowserFactory;
import com.epam.makeMytriptestcasesPages.BaseClass;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


public class HotelPageController extends BaseClass {
	

	List<String> urlString;
    WebDriver driver;
	@Test(priority = 1,dataProvider="browsers")
	@Severity(SeverityLevel.NORMAL)
	@Description("Checking Hotels")
	@Story("Hotel Searching ")
	public void checkOutHotels(String browserName) throws InterruptedException, MalformedURLException {
		driver=BrowserFactory.startApplication(driver, browserName);
		open(config.getappUrl(),driver);
		urlString = excel.getStringData(3);
		List<String> personal = excel.getStringData(4);
		loggerextent = extentreport.createTest("checking Hotels");
		hotelPage.checkoutHotels(urlString, personal);

	}

	@Test(priority = 2,dataProvider="browsers")
	@Severity(SeverityLevel.NORMAL)
	@Description("Apllying Filters")
	@Story("Apllying Filters")
	public void applyFilters(String browserName) throws InterruptedException, MalformedURLException {
		
		checkOutHotels(browserName);
		hotelPage.applyFilters();

	}

	@Test(priority = 3,dataProvider="browsers")
	@Severity(SeverityLevel.NORMAL)
	@Description("Continue furthur")
	@Story("Continue furthur")
	public void continueToBook(String browserName ) throws InterruptedException, MalformedURLException {
	  applyFilters(browserName);
		hotelPage.ContinueToBookHotel();

	}

	@Test(priority = 4,dataProvider="browsers")
	@Severity(SeverityLevel.NORMAL)
	@Description("Fill Personal details")
	@Story("Fill Personal details")
	public void FillPersonalDetails(String browserName) throws InterruptedException, MalformedURLException {
		continueToBook(browserName);

		hotelPage.fillPersonalData();

	}
}
