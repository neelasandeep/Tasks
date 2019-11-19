package com.epam.makeMytripTests;

import java.util.List;


import org.testng.annotations.Test;

import com.epam.makeMytriptestcasesPages.BaseClass;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


public class HotelPageController extends BaseClass {
	

	List<String> urlString;

	@Test(priority = 1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Checking Hotels")
	@Story("Hotel Searching ")
	public void checkOutHotels() throws InterruptedException {
		
		open(config.getappUrl());
		urlString = excel.getStringData(3);
		List<String> personal = excel.getStringData(4);
		loggerextent = extentreport.createTest("checking Hotels");
		hotelPage.checkoutHotels(urlString, personal);

	}

	@Test(priority = 2)
	@Severity(SeverityLevel.NORMAL)
	@Description("Apllying Filters")
	@Story("Apllying Filters")
	public void applyFilters() throws InterruptedException {
		checkOutHotels();
		hotelPage.applyFilters();

	}

	@Test(priority = 3)
	@Severity(SeverityLevel.NORMAL)
	@Description("Continue furthur")
	@Story("Continue furthur")
	public void continueToBook() throws InterruptedException {
		applyFilters();
		hotelPage.ContinueToBookHotel();

	}

	@Test(priority = 4)
	@Severity(SeverityLevel.NORMAL)
	@Description("Fill Personal details")
	@Story("Fill Personal details")
	public void FillPersonalDetails() throws InterruptedException {
		continueToBook();

		hotelPage.fillPersonalData();

	}
}
