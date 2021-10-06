package stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import baseTest.BaseTest;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;

public class LoginStepDefinition extends BaseTest {
	public LoginPage lp;
	public LoginStepDefinition() throws IOException {
		super();
	
	}

	@Given("^user is on amazon login page$")
	public void user_is_on_amazon_login_page() throws Throwable {
		openBrowser();
		openAmazon();
		lp = new LoginPage();
	   
	}


	

	@Then("^validate user is correct account$")
	public void validate_user_is_correct_account() throws Throwable {
		System.out.println("hello");
		driver.close();
	    
	}
	@When("^user enter <email> and <password>\\.$")
	public void user_enter_email_and_password(DataTable credential) throws Throwable {
		List<String> list = credential.asList(String.class);
		lp.login(list.get(0),list.get(1));
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}
	
	@When("^user enter '(\\d+)' and 'jaimin@(\\d+)'\\.$")
	public void user_enter_Jkachhadiya_conestogac_on_ca_and_jaimin(String username, String password) throws Throwable {
	  lp.email.sendKeys(username);
	  lp.continueButton.click();
	  lp.password.sendKeys(password);
	}
	
	@When("^user enter (\\d+) and jaimin@(\\d+)\\.$")
	public void user_enter_and_jaimin(String name, String  pass) throws Throwable {
		
		lp.email.sendKeys(name);
		lp.continueButton.click();
		lp.password.sendKeys(pass);
		

		

	}
	
	@When("^user enter details\\.$")
	public void user_enter_details(DataTable table) throws Throwable {
	   
		List<Map<String, String>> maps = table.asMaps(String.class, String.class);
		   for (Map<String, String> data : maps) {
			   String name = data.get("username");
			   String password = data.get("password");
			   System.out.println(name+" ,  "+password);
			   lp.email.sendKeys(name);
			   lp.continueButton.click();
			   lp.password.sendKeys(password);
		   }
		   
	}


}
