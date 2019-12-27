package com.epam.makemytriptestcasespagess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

public class FlightsFilterPage extends BaseClass {
	WebDriver driver1;
	
	String deptimeBefore;
	public FlightsFilterPage(WebDriver driver) {
		driver1 = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class=\"filter-arw\"]")
	WebElement morefilters;
	@FindBy(xpath = "//div[@class='rc-slider-step']")
	WebElement slider;
	@FindBy(xpath = "//a[@id='extended-filter-apply']")
	WebElement filterApply;
	@FindBy(xpath = "//span[@class='down sort-arrow']")
	WebElement priceSorter;
	@FindBy(xpath = "//div[@class='fli-list one-way']//div[@class='pull-left  make_relative price']/p")
	List<WebElement> prices;
	@FindBy(xpath = "//div[@class='fli-list one-way']//button")
	List<WebElement> proceedToBook;
	@FindBy(xpath = "//div[@class='dept-time']")
	List<WebElement> departureTime;
	@FindBy(xpath = "//div[@class='dept-time append_bottom3 make_relative']")
	WebElement departuretimeafter;
	@FindBy(xpath = "//span[@class='numbering onpage']")
	@CacheLookup
	WebElement progressbar;
	@FindBy(xpath = "//button[@id='review-continue']")
	WebElement continueToPay;
	@FindBy(xpath = "//input[@value='yes']")

	WebElement terms;
	@FindBy(xpath = "//a[@class='font14 LatoBold text-uppercase paddLR15']")
	WebElement adult;
	@FindBy(xpath = "")
	WebElement male;
	@FindBy(xpath = "//input[@placeholder='Mobile No']")
	WebElement mobile;

	List<Double> beforesort = new ArrayList<>();
	List<Double> aftersort = new ArrayList<>();
	List<String> personal;

	public void applyFilters(List<String> data) throws InterruptedException {

		personal = data;
		morefilters.click();
		sleep(1000);
		Dimension dim = slider.getSize();
		int x = dim.getWidth();
		Actions actions = new Actions(driver1);
		actions.clickAndHold(slider).moveByOffset(x - 350, 0).release().build().perform();
        
		filterApply.click();
		for (int i = 0; i < prices.size(); i++) {
			String price = prices.get(i).getText();
			beforesort.add(Double.parseDouble(price.substring(2, price.length()).replace(",", "")));
		}
		sleep(1000);
		priceSorter.click();
		for (int i = 0; i < prices.size(); i++) {
			String price = prices.get(i).getText();
			aftersort.add(Double.parseDouble(price.substring(2, price.length()).replace(",", "")));
		}
		Collections.reverse(aftersort);
		logger.info(aftersort);
		

	}
	public void selectFlight(int flight) {
		deptimeBefore = departureTime.get(flight).getText();
		
		proceedToBook.get(flight).click();
		
	}

	public String reviewDetails(WebDriver driver){
		String departureTimeOnnextpage;
		String status = "NotOk";
		

		Set<String> allwindow = driver.getWindowHandles();
		logger.info(allwindow.size());
		int i = 0;
		for (String handle : allwindow) {
			i++;
			
			if (!handle.equalsIgnoreCase(driver.getWindowHandle()) && i == allwindow.size()) {
				driver.switchTo().window(handle);
				departureTimeOnnextpage = departuretimeafter.getText();
				logger.info(departureTimeOnnextpage);
				if (deptimeBefore.equals(departureTimeOnnextpage)) {
					status = "OK";
				}

			} else {
				logger.info("parent" + " " + i);
			}

		}
		return status;
	}

	public String checkProgressBar() {
		String status = "NotOk";
		if (progressbar.getText().equals("2")) {
			status = "OK";
		}
		return status;
	}

	public void acceptTermsAndConditions() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver1;

		js.executeScript("arguments[0].scrollIntoView();", continueToPay);

		if (!driver1.findElements(By.xpath("//input[@value='yes']")).isEmpty()) {
			terms.click();
		}

		sleep(1000);

		driver1.findElement(By.xpath("//button[@id='review-continue']")).click();
		sleep(1000);
		
	
	}
	

	public void fillUserDetails() throws InterruptedException {
		sleep(1000);
		adult.click();

		String[] data = personal.get(0).split("%");

		sleep(1000);
		driver1.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(data[3]);
		driver1.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(data[2]);
		driver1.findElement(By.xpath("//div[@class='collapse in']//label[1]")).click();
		driver1.findElement(By.xpath("//input[@placeholder='Mobile No']")).sendKeys("9515746150");
		driver1.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(data[1]);
		sleep(2000);
		driver1.findElement(By.xpath("//button[@class='ack-cta btn fli_primary_btn text-uppercase']")).click();

	}

}
