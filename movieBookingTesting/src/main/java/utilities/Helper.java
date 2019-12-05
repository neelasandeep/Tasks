package utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class Helper{
	static Logger logger = Logger.getLogger(Helper.class);

	public static String ScreenShots(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         String screenshotpath=System.getProperty("user.dir")+"/ScreenShots/Testmakemytrip"+getCurrentDateTime()+".png";
		try {
			FileHandler.copy(src, new File(screenshotpath));
			logger.info("Screenshot Captured");
		} catch (Exception e) {
			logger.warn("Unable to take Screenshot", e);
		}
		return screenshotpath;
	}
	public static String getCurrentDateTime() {
		DateFormat format=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date=new Date();
		return format.format(date);
	}
}
