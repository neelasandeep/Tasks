package com.epam.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.epam.makemytriptestcasespagess.BaseClass;

import io.qameta.allure.Attachment;

public class AllureReportListener  implements ITestListener {

	WebDriver driver;
	Logger logger = Logger.getLogger(AllureReportListener.class);

	@Attachment(value = "Page ScreenShot", type = "image/png")
	public byte[] saveScreenShotPNG(WebDriver driver) {

		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

	}

	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}

	@Override
	public void onTestFailure(ITestResult result) {

		if (driver instanceof WebDriver) {
			logger.info("ScreenShot Captured For Failed TestCase" + result.getName());
			saveScreenShotPNG(driver);
			saveTextLog("failed and screenshot taken" + result.getName());
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		logger.info("Falied but within succes percentage TestCase" + result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Skipped TestCase" + result.getName());

	}

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Starting TestCase" + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		driver = new BaseClass().getDriver();
		logger.info("Testpass method");
		
		if (driver instanceof WebDriver) {
			logger.info("ScreenShot Captured For Success TestCase" + result.getName());
			saveScreenShotPNG(driver);
			saveTextLog("Test Success and screenshot taken" + result.getName());
		}
	}

	@Override
	public void onStart(ITestContext context) {
		

		logger.info("Starting TestCase" + context.getName());

	}

	@Override
	public void onFinish(ITestContext context) {

		logger.info("Finishing TestCase" + context.getName());
		

	}
}
