package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	WebDriver ldriver;
	public loginPage(WebDriver rDriver) {
		
		ldriver = rDriver;
		PageFactory.initElements(rDriver , this);
	}
	
	@FindBy(id="id_username")
	WebElement emailAddress;
	@FindBy(id="id_password")
	WebElement password;
	@FindBy(id="login")
	WebElement loginButton;
	
	public void enterEmail(String email)
	{
		emailAddress.clear();
		emailAddress.sendKeys(email);
	}
	public void enterPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}
	
	public void clickOnLoginButton() {
		
		loginButton.click();
	}
	

}
