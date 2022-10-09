package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class editProfilePage {

	WebDriver ldriver;

	public editProfilePage(WebDriver rDriver) {

		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(name = "city")
	WebElement city;

	@FindBy(xpath = "//input[@id='Saveid']")
	WebElement applyButton;

	public void enterNewCity(String newcity) {

		city.clear();
		city.sendKeys(newcity);
	}

	public void clickOnApplyButton() {

		applyButton.click();

	}
	
	public String getTextofCity() { 
		
		return(city.getText());
	}

}
