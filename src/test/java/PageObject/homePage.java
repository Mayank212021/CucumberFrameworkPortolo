package PageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	
	WebDriver ldriver;
	public homePage(WebDriver rDriver) {
		
		ldriver = rDriver;
		PageFactory.initElements(rDriver , this);
	}
	
	@FindBy(id="Logout")
	WebElement logoutButton;
	
	
	
public void clickOnLogoutButton() {
		
	logoutButton.click();
	}
	

	
}
