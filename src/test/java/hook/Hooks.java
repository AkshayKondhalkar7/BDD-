package hook;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import fp.base.WebDriverUtility;
import fp.pages.elements.HomePageElements;
import fp.property.file.utility.PropertyFileUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * This class Executes before your Scenario/Feature_File gets Executed 
 * Here we are initializing our driver(Browser is launching) and closing the driver (browser is closing)
 * and taking screenshot of Failed Scenarios
 * @author Pavan
 *
 */
public class Hooks extends WebDriverUtility
{
	WebDriverUtility webDriverUtility;

	public Hooks(WebDriverUtility webDriverUtility)
	{
		this.webDriverUtility=webDriverUtility;
	}


	public static WebDriver initilizeBrowser(String browser) throws IOException
	{
		WebDriver driver= null;

		if(browser.equals("chrome")) 
		{
			driver= new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else {
			System.out.println("Invalid browser");
		}

		return driver;
	}

	public static PropertyFileUtility readdatapropertyfile() {
		PropertyFileUtility propertyFileUtility = new PropertyFileUtility();
	return propertyFileUtility;
	}

	@Before
	public void setup(Scenario scenario) throws IOException
	{
		 System.out.println("BEFORE: THREAD ID : " + Thread.currentThread().getId() + "," +
	                "SCENARIO NAME: " + scenario.getName());
		
		setPropertyFile(readdatapropertyfile());
		setDriver(initilizeBrowser(getPropertyFileUtils().getData("browser"))); 
		getDriver().get(getPropertyFileUtils().getData("url"));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		getDriver().manage().window().maximize();
	}
	
	
	
	

	@After(order = 98)
	public void takeScreenshotiffailed(Scenario scenario) 
	{
		if(scenario.isFailed()) {
			byte[] screenshot=takeScreenshot();
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		
		
	}
	
	@After(order =99)
	public void logoutfromApplication(Scenario scenario) throws Exception {
		
		 System.out.println("AFTER: THREAD ID : " + Thread.currentThread().getId() + "," +
	                "SCENARIO NAME: " + scenario.getName());
		super.clickElementJS(HomePageElements.logoutDropdown);
		super.clickElementJS(HomePageElements.logoutButton);
		
	}
	
	@After(order=97)
	public void closeBrowser() 
	{
		getDriver().close();
		softAssert().assertAll();
	}












}
