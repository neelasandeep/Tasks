package com.epam.makeMytripTests;

import java.util.List;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.epam.makeMytriptestcasesPages.BaseClass;
import com.epam.makeMytriptestcasesPages.FlightsFilterPage;

public class MakeMyTripFactory extends BaseClass {

	String msg;
	List<String> urlString;
	FlightsFilterPage filterPage;

	@Test(priority = 1)
	public void TestMakeMyTripNavBar() throws InterruptedException {

		loggerextent = extentreport.createTest("TestMakeMyTripNavBar");
		loggerextent.info("Test started");
		urlString = excel.getStringData(0);
		List<String> urls = homePage.checkNavbarAction();
		System.out.println(urlString);
		for (int i = 0; i < urls.size(); i++) {
			String[] data = urlString.get(i).split("%");

			Assert.assertTrue(urls.get(i).contains(data[0]), "error in " + data[0] + " link");
		}

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

	@Test(priority = 2)
	public void checkBrokenLinksInFooter() {

		loggerextent = extentreport.createTest("Broken links");
		homePage.BrokenLinksList();
	}

	@Test(priority = 3)
	public void checckFlights() throws InterruptedException {

		loggerextent = extentreport.createTest("checkflights");
		urlString = excel.getStringData(1);
		driver = flightsPage.checkFlights(urlString);
		Assert.assertTrue(driver.getCurrentUrl().contains("search"));
		urlString = excel.getStringData(2);

		filterPage = new FlightsFilterPage(driver);
		filterPage.applyFilters(urlString);

	}

	@Test(priority = 4)
	public void checkOutHotels() throws InterruptedException {

		urlString = excel.getStringData(3);
		List<String> personal = excel.getStringData(4);
		loggerextent = extentreport.createTest("checking Hotels");
		hotelPage.checkoutHotels(urlString, personal);
	}

	@Test
	public void checkingInDeals() throws InterruptedException {
		loggerextent = extentreport.createTest("checking Deals");
		urlString = excel.getStringData(5);
		homePage.checkMoreOptions("deals");
		driver = checkDeals.SearchInDeals(urlString);
		urlString = excel.getStringData(2);
		filterPage = new FlightsFilterPage(driver);
		filterPage.applyFilters(urlString);
	}

}
