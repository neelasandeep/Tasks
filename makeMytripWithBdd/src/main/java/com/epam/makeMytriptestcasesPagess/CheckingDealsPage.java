package com.epam.makeMytriptestcasesPagess;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

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
	@FindBy(xpath = "//li[@data-cy='menu_More']")
	WebElement more;
	@FindBy(xpath = "//li[@data-cy='menu_More']/div/a")
	List<WebElement> moreOptions;
	static WebDriver driver;
	String parentwindow = "";
	Logger logger = Logger.getLogger(CheckingDealsPage.class);

	public CheckingDealsPage(WebDriver driver1) {

		driver = driver1;
		PageFactory.initElements(driver, this);

	}

//	public void enterIntoDeals() {
//		more.click();
//		parentwindow = driver.getWindowHandle();
//		moreOptions.get(3).click();
//		Set<String> allwindow = driver.getWindowHandles();
//
//		for (String handle : allwindow) {
//			if (!handle.equals(parentwindow)) {
//				driver.switchTo().window(handle);
//			}
//		}
//	}

	public WebDriver SearchInDeals(List<String> data) throws InterruptedException {
		//Thread.sleep(60000);
		String[] data1 = data.get(0).split("%");
	
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		
		WebElement closeAd = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				
				return driver.findElement(By.xpath("//div[@class='inputM inputHlp inputFilter']/input[@id='hp-widget__sfrom']"));
			}
		});
		closeAd.sendKeys(data1[0]);
		Thread.sleep(1000);
		closeAd.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//div[@class='inputM inputHlp inputFilter']/input[@id='hp-widget__sTo']"))
				.sendKeys(data1[1]);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='inputM inputHlp inputFilter']/input[@id='hp-widget__sTo']"))
				.sendKeys(Keys.ENTER);
		try {
			MakeMytripFlightsPage.waitForAD("webklipper-publisher-widget-container-notification-frame",
					"//div[@id='webklipper-publisher-widget-container-notification-close-div']");
		} catch (Exception e1) {
			
			logger.info("no adds proceed");
		}

		startdate.click();
		try {
			MakeMytripFlightsPage.SetDate(data1[2], "//div[@class='ui-datepicker-title']",
					"//a[contains(@class,'ui-datepicker-next ui-corner-all')]",
					"//table/tbody/tr/td/a[contains(text(),#)]");
		} catch (Exception e) {
			
		logger.info("proceed");
		}

		passenger.click();
		int adults = Integer.parseInt(data1[4].substring(0, 1));
		int childs = Integer.parseInt(data1[5].substring(0, 1));
		int infants = Integer.parseInt(data1[6].substring(0, 1));
		adult.get(adults).click();
		child.get(childs).click();
		infant.get(infants).click();
		
		return driver;

	}
	public void dealsSearch() {
		searchBtn.click();
	}

}
