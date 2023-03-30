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
	@FindBy(id="SignInButton")
	WebElement signinButton;
	@FindBy(id="id_username1")
	WebElement emailAddress;
	@FindBy(id="id_password1")
	WebElement password;
	@FindBy(id="login1")
	WebElement loginButton;
	
	
	public void clickonSigninButton() {
		
		signinButton.click();
	}
	
	
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
