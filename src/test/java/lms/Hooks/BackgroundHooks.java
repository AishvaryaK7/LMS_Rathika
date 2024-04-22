package lms.Hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import lms.Utilities.BaseClass;
import lms.Utilities.TestContext;

public class BackgroundHooks extends BaseClass
{
	public static boolean HooksFlag = false;

	private TestContext testContext;
	
	@Before
	//Driver Initialization
	public void BrowserSetUp(Scenario scenario)
	{
		
		WebDriver driver = null;
		
		System.out.println("Scenario Name ==> " +scenario.getName());
		String browser = config.getString("browser");		
		
		// Initialize the TestContextSetUp object if it's null
        if (testContext == null)
        {
            testContext = new TestContext();
        }
		
		if(driver == null)
		{
		
			if(browser.equalsIgnoreCase("chrome"))
			{	
				WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	            System.out.println("Chrome Driver");
			}
		
			else if(browser.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				System.out.println("Firefox Driver");
			}
		
			else if(browser.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				System.out.println("Edge Driver");
			}
		
			testContext.setDriver(driver);
			testContext.getDriver().manage().window().maximize();
			testContext.getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				
			HooksFlag = true;
		}
		
		//return testContext.getDriver();
	}
	

	@After
	//Close And Quit Browser
	public void closeBrowser(Scenario scenario)
	{
		
		if(testContext.getDriver() != null)
		{
			System.out.println("After - Scenario Name ==> " +scenario.getName());
			
			//testContext.getDriver().close();
			testContext.getDriver().quit();
		}
	}
	
}
