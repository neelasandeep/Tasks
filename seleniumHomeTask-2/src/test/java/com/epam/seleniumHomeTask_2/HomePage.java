package com.epam.seleniumHomeTask_2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class HomePage {
	WebDriver driver;
	Logger logger=Logger.getLogger(HomePage.class);
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	String url = "";
	String parentwindow = "";
	@FindBy(xpath = "//li[@data-cy='menu_Flights']/a")
	WebElement Flights;
	@FindBy(xpath = "//li[@data-cy='menu_Hotels']/a")
	WebElement hotels;
	@FindBy(xpath = "//li[@data-cy='menu_VillasApts']/a")
	WebElement VillaAppts;
	@FindBy(xpath = "//li[@data-cy='menu_Holidays']/a")
	WebElement Holidays;
	@FindBy(xpath = "//li[@data-cy='menu_Trains']/a")
	WebElement trains;
	@FindBy(xpath = "//li[@data-cy='menu_Buses']/a")
	WebElement Bus;
	@FindBy(xpath = "//li[@data-cy='menu_Cabs']/a")
	WebElement cab;
	@FindBy(xpath = "//li[@data-cy='menu_Visa']/a")
	WebElement visa;
	@FindBy(xpath = "//li[@data-cy='menu_Giftcards']/a")
	WebElement giftcard;
	@FindBy(xpath = "//li[@data-cy='menu_More']/a")
	WebElement more;
	@FindBy(xpath = "//li[@data-cy='menu_More']/div/a[1]")
	WebElement mybiz;
	@FindBy(xpath = "//li[@data-cy='menu_More']/div/a[2]")
	WebElement internationalFlights;
	@FindBy(xpath = "//li[@data-cy='menu_More']/div/a[3]")
	WebElement internationalHotels;
	@FindBy(xpath = "//li[@data-cy='menu_More']/div/a[4]")
	WebElement deals;
	@FindBy(xpath = "//li[@data-cy='menu_More']/div/a[5]")
	WebElement blogs;

	public String checkFlightNavbarAction() throws InterruptedException {

		Flights.click();
		Thread.sleep(500);
		return driver.getCurrentUrl();

	}

	public String checkHotelNavbarAction() throws InterruptedException {
		hotels.click();
		Thread.sleep(500);
		return driver.getCurrentUrl();
	}

	public String checkVillaApptsNavbarAction() throws InterruptedException {
		VillaAppts.click();
		Thread.sleep(500);
		return driver.getCurrentUrl();
	}

	public String checkHolidaysNavbarAction() throws InterruptedException {
		Holidays.click();
		Thread.sleep(500);
		return driver.getCurrentUrl();
	}

	public String checktrainsNavbarAction() throws InterruptedException {
		trains.click();
		Thread.sleep(500);

		return driver.getCurrentUrl();
	}

	public String checkBusNavbarAction() throws InterruptedException {
		Bus.click();
		Thread.sleep(500);
		return driver.getCurrentUrl();
	}

	public String checkCabNavbarAction() throws InterruptedException {
		cab.click();
		Thread.sleep(500);
		return driver.getCurrentUrl();
	}

	public String checkVisaNavbarAction() throws InterruptedException {
		visa.click();
		Thread.sleep(500);
		return driver.getCurrentUrl();
	}

	public String checkGiftcardNavbarAction() throws InterruptedException {

		giftcard.click();
		Thread.sleep(500);
		url = driver.getCurrentUrl();
		driver.navigate().back();
		return url;
	}

	public String checkMoreOptions(String choice) throws InterruptedException {
		more.click();

		Thread.sleep(500);
		if (choice.equalsIgnoreCase("mybiz")) {
			mybiz.click();
			Thread.sleep(500);
			url = driver.getCurrentUrl();

			driver.navigate().back();

		} else if (choice.equalsIgnoreCase("internationalflights")) {
			internationalFlights.click();
			Thread.sleep(500);
			url = driver.getCurrentUrl();

		} else if (choice.equalsIgnoreCase("internationalHotels")) {
			internationalHotels.click();
			Thread.sleep(500);
			url = driver.getCurrentUrl();
		} else if (choice.equalsIgnoreCase("deals")) {
			parentwindow = driver.getWindowHandle();
			deals.click();
			windowHandles();
			driver.switchTo().window(parentwindow);

			System.out.println(url);

		} else if (choice.equalsIgnoreCase("blogs")) {
			parentwindow = driver.getWindowHandle();
			blogs.click();
			windowHandles();
			driver.switchTo().window(parentwindow);
		}
		return url;
	}

	private void windowHandles() throws InterruptedException {
		Set<String> allwindow = driver.getWindowHandles();
		Thread.sleep(500);
		for (String handle : allwindow) {
			if (!handle.equals(parentwindow)) {
				driver.switchTo().window(handle);
				Thread.sleep(1000);
				url = driver.getCurrentUrl();
				driver.close();
			}
		}
	}

	public void BrokenLinksList() {
 
		for (int linkList = 1; linkList <=6; linkList++) {
			List<WebElement> links = driver
					.findElements(By.xpath("//footer[@class='appendTop30']//ul[" + linkList + "]/li/a"));
		checkbrokenlist(links);
		}

	}

	public void checkbrokenlist(List<WebElement> links) {
		PropertyConfigurator.configure("C:\\Users\\NEELA\\OneDrive\\Desktop\\Tasks\\seleniumHomeTask-2\\resources\\log4j.properties");
		 
     System.out.println(links.size());
     for(int link=0;link<links.size();link++) {
    	 WebElement ele=links.get(link);
    	 String url=ele.getAttribute("href");
    	 verify(url);
     }
    
    	
	}
	public void verify(String url) {
		try {
			URL urllink=new URL(url);
		
				HttpURLConnection http=(HttpURLConnection) urllink.openConnection();
				http.setConnectTimeout(5000);
				http.connect();
				if(http.getResponseCode()==200) {
					logger.info(url+"-"+http.getResponseMessage());
					//System.out.println(url+"-"+http.getResponseMessage());
					}
				else {
					logger.info(url+"-"+http.getResponseMessage()+"-"+http.HTTP_NOT_FOUND);
					//System.out.println(url+"-"+http.getResponseMessage()+"-"+http.HTTP_NOT_FOUND);
				}
	
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (java.net.ProtocolException e) {
			// TODO Auto-generated catch block
			//System.out.println("server problem");
			logger.info("server problem");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
