package com.epam.makeMytripTests;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.epam.Utilities.BrowserFactory;
import com.epam.makeMytriptestcasesPages.BaseClass;
import com.epam.makeMytriptestcasesPages.FlightsFilterPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class HomePageController extends BaseClass {
   WebDriver driver;
	String msg;
	List<String> urlString;
	FlightsFilterPage filterPage;
	
	@Test(priority = 1,dataProvider="browsers")
	@Severity(SeverityLevel.NORMAL)
	@Description("Testing checking flights")
	@Story("NavBar chcking")
	public void TestMakeMyTripNavBar(String browserName) throws InterruptedException, MalformedURLException {
		driver=BrowserFactory.startApplication(driver, browserName);
		open(config.getappUrl(),driver);
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
	

	@Test(priority = 2,dataProvider="browsers")
	@Severity(SeverityLevel.NORMAL)
	@Description("Testing more Options")
	@Story("more Options")
	public void moreOptions(String browserName) throws InterruptedException, MalformedURLException {
		driver=BrowserFactory.startApplication(driver, browserName);
		open(config.getappUrl(),driver);
		loggerextent = extentreport.createTest("TestMakeMyTripNavBar");
		loggerextent.info("Test started");
		msg = homePage.checkMoreOptions("mybiz");
		

		msg = homePage.checkMoreOptions("internationalflights");
		Assert.assertTrue(msg.contains("international-flights"), "error in international-flights link");

		msg = homePage.checkMoreOptions("internationalHotels");
		Assert.assertTrue(msg.contains("hotels-international"), "error in hotels-international link");

		msg = homePage.checkMoreOptions("deals");
		Assert.assertTrue(msg.contains("daily-deals/"), "error in daily-deals link");

		msg = homePage.checkMoreOptions("blogs");
		Assert.assertTrue(msg.contains("blog"), "error in blog link");

	}

	@Test(priority = 3,dataProvider="browsers")
	@Severity(SeverityLevel.NORMAL)
	@Description("Testing Broken Links")
	@Story("Broken Links")
	public void checkBrokenLinksInFooter(String browserName) throws MalformedURLException {
		driver=BrowserFactory.startApplication(driver, browserName);
		open(config.getappUrl(),driver);
		loggerextent = extentreport.createTest("Broken links");
		homePage.BrokenLinksList();
	}

}
