package moviebookingpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	WebDriver driver;
	BaseClass bs;
	Logger logger = Logger.getLogger(RegistrationPage.class);

	public RegistrationPage(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
		bs = new BaseClass();
	}

	@FindBy(xpath = "//form[@action='register']/input")
	WebElement registerButton;
	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//input[@value='REGISTER']")
	WebElement registerNow;

	public void clickOnRegister() {

		registerButton.click();

	}

	public void enteruserName(String userName) {

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);

	}

	public void enterPassword(String passWord) {

		password.sendKeys(passWord);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("hjgjh");
	}
	public void clickRegisterNow() {
		if (bs.waitforDisplayOfElment(registerNow, driver)) {
			registerNow.click();
		}
	}

}
