package utilities.listeners;

import io.qameta.allure.Attachment;
import moviebookingpages.BaseClass;


import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class TestListenerr extends BaseClass implements ITestListener {
 ExtentHtmlReporter htmlreporter;
 ExtentReports extent;
  ExtentTest test;
 Logger logger = Logger.getLogger(TestListenerr.class);
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

   
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG (WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog (String message) {
        return message;
    }

   
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    	htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/src/main/java/ExtentReports/myReport.html");
        logger.info("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", this.driver);
        htmlreporter.config().setDocumentTitle("Automation Report");
        htmlreporter.config().setReportName("RestAssured Report");
        extent=new ExtentReports();
        extent.attachReporter(htmlreporter);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    	 logger.info("I am in onFinish method " + iTestContext.getName());
       
        extent.flush();
      
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
    	 logger.info("I am in onTestStart method " +  getTestMethodName(iTestResult) + " start");
       
      
       
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    	 logger.info("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
       
        test=extent.createTest(iTestResult.getName());
     test.log(Status.PASS, "test passed"+iTestResult.getName()); 
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
    	 logger.info("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed");
        test=extent.createTest(iTestResult.getName());
        test.log(Status.FAIL, "test failed"+iTestResult.getName()); 
//        
       
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    	 logger.info("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
       
        test=extent.createTest(iTestResult.getName());
        test.log(Status.SKIP, "test skipped"+iTestResult.getName()); 
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    	 logger.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

}