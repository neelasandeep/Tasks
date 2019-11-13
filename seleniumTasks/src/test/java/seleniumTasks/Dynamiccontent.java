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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dynamiccontent {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void dynamicContent() {
		driver.get("https://the-internet.herokuapp.com/dynamic_content");
		driver.findElement(By.linkText("click here")).click();
		int count = 0;
		for (int counter = 0; counter < 5; counter++) {
			String data2 = driver.findElement(By.xpath("//div[@id=\"content\"]/div[3]/div[2]")).getText();
			driver.findElement(By.xpath("//a[contains(text(),\'click here\')]")).click();
			String data1 = driver.findElement(By.xpath("//div[@id=\"content\"]/div[3]/div[2]")).getText();
			if (!data2.equals(data1)) {
				System.out.println(data1);
				count++;
			}
		}
		Assert.assertEquals(5, count);

	}

	@Test
	public void dynamicLoading() {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading");
		driver.findElement(By.xpath("//a[contains(text(),'Example 1')]")).click();
		WebElement element = getMessage();
		Assert.assertEquals("Hello World!", element.getText());
		driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading");
		driver.findElement(By.xpath("//a[contains(text(),'Example 2')]")).click();
		WebElement element2 = getMessage();
		Assert.assertEquals("Hello World!", element2.getText());

	}

	private WebElement getMessage() {
		driver.findElement(By.xpath("//div[@id=\"start\"]/button")).click();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {

			WebElement ele = null;

			public WebElement apply(WebDriver driver) {

				ele = driver.findElement(By.xpath("//div[@id=\"finish\"]/h4"));

				String msg = ele.getText();

				if (msg.equals("Hello World!")) {
					System.out.println(msg);
					return ele;
				} else {

					return null;
				}
			}
		});
		return element;
	}
}
