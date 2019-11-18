package com.epam.makeMytriptestcasesPages;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class CheckingDealsPage {

	@FindBy(xpath = "//div[@class='inputM inputHlp inputFilter']/input[@id='hp-widget__sfrom']")
	WebElement From;
//	@FindBy(xpath = "//div[@class='inputM inputHlp inputFilter']/input[@id='hp-widget__sTo']")
//	WebElement To;
	@FindBy(xpath = "//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content hp-widget__sfrom']/li/following::li")
	List<WebElement> suggest;
	@FindBy(xpath = "//input[@id='hp-widget__depart']")
	WebElement startdate;
	@FindBy(xpath = "//input[@id='hp-widget__paxCounter']")
	WebElement passenger;

	@FindBy(xpath = "//ul[@id='js-adult_counter']//li")
	List<WebElement> adult;
	@FindBy(xpath = "//ul[@id='js-child_counter']//li")
	List<WebElement> child;
	@FindBy(xpath = "//ul[@id='js-infant_counter']//li")
	List<WebElement> infant;
	@FindBy(xpath = "//button[@id='searchBtn']")
	WebElement searchBtn;

	static WebDriver driver;
	Logger logger = Logger.getLogger(CheckingDealsPage.class);

	public CheckingDealsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public WebDriver SearchInDeals(List<String> data) throws InterruptedException {
		
		String[] data1 = data.get(0).split("%");

		From.sendKeys(data1[0]);
		Thread.sleep(1000);
		From.sendKeys(Keys.ENTER);
		
		
		
		driver.findElement(By.xpath("//div[@class='inputM inputHlp inputFilter']/input[@id='hp-widget__sTo']")).sendKeys(data1[1]);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='inputM inputHlp inputFilter']/input[@id='hp-widget__sTo']")).sendKeys(Keys.ENTER);
		MakeMytripFlightsPage.waitForAD("webklipper-publisher-widget-container-notification-frame",
				"//div[@id='webklipper-publisher-widget-container-notification-close-div']");
		

		startdate.click();
		MakeMytripFlightsPage.SetDate(data1[2], "//div[@class='ui-datepicker-title']",
				"//a[contains(@class,'ui-datepicker-next ui-corner-all')]",
				"//table/tbody/tr/td/a[contains(text(),#)]");

		passenger.click();
		int adults = Integer.parseInt(data1[4].substring(0, 1));
		int childs = Integer.parseInt(data1[5].substring(0, 1));
		int infants = Integer.parseInt(data1[6].substring(0, 1));
		adult.get(adults).click();
		child.get(childs).click();
		infant.get(infants).click();
		searchBtn.click();
		return driver;

	}
	
}
