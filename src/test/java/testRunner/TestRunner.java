package testRunner;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)



@CucumberOptions(
		features = "C:\\Selenium_Practice\\mvnBDDamazonsource\\src\\main\\java\\feature\\Login.feature",
		glue = {"stepdefinition"},
		plugin = {"pretty","html:test-output","json:json-output/cucumber.json","junit:junit_xml/cucumber.xml"},
		monochrome = true,
		dryRun = false,
		strict = true
		
		//tags = {"@saity , @regression"}
		
		)
public class TestRunner {


	
	

}
