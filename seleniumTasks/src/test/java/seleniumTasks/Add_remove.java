package seleniumTasks;




import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class Add_remove {
@Test
public void addremove() {
	String path=System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver", path+"\\src\\test\\resources\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
	for(int count=0;count<5;count++) {
	driver.findElement(By.xpath( "//button[contains(text(),'Add Element')]")).click();
	}
	
	for(int count=0;count<5;count++) {
		driver.findElement(By.xpath( "//button[contains(text(),'Delete')]")).click();
		}
}


}
