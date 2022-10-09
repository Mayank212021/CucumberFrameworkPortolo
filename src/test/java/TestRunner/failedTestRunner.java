package TestRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
 
//@RunWith(Cucumber.class)
@CucumberOptions(
		
		features =  "@Failed_Scenarios/failed_Scenarios.txt",
		glue = "StepDefinition", 
		dryRun = false ,
		monochrome = true,
	    plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" , 
	    		 "html:target/CucumberReports/report.html"}
		//plugin = {"pretty", "html:target/CucumberReports/report.html"}
		
		
		) 

public class failedTestRunner extends AbstractTestNGCucumberTests {
 //Must be empty
} 
