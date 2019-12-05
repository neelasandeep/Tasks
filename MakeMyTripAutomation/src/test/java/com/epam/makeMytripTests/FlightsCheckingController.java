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

public class FlightsCheckingController extends BaseClass{
	
	
	WebDriver driver;
	FlightsFilterPage filterPage;
	List<String> urlString;
	@Test(priority = 1,dataProvider="browsers")
	@Severity(SeverityLevel.NORMAL)
	@Description("Testing checking flights")
	@Story("flights chcking")
	public void checckFlights(String browserName) throws InterruptedException, MalformedURLException {
		//driver=BrowserFactory.startApplication(driver, browserName);
		driver=BrowserFactory.startBrowser();
     open(config.getappUrl(),driver);
		loggerextent = extentreport.createTest("checkflights");
		urlString = excel.getStringData(1);
		flightsPage.checkFlights(urlString);
		
		

	}
	@Test(priority = 7,dataProvider="browsers")
	@Severity(SeverityLevel.NORMAL)
	@Description("Testing Deals page")
	@Story("Deals page")
	public void checkingInDeals(String browserName) throws InterruptedException, MalformedURLException{
		driver=BrowserFactory.startApplication(driver, browserName);
		 open("https://www.makemytrip.com/daily-deals/",driver);
		loggerextent = extentreport.createTest("checking Deals");
		urlString = excel.getStringData(5);
		
		 
		 driver=checkDeals.SearchInDeals(urlString);
		 
	}
	@Test(priority =2,dataProvider="browsers")
	@Severity(SeverityLevel.NORMAL)
	@Description("Testing Filters i flights Booking")
	@Story("Filters  page")
	public void applyFilters(String browserName) throws InterruptedException, MalformedURLException{
		checckFlights(browserName);
		urlString = excel.getStringData(2);

		filterPage = new FlightsFilterPage(driver);
		filterPage.applyFilters(urlString);
	}
	@Test(priority =3,dataProvider="browsers")
	@Severity(SeverityLevel.NORMAL)
	@Description("Testing Furthur review procedure")
	@Story("review procedure")
	public void proceedToBook(String browserName) throws InterruptedException, MalformedURLException{
		applyFilters(browserName);
		String status=filterPage.proceedToBook(2);
		System.out.println(status);
		Assert.assertEquals(status, "OK");
	}
	@Test(priority=4,dataProvider="browsers")
	@Severity(SeverityLevel.NORMAL)
	@Description("Testing Progress Bar")
	@Story("Progress Bar")
	public void checkProgressbar(String browserName)  throws InterruptedException, MalformedURLException{
		proceedToBook(browserName);
		String status=filterPage.checkProgressBar();
		Assert.assertEquals(status, "OK");

	}
	@Test(priority = 5,dataProvider="browsers")
	@Severity(SeverityLevel.NORMAL)
	@Description("reviewing and continue furthur")
	@Story("Review Furthur")
	public void reviewAndContinue(String browserName) throws InterruptedException, MalformedURLException{
		checkProgressbar(browserName);
		String url=filterPage.reviewDetails();
		Assert.assertTrue(url.contains("flight/traveller"));
		
	}
	@Test(priority = 6,dataProvider="browsers")
	@Severity(SeverityLevel.NORMAL)
	@Description("Fill User data")
	@Story("userdata Filling")
	public void FillUserdata(String browserName) throws InterruptedException, MalformedURLException{
		reviewAndContinue(browserName);
		filterPage.fillUserDetails();
	}
}
