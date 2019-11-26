package com.epam.makeMytriptestcasesPagess;

import java.io.File;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

import cucumber.api.java.After;

public class BaseClass {
	public  WebDriver driver;
	
	public  MakeMytripFlightsPage flightsPage;
	public  FlightsFilterPage filter;
	//public ExcelDataProvider excel;
	public ConfigDataprovider config;
	public ExtentReports extentreport;
	public ExtentTest loggerextent;
	public  CheckingDealsPage checkDeals;
	
public FlightsFilterPage filterPage;
public Helper helper;
public static WebDriver driver2;
	public  WebDriver open(String url) {
//         System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
//		
//		driver=new ChromeDriver();
//		
		driver=BrowserFactory.startBrowser();
		System.out.println("---"+url);
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
   		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		flightsPage = new MakeMytripFlightsPage(driver);
		checkDeals = new CheckingDealsPage(driver);
		 filter=new FlightsFilterPage(driver);
		
		
		driver2=driver;
		System.out.println(driver);
		return  driver;
		
	}
	@DataProvider(name="browsers")
	public Object[][] getDataFromDataprovider(){
	    return new Object[][] 
	    	{
	            {config.getChrome()}
	           
	        };

	    }

	


//	@AfterMethod
//	public void tearDown() {
//		BrowserFactory.quitBrowser(driver);
//	}

	@BeforeSuite
     public void setupSuite() {
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\resources\\log4j.properties");
		//excel = new ExcelDataProvider();
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
						MediaEntityBuilder.createScreenCaptureFromPath( Helper.ScreenShots(driver2)).build());
			} else if (result.getStatus() == ITestResult.SKIP) {
				loggerextent.skip("test skipped",
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.ScreenShots(driver2)).build());
			} else if (result.getStatus() == ITestResult.FAILURE) {
				loggerextent.skip("test failed",
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.ScreenShots(driver2)).build());
			}
			extentreport.flush();
		}
	
	

}
