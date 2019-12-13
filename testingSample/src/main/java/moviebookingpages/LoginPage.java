package moviebookingpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	BaseClass bs;
	Logger logger = Logger.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver1) {
		driver = driver1;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;
	
	public void enterCredentials(String name,String passWord) {
		bs=new BaseClass();
		if(bs.waitforDisplayOfElment(userName, driver)) {
			userName.sendKeys(name);
		}
		if(bs.waitforDisplayOfElment(password, driver)) {
			password.sendKeys(passWord);
		}
	}
	public void clickLoginButton() {
		loginButton.click();
	}

}
