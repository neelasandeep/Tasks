package seleniumTasks;

import java.time.Duration;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChallengingDom {
	@Test
	public void challengingDom() {

		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
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

}
