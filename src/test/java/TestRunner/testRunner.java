package TestRunner;

import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;

//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
 
//@RunWith(Cucumber.class)
@CucumberOptions(
		
		features =  "src/test/java/Features/loginPage.feature",
		glue = "StepDefinition", 
		dryRun = false ,
		monochrome = true,
	    tags = "@regression or @sanity",
	    plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" , 
	    		 "html:target/CucumberReports/report.html" ,
	    		  "rerun:Failed_Scenarios/failed_Scenarios.txt" }
		//plugin = {"pretty", "html:target/CucumberReports/report.html"}
		
		
		) 

public class testRunner extends AbstractTestNGCucumberTests {
	
	//must be empty

} 
