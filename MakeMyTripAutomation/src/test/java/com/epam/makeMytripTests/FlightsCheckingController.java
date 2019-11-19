package com.epam.makeMytripTests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.epam.makeMytriptestcasesPages.BaseClass;
import com.epam.makeMytriptestcasesPages.FlightsFilterPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class FlightsCheckingController extends BaseClass{
	
	
	
	FlightsFilterPage filterPage;
	List<String> urlString;
	@Test(priority = 1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Testing checking flights")
	@Story("flights chcking")
	public void checckFlights() throws InterruptedException {
     open(config.getappUrl());
		loggerextent = extentreport.createTest("checkflights");
		urlString = excel.getStringData(1);
		driver = flightsPage.checkFlights(urlString);
		Assert.assertTrue(driver.getCurrentUrl().contains("search"));
		

	}
	@Test(priority = 7)
	@Severity(SeverityLevel.NORMAL)
	@Description("Testing Deals page")
	@Story("Deals page")
	public void checkingInDeals() throws InterruptedException{
		 open(config.getappUrl());
		loggerextent = extentreport.createTest("checking Deals");
		urlString = excel.getStringData(5);
		checkDeals.enterIntoDeals();
		 
		 driver=checkDeals.SearchInDeals(urlString);
		 
	}
	@Test(priority =2)
	@Severity(SeverityLevel.NORMAL)
	@Description("Testing Filters i flights Booking")
	@Story("Filters  page")
	public void applyFilters() throws InterruptedException{
		checckFlights();
		urlString = excel.getStringData(2);

		filterPage = new FlightsFilterPage(driver);
		filterPage.applyFilters(urlString);
	}
	@Test(priority =3)
	@Severity(SeverityLevel.NORMAL)
	@Description("Testing Furthur review procedure")
	@Story("review procedure")
	public void proceedToBook() throws InterruptedException{
		applyFilters();
		String status=filterPage.proceedToBook(2);
		System.out.println(status);
		Assert.assertEquals(status, "OK");
	}
	@Test(priority=4)
	@Severity(SeverityLevel.NORMAL)
	@Description("Testing Progress Bar")
	@Story("Progress Bar")
	public void checkProgressbar()  throws InterruptedException{
		proceedToBook();
		String status=filterPage.checkProgressBar();
		Assert.assertEquals(status, "OK");

	}
	@Test(priority = 5)
	@Severity(SeverityLevel.NORMAL)
	@Description("reviewing and continue furthur")
	@Story("Review Furthur")
	public void reviewAndContinue() throws InterruptedException{
		checkProgressbar();
		String url=filterPage.reviewDetails();
		Assert.assertTrue(url.contains("flight/traveller"));
		
	}
	@Test(priority = 6)
	@Severity(SeverityLevel.NORMAL)
	@Description("Fill User data")
	@Story("userdata Filling")
	public void FillUserdata() throws InterruptedException{
		reviewAndContinue();
		filterPage.fillUserDetails();
	}
}
