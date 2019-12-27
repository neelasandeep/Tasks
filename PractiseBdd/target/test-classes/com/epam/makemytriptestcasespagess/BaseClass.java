package com.epam.makemytriptestcasespagess;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeSuite;

import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.epam.utilities.BrowserFactory;
import com.epam.utilities.ConfigDataprovider;
import com.epam.utilities.ExcelDataProvider;
import com.epam.utilities.Helper;

public class BaseClass {
	protected WebDriver driver;
	static WebDriver tdriver;
	protected HomePage homePage;
	protected MakeMytripFlightsPage flightsPage;
	protected FlightsFilterPage filter;
	protected ExcelDataProvider excel;
	protected ConfigDataprovider config;
	protected ExtentReports extentreport;
	protected ExtentTest loggerextent;
	protected CheckingDealsPage checkDeals;
	protected HotelBookingPage hotelPage;
	protected FlightsFilterPage filterPage;
	protected List<String> urlString;
	protected Logger logger = Logger.getLogger(BaseClass.class);

	public WebDriver open(String url) {
		driver = BrowserFactory.startBrowser();
		setDriver(driver);
		logger.info("---" + url);
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage = new HomePage(driver);

		
		hotelPage = new HotelBookingPage(driver);

		return driver;
	}

	public static void setDriver(WebDriver driver) {
		tdriver = driver;
	}

	public WebDriver getDriver() {
		return tdriver;
	}

	public void sleep(int time) throws InterruptedException {

		Thread.sleep(time);

	}

	@DataProvider(name = "browsers")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] { { config.getChrome() }

		};

	}

	public void homeFlights() throws InterruptedException {
		driver = open(config.getappUrl());
		flightsPage = new MakeMytripFlightsPage(driver);
		urlString = excel.getStringData(1);
		flightsPage.checkFlights(urlString);
		flightsPage.search();
		filter = new FlightsFilterPage(driver);
	}

	public void dealsPageFlights() throws InterruptedException {
		driver = open("https://www.makemytrip.com/daily-deals/");
		checkDeals = new CheckingDealsPage(driver);
		urlString = excel.getStringData(5);
		checkDeals.searchInDeals(urlString);
		checkDeals.dealsSearch();
		filter = new FlightsFilterPage(driver);
	}

	@BeforeSuite
	public void setupSuite() {
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/main/java/resources/log4j.properties");
		excel = new ExcelDataProvider();
		config = new ConfigDataprovider();
		ExtentHtmlReporter extentHtml = new ExtentHtmlReporter(new File(
				System.getProperty("user.dir") + "/target/Reports/MakeMytripHtml" + Helper.getCurrentDateTime() + ".html"));
		extentreport = new ExtentReports();
		extentreport.attachReporter(extentHtml);
	}

	@AfterMethod
	public void screenShotOnFailure(ITestResult result) throws IOException {
		logger.info("entered into screen");
		loggerextent = extentreport.createTest(result.getName());
		if (result.getStatus() == ITestResult.SUCCESS) {
			loggerextent.pass("test passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.screenShots(tdriver)).build());

		} else if (result.getStatus() == ITestResult.SKIP) {
			loggerextent.skip("test skipped",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.screenShots(tdriver)).build());

		} else if (result.getStatus() == ITestResult.FAILURE) {
			loggerextent.skip("test failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.screenShots(tdriver)).build());

		}
		extentreport.flush();

	}

	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}

}
