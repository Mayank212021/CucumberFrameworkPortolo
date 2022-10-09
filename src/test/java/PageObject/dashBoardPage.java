package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dashBoardPage {
	
	WebDriver ldriver;

	public dashBoardPage(WebDriver rDriver) {

		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	
	@FindBy(xpath="//a[normalize-space()='My Pages']")
	WebElement myPagesMenu;
	@FindBy(xpath="//a[normalize-space()='My profile']")
	WebElement myProfileOption;
	
	@FindBy(xpath="//a[normalize-space()='Pages']")
	WebElement pagesMenu;
	@FindBy(xpath = "//a[normalize-space()='User list']")
	WebElement userListOption;
	
	
	public void clickOnMyPagesMenu() {
		myPagesMenu.click();

		}	
		
	public void clickOnMyProfileOption() {
		myProfileOption.click();

		}	
	public void clickOnPagesMenu() {
		pagesMenu.click();

		}
	public void clickOnUserListOption() {
		userListOption.click();

		}	
	


}
