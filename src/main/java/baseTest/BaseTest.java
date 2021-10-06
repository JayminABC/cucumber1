package baseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static Properties prop;
	public static WebDriver driver;
	@Parameter
	public String browser;
	@Parameter(1)
	public String platform;
	@Parameter(2)
	public String version;
	
	public BaseTest() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\config.properties");
		prop = new Properties();
		prop.load(file);
	}
	
	public void openBrowser() throws IOException {
		

		MutableCapabilities sauceOpts = new MutableCapabilities();
//		sauceOpts.setCapability("name", "jaimin");
//		sauceOpts.setCapability("build", "Java-W3C-Examples");
//		sauceOpts.setCapability("seleniumVersion", "3.141.59");
		sauceOpts.setCapability("username", "jaiminka");
		sauceOpts.setCapability("accessKey", "7e60f207-059d-48d0-a73e-f3e15bce4ce8");


		MutableCapabilities browserOption = new MutableCapabilities();

		browserOption.setCapability(CapabilityType.BROWSER_NAME, browser);
		
		browserOption.setCapability("platformName", platform);
		browserOption.setCapability("browserVersion", version);
		browserOption.setCapability("sauce:options", sauceOpts);


		try {
			
			driver = new RemoteWebDriver(new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub"), browserOption);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
	}
	public void closeBroser() {
		driver.close();
	}
	public void openAmazon() {
		driver.get(prop.getProperty("url"));
	}
	
	@Parameters(name = "{0},{1}")
	public static Collection<Object[]> crossbrowserData(){
		return Arrays.asList(new Object[][] {
			{"Chrome","window 10","latest"},
			{"Chrome","window 10","latest-1"}
		});
	}
	
}
