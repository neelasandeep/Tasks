package com.epam.makemytriptestcasespagess;

import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
	
	
	MakeMytripFlightsPage flightspageObject;
	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		flightspageObject=new MakeMytripFlightsPage(driver);
	}

	String url = "";
	String parentwindow = "";
	@FindBy(xpath = "//nav/ul/li")
	List<WebElement> flights;
	@FindBy(xpath = "//li[@data-cy='menu_More']")
	WebElement more;
	@FindBy(xpath = "//li[@data-cy='menu_More']/div/a")
	List<WebElement> moreOptions;
	
	public List<String> checkNavbarAction() throws InterruptedException {
		try {
			flightspageObject.waitForAD("webklipper-publisher-widget-container-notification-frame",
					"//a[@id='webklipper-publisher-widget-container-notification-close-div']");
		} catch (Exception e) {
			
			logger.info("Ok no frame proceed");
		}
		List<String> urls = new ArrayList<>();
		for (int element = 0; element < flights.size(); element++) {

			flights.get(element).click();

			if (element == 8) {
				sleep(10000);
				urls.add(driver.getCurrentUrl());
				driver.navigate().back();
			} else {
				urls.add(driver.getCurrentUrl());
			}
		}
		logger.info(urls.size());
		return urls;

	}

	public String checkMoreOptions(String choice)  {

		more.click();

		if (choice.equalsIgnoreCase("mybiz")) {
			moreOptions.get(0).click();
             
			url = driver.getCurrentUrl();

			driver.navigate().back();

		} else if (choice.equalsIgnoreCase("internationalflights")) {
			moreOptions.get(1).click();

			url = driver.getCurrentUrl();

		} else if (choice.equalsIgnoreCase("internationalHotels")) {
			moreOptions.get(2).click();

			url = driver.getCurrentUrl();
		} else if (choice.equalsIgnoreCase("deals")) {
			parentwindow = driver.getWindowHandle();
			moreOptions.get(3).click();
			windowHandles();
			driver.switchTo().window(parentwindow);

		} else if (choice.equalsIgnoreCase("blogs")) {
			parentwindow = driver.getWindowHandle();
			moreOptions.get(4).click();
			windowHandles();
			driver.switchTo().window(parentwindow);
		}
		return url;
	}

	private void windowHandles()  {
		Set<String> allwindow = driver.getWindowHandles();

		for (String handle : allwindow) {
			if (!handle.equals(parentwindow)) {
				driver.switchTo().window(handle);

				url = driver.getCurrentUrl();
				driver.close();
			}
		}
	}

	public void brokenLinksList() {
		try {
			flightspageObject.waitForAD("webklipper-publisher-widget-container-notification-frame",
					"//a[@id='webklipper-publisher-widget-container-notification-close-div']");
		} catch (Exception e) {
			logger.info("Ok no frame proceed");
		}
		List<WebElement> divisions = driver.findElements(By.xpath("//footer[@class='appendTop30']//ul"));

		for (int linkList = 1; linkList <= divisions.size(); linkList++) {
			List<WebElement> links = driver
					.findElements(By.xpath("//footer[@class='appendTop30']//ul[" + linkList + "]/li/a"));
			checkbrokenlist(links);
		}

	}

	public void checkbrokenlist(List<WebElement> links) {

		for (int link = 0; link < links.size(); link++) {
			WebElement ele = links.get(link);
			 url = ele.getAttribute("href");
			verify(url);
		}

	}

	public void verify(String url) {
		try {
			URL urllink = new URL(url);

			HttpURLConnection http = (HttpURLConnection) urllink.openConnection();
			http.setConnectTimeout(5000);
			http.connect();
			if (http.getResponseCode() == 200) {
				logger.info(url + "-" + http.getResponseMessage());
			} else {
				logger.info(url + "-" + http.getResponseMessage() + "-" + HttpURLConnection.HTTP_NOT_FOUND);
			}

		}  catch (IOException e) {

			logger.info("url is broken");
		}

	}

}
