 package StepDefinition;

import org.openqa.selenium.WebDriver;
import PageObject.dashBoardPage;
import PageObject.editProfilePage;
import PageObject.homePage;
import PageObject.loginPage;
import PageObject.profilePage;
import PageObject.userListPage;
import Utilities.readConfig;



import org.apache.logging.log4j.*;

public class BaseClass {
	
	public static WebDriver driver;
	public loginPage loginpage;
	public homePage homepage;
	public profilePage profilepage;
	public dashBoardPage dashboard;
	public editProfilePage editprofile; 
	public userListPage userlistpage;
	public static Logger logger;
	public readConfig readconfig; 
	
	
	

}
