package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userListPage {
	WebDriver ldriver;

	public userListPage(WebDriver rDriver) {

		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(id = "email")
	WebElement emailaddress;

	@FindBy(xpath = "//i[@class='fa-solid fa-magnifying-glass']")
	WebElement searchButton;
	
	@FindBy(xpath = "//div[@class='card']//div//div//tr")
	List<WebElement> tableRows;
	
	@FindBy(xpath = "//div[@class='card']//div//div//tr[1]//td")
	List<WebElement> tableColumns;
	

	public void enterEmail(String email) {

		emailaddress.sendKeys(email);
	}

	public void clickOnSearchButton() {

		searchButton.click();
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	
 public boolean searchUserByEmail(String email){
		
		boolean found = false;
		//total number of rows
		int totalRows = tableRows.size();
		System.out.println("Total number of rows:" + totalRows);
		
		
		
		// total number of columns
		//int totalColumns = tableColumns.size();
		
			
    for(int i=1; i<=totalRows-1; i++) {
		   
			WebElement emails = ldriver.findElement(By.xpath("//div[@class='card']//div//div//tr["+ i +"]//td[7]")); 
			String actualEmail = emails.getText();
			if(actualEmail.contains(email)) {
				
				found = true;
			}
		
		}
		
		return found;
	}  
}
