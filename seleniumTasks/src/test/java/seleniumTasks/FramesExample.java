package seleniumTasks;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesExample {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void frameExample() {
		driver.get("https://the-internet.herokuapp.com/frames");
		driver.findElement(By.xpath("//div[@class='example']/ul/li/a")).click();
		driver.switchTo().frame(0);
		driver.switchTo().frame("frame-left");
		System.out.println(driver.findElement(By.xpath("//body")).getText());
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.xpath("//body")).getText());
		driver.navigate().back();
		driver.findElement(By.xpath("//div[@class='example']/ul/li[2]/a")).click();
		driver.switchTo().frame(0);
		WebElement ele = driver.findElement(By.xpath("//body[@id='tinymce']/p"));
		ele.clear();
		ele.sendKeys("This is written by Me");
		System.out.println(driver.findElement(By.xpath("//body[@id='tinymce']/p")).getAttribute("innerHTML"));
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[@id='mceu_15-open']")).click();
		driver.findElement(By.xpath("//i[@class='mce-ico mce-i-newdocument']")).click();
		driver.switchTo().frame(0);
		Assert.assertEquals("", driver.findElement(By.xpath("//body[@id='tinymce']/p")).getText());
	}

	@Test
	public void large() {
		driver.get("https://the-internet.herokuapp.com/large");
		System.out.println(driver.findElement(By.xpath("//div[@id='sibling-36.2']")).getAttribute("innerHTML"));
		for (int row = 1; row < 10; row++) {
			for (int i = 1; i < 10; i++) {
				System.out.print(
						driver.findElement(By.xpath("//tr[@class='row-" + row + "']/td[" + i + "]")).getText() + " ");
			}
			System.out.println();
		}
	}

	@Test
	public void typo() {
		driver.get("https://the-internet.herokuapp.com/typos");
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {

			WebElement ele = null;

			public WebElement apply(WebDriver driver) {
				driver.navigate().refresh();
				ele = driver.findElement(By.xpath("//div[@class='example']/p[2]"));
				String msg = ele.getText();
				if (msg.contains("won,t")) {
					return ele;
				} else {
					System.out.println(msg);
					return null;

				}
			}
		});
		System.out.println(element.getText());
	}

	@Test
	public void inputnumber() {
		driver.get("https://the-internet.herokuapp.com/inputs");
		WebElement test = driver.findElement(By.xpath("//div[@class='example']//input"));
		test.sendKeys(String.valueOf(12));
		for (int i = 0; i < 5; i++) {
			test.sendKeys(Keys.ARROW_UP);
		}

		test.sendKeys(Keys.ARROW_DOWN);

		Assert.assertEquals(test.getAttribute("value"), "16");

	}

	@Test
	public void location() throws InterruptedException {
		

		driver.get("https://the-internet.herokuapp.com/geolocation");
		 driver.findElement(By.xpath("//div[@class='example']/button")).click();
		 Thread.sleep(4000);
	    String Lat= driver.findElement(By.xpath("//div[@id='lat-value']")).getAttribute("innerHTML");
		String Lang= driver.findElement(By.xpath("//div[@id='long-value']")).getAttribute("innerHTML");
		System.out.println(Lat+","+Lang);
		driver.findElement(By.xpath("//div[@id='map-link']/a")).click();
		String pos=driver.findElement(By.xpath("//input[@id='searchboxinput']")).getAttribute("value");
		System.out.println(pos);
		Assert.assertEquals(pos, Lat+","+Lang);
	}
	@Test
	public void statuscode() {
		driver.get("https://the-internet.herokuapp.com/status_codes");
		for (int counter=1; counter < 5;counter++) {
			String msg=driver.findElement(By.xpath("//div[@id='content']//ul/li["+counter+"]/a")).getAttribute("innerHTML");
			 driver.findElement(By.xpath("//div[@id='content']//ul/li["+counter+"]/a")).click();
			 //System.out.println(msg);
			 Assert.assertTrue(driver.findElement(By.xpath("//div[@class='example']/p")).getAttribute("innerHTML").contains(msg));
			driver.findElement(By.linkText("here")).click();
			 
		}
	}
	@Test
	public void window() {
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> allwindow = driver.getWindowHandles();
		int window=0;
		for(String eachwindow:allwindow)

		{
			 window++;
			 if(window==2)
				 Assert.assertEquals(driver.switchTo().window(eachwindow).getTitle(),"New Window");
		
			 System.out.println(driver.switchTo().window(eachwindow).getTitle());
	
		

		}
	}
	@Test
	public void notification() {
		driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
		
			driver.findElement(By.linkText("Click here")).click();
			Assert.assertTrue(driver.findElement(By.xpath("//div[@id='flash']")).isDisplayed());
				String msg1=driver.findElement(By.xpath("//div[@id='flash']")).getText();
				System.out.println(msg1);
				
			
			
		
		
	}
}
