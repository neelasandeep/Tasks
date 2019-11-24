package com.epam.makeMytriptestcasesPagess;

import java.io.File;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.epam.Utilities.BrowserFactory;
import com.epam.Utilities.ConfigDataprovider;
import com.epam.Utilities.ExcelDataProvider;
import com.epam.Utilities.Helper;
import com.epam.makeMytriptestcasesPagess.FlightsFilterPage;

public class BaseClass {
	public static WebDriver driver;
	public static HomePage homePage;
	public static MakeMytripFlightsPage flightsPage;
	public static FlightsFilterPage filter;
	public ExcelDataProvider excel;
	public ConfigDataprovider config;
	public ExtentReports extentreport;
	public ExtentTest loggerextent;
	public static CheckingDealsPage checkDeals;
	public static HotelBookingPage hotelPage;
public static FlightsFilterPage filterPage;
	public static WebDriver open(String url) {
		
		System.out.println("---"+url);
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
   		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage = new HomePage(driver);
		flightsPage = new MakeMytripFlightsPage(driver);
		checkDeals = new CheckingDealsPage(driver);
		 filter=new FlightsFilterPage(driver);
		hotelPage = new HotelBookingPage(driver);
		return driver;
	}
	@DataProvider(name="browsers")
	public Object[][] getDataFromDataprovider(){
	    return new Object[][] 
	    	{
	            {config.getChrome()}
	           
	        };

	    }

	
	@BeforeMethod
	public void localSetup()  {
		driver=BrowserFactory.startBrowser();
	}

	@AfterMethod
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}

	@BeforeSuite
     public void setupSuite() {
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\resources\\log4j.properties");
		excel = new ExcelDataProvider();
	config = new ConfigDataprovider();
		ExtentHtmlReporter extentHtml = new ExtentHtmlReporter(new File(
				System.getProperty("user.dir") + "/Reports/MakeMytripHtml" + Helper.getCurrentDateTime() + ".html"));
		extentreport = new ExtentReports();
		extentreport.attachReporter(extentHtml);
	}
    @AfterMethod
	public void ScreenShotOnFailure(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.SUCCESS) {
			loggerextent.pass("test passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.ScreenShots(driver)).build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			loggerextent.skip("test skipped",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.ScreenShots(driver)).build());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			loggerextent.skip("test failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.ScreenShots(driver)).build());
		}
		extentreport.flush();
	}
	

}
