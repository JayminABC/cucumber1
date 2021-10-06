package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseTest.BaseTest;

public class LoginPage extends BaseTest {

	@FindBy(name = "email")// driver.findelement(by.name="email");
	public static WebElement email; //WebElement id= 
	@FindBy(id = "continue")
	public static WebElement continueButton;
	@FindBy(name = "password")
	public static WebElement password;
	@FindBy(id = "signInSubmit")
	public static WebElement signInButton;
	
	
	
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void login(String user, String pass) throws IOException {
		email.sendKeys(user);
		continueButton.click();
		password.sendKeys(pass);
		//signInButton.click();
		
	}

}
