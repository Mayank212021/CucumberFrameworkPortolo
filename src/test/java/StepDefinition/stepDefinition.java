package StepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.dashBoardPage;
import PageObject.editProfilePage;
import PageObject.homePage;
import PageObject.loginPage;
import PageObject.profilePage;
import PageObject.userListPage;
import Utilities.readConfig;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepDefinition extends BaseClass {

	@Before
	public void setup() {
		
		readconfig = new readConfig();
		String Browser = readconfig.getBrowser();

		
		logger = LogManager.getLogger("stepDefinition");
	// Browser launched
			switch (Browser.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				logger.info("Chrome Browser is launched");
				break;
			case "msedge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				logger.info("Edge Browser is launched");
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				logger.info("FireFox Browser is launched");
				break;
			default:
				driver = null;
				break;
			}
	}
	
	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {

		driver.manage().window().maximize();
		loginpage = new loginPage(driver);
		homepage = new homePage(driver);
		profilepage = new profilePage(driver);
		dashboard = new dashBoardPage(driver);
		editprofile = new editProfilePage(driver);
		userlistpage = new userListPage(driver);
	}

	@When("User open the URL {string}")
	public void user_open_the_url(String url) {

		driver.get(url);
		logger.info("URL is opened");
	}
	
	@Then("Click on the Signin Button")
	public void click_on_the_signin_button() {
	    loginpage.clickonSigninButton();
	    logger.info("Click on the Signin Button");
	}

	@When("User enters the Email as {string} and Password as {string}")
	public void user_enters_the_email_as_and_password_as(String email, String password) {

		loginpage.enterEmail(email);
		logger.info("Email is entered");
		loginpage.enterPassword(password);
		logger.info("Password is entered");
	}

	@When("click on Login button")
	public void click_on_login_button() {

		loginpage.clickOnLoginButton();
		logger.info("Clicked on Login button");
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String actualTitle) {

		String expectedTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {

			Assert.assertTrue(true);
			logger.info("Title is matched");
		}

		else {

			Assert.assertTrue(false);
			logger.warn("Title is mismmatched");
			//captureScreenShot(driver ,"Page Title is mismatched");
		}

	}

	@When("User click on Logout button")
	public void user_click_on_logout_button() {

		homepage.clickOnLogoutButton();
		logger.info("Clicked on LogOut button");
	}
	
    
    
	@And("Close browser")
	public void close_browser() {
		

			driver.close();
			logger.info("Browser is closed");
			
		}
	

	// profilePage.feature Edit Profile Functionality

	@Then("click on My Pages Menu Option")
	public void click_on_my_pages_menu_option() {

		dashboard.clickOnMyPagesMenu();
		logger.info("Clicked on My Pages menu");
	}

	@Then("Select and Click on My Profile option")
	public void select_and_click_on_my_profile_option() {
		dashboard.clickOnMyProfileOption();
		logger.info("Selected and Clicked on the My Profile option");
	}

	@Then("Click on the Edit button")
	public void click_on_the_edit_button() {

		profilepage.clickOnEditButton();
		logger.info(" Clicked on the Edit button");
	}

	@Then("Change the City  to {string}")
	public void change_the_city_to(String updatedCity) {

		editprofile.enterNewCity(updatedCity);
		logger.info(" Edit the city");
	}

	@Then("Click on Apply button")
	public void click_on_apply_button() {
		editprofile.clickOnApplyButton();
		logger.info(" Clicked on the Apply button");
	}

	// Scenario: Search user by Email on the user list page.

	@And("click on Pages Menu Option")
	public void click_on_pages_menu_option() {

		dashboard.clickOnPagesMenu();
		logger.info(" Clicked on the Pages menu");
	}

	@And("Select and Click User List option")
	public void select_and_click_user_list_option() {

		dashboard.clickOnUserListOption();
		logger.info("Selected and  Clicked on the User List option");
	}

	@Then("Enter {string} in the Email field")
	public void enter_in_the_email_field(String email) {

		userlistpage.enterEmail(email);
		logger.info(" Enter the email in the email field box");
	}

	@Then("click on search button")
	public void click_on_search_button() {

		userlistpage.clickOnSearchButton();
		logger.info(" Clicked on the search button");
	}

	@Then("User should found in the table")
	public void user_should_found_in_the_table() {
		
		
		 logger.info(" Email lists are here");
		
		
    if (userlistpage.searchUserByEmail("Test") == true) {

			Assert.assertTrue(true);
			logger.info(" Test Passed: Search by Email filter is working");
		}

		else {

			Assert.assertTrue(false);
			logger.warn("Test Failed: Search by Email filter is not working");
			
		}
		
	}
	
	
	
	
	
    @AfterStep
	public void catureScreenShot(Scenario sc) throws IOException {
	if(sc.isFailed()== true) {
			String path = "C:\\Users\\mayan\\eclipse-workspace\\CucumberFramworkProject\\Screenshots\\failedScenario.png";
			 TakesScreenshot screenshot = ((TakesScreenshot)driver);
			 File src = screenshot.getScreenshotAs(OutputType.FILE); // Take screenshot in file format
			byte[] fileContent = FileUtils.readFileToByteArray(src);
			sc.attach(fileContent,"image/png" , "Failedscreenshot.png");
			logger.warn("Scenario Failed: Screenshot captured");	
			
		}
		
		
	} 
	
/*	
	
	// Capturing screeshot after all steps
	@AfterStep
	//Capture screenshot method which is common to all test cases
    public void captureScreenShot( Scenario sc) throws IOException
    {
   	//Step1 : convert webdriver object to the TakesScreenshot interface Typecasting
   	 TakesScreenshot screenshot = ((TakesScreenshot)driver);
   	 // Step 2 : call getScreenshotAs method to create image file
   	 byte[] src = screenshot.getScreenshotAs(OutputType.BYTES);
   	 sc.attach(src, "image/png", sc.getName());  	 
		}
		*/
    }




