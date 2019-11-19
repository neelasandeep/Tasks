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

public class HomePageController extends BaseClass {

	String msg;
	List<String> urlString;
	FlightsFilterPage filterPage;

	@Test(priority = 1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Testing checking flights")
	@Story("NavBar chcking")
	public void TestMakeMyTripNavBar() throws InterruptedException {
		open(config.getappUrl());
		loggerextent = extentreport.createTest("TestMakeMyTripNavBar");
		loggerextent.info("Test started");
		urlString = excel.getStringData(0);
		List<String> urls = homePage.checkNavbarAction();
		System.out.println(urlString);
		for (int i = 0; i < urls.size(); i++) {
			String[] data = urlString.get(i).split("%");

			Assert.assertTrue(urls.get(i).contains(data[0]), "error in " + data[0] + " link");
		}

	}

	@Test(priority = 2)
	@Severity(SeverityLevel.NORMAL)
	@Description("Testing more Options")
	@Story("more Options")
	public void moreOptions() throws InterruptedException {
		open(config.getappUrl());
		loggerextent = extentreport.createTest("TestMakeMyTripNavBar");
		loggerextent.info("Test started");
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

	@Test(priority = 3)
	@Severity(SeverityLevel.NORMAL)
	@Description("Testing Broken Links")
	@Story("Broken Links")
	public void checkBrokenLinksInFooter() {
		open(config.getappUrl());
		loggerextent = extentreport.createTest("Broken links");
		homePage.BrokenLinksList();
	}

}
