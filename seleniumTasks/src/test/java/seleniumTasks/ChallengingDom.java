package seleniumTasks;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChallengingDom {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void challengingDom() {

		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/challenging_dom");

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			boolean type = false;
			WebElement ele = null;

			public WebElement apply(WebDriver driver) {

				driver.findElement(By.xpath("//a[@class='button']")).click();

				ele = driver.findElement(By.xpath("//a[@class='button success']"));
				type = ele.getText().equalsIgnoreCase("qux");
				System.out.println(ele.getText());
				if (!type) {

					return null;
				} else {
					return ele;
				}

			}
		});

//		while(!type) {
//			
//			System.out.println(driver.findElement(By.xpath("//tr[9]//td[6]")).getText());
//			driver.findElement(By.xpath("//a[@class='button']")).click();
//			 ele=driver.findElement(By.xpath("//a[@class='button success']"));
//			type=ele.getText().equalsIgnoreCase("qux");
//			System.out.println(ele.getText());
//		}
		Assert.assertEquals("qux", element.getText());

	}

	@Test
	public void checkBox() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		checkbox.click();
		WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
		if (checkbox2.isEnabled()) {
			Thread.sleep(5000);
			checkbox2.click();
		}
	}

	@Test
	public void dropdown() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/dropdown");
		WebElement checkbox = driver.findElement(By.xpath("//select[@id='dropdown']/child::option[2]"));
		checkbox.click();
		Thread.sleep(3000);
		Select msg = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
		System.out.println(msg.getFirstSelectedOption().getText());

	}

}
