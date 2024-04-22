package lms.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import lms.Hooks.BackgroundHooks;

public class LoginPage 
{
	WebDriver driver;
	
	//XPath Declarations
	private By username = By.xpath("//input[@id='email1']");
	private By password = By.xpath("//input[@placeholder='Password']");
	private By loginbtn = By.xpath("//span[@class='p-button-label p-c']");
	private By pageheader = By.xpath("//*[text()='Sign in to continue']");
	private By firsttext = By.xpath("//label[@for = 'email1']");
	private By secondtext = By.xpath("//label[@for = 'password1']");
	private By forgotpasswd = By.xpath("//a[text() = 'Forgot Password?']");
	private By eyeicon = By.xpath("//i[@class = 'pi pi-eye']");
	
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getCurrentURL()
	{
		return driver.getCurrentUrl();
	}
	
	public String LoginPageHeader()
	{
		return driver.findElement(pageheader).getText();
	}
	
	public Boolean UsernameTextExist()
	{
		return driver.findElement(firsttext).isDisplayed();
	}
	
	public Boolean PasswordTextExist()
	{
		return driver.findElement(secondtext).isDisplayed();
	}
	
	public Boolean UsernameExist()
	{
		return driver.findElement(username).isDisplayed();
	}
	
	public Boolean PasswordExist()
	{
		Boolean IsExist = driver.findElement(password).isDisplayed();
		return IsExist;
	}
	
	public Boolean LoginBtnExist()
	{
		Boolean IsExist = driver.findElement(loginbtn).isDisplayed();
	    return IsExist;
	}
	
	public Boolean EyeIconExist()
	{
		Boolean IsExist = driver.findElement(eyeicon).isDisplayed();
		return IsExist;
	}
	
	public Boolean ForgotpasswdExist()
	{
		Boolean IsExist = driver.findElement(forgotpasswd).isDisplayed();
		return IsExist;
	}
	
	public void Login(String user_name,String passwd)
	{
		driver.findElement(username).sendKeys(user_name);
		driver.findElement(password).sendKeys(passwd);
		driver.findElement(loginbtn).click();
	}
	
	public void ForgotPasswd_Click()
	{
		driver.findElement(forgotpasswd).click();
	}

}
