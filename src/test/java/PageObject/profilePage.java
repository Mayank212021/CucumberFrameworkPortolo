package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class profilePage {
	
	WebDriver ldriver;
	public profilePage(WebDriver rDriver) {
		
		ldriver = rDriver;
		PageFactory.initElements(rDriver , this);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-outline-warning']")
	WebElement editButton;
	
	public void clickOnEditButton() {
		editButton.click();
		
	}
	

}
