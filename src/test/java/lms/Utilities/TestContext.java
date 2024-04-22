package lms.Utilities;

import org.openqa.selenium.WebDriver;

import lms.Pages.LoginPage;

public class TestContext 
{
	public static WebDriver driver;
	
	//Objects for each Page
	public LoginPage loginObj;

	public WebDriver getDriver()
	{
		return driver;
	}

	public void setDriver(WebDriver driver)
	{
		TestContext.driver = driver;
		System.out.println("Driver Set");
	}
	
	//Login Page Object
	public LoginPage getLoginPageObject()
	{
		return loginObj;
	}
	
	//Page Objects Initialization
	public void InitializePageObject(WebDriver driver)
	{
		loginObj = new LoginPage(driver);
	}
	

}
