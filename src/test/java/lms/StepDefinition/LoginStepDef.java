package lms.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import lms.Utilities.BaseClass;
import lms.Utilities.TestContext;

public class LoginStepDef extends BaseClass
{
	//LoginPage loginPage = new LoginPage(driver);
	
	TestContext testContext;
	
	//Constructor level Dependency Injection
	public LoginStepDef(TestContext testContext)
	{
		this.testContext = testContext;
	}
	
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() 
	{
	   //testContext.setDriver(BrowserSetUp()); 
		System.out.println("Browser Launched");
		log.info("Browser Launched");
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() 
	{
	    String LMSUrl = config.getString("url");
	    System.out.println("LMS URL : "+LMSUrl);
	    
	    testContext.InitializePageObject(testContext.getDriver());
	    testContext.getDriver().get(LMSUrl);
	    log.info("LMS Base URL : "+LMSUrl);
			    
	}

	@Then("Login Page is displayed")
	public void login_page_is_displayed() 
	{
		String LMSUrl = config.getString("url");
		String currentURL = testContext.getLoginPageObject().getCurrentURL();
		
		System.out.println("Current URL : " );
		System.out.println(currentURL);
		
		assertEquals(LMSUrl,currentURL);	
		log.info("Expected URL : "+LMSUrl+"Actual URL : "+currentURL);

	}

	@Then("{string} text should be displayed")
	public void text_should_be_displayed(String PageHeader) 
	{
		String header = testContext.getLoginPageObject().LoginPageHeader();
		assertEquals(PageHeader,header);
		log.info("Page Header Validation - " +header);

	}

	@Then("Username should be displayed above the first text field")
	public void should_be_displayed_above_the_first_text_field()
	{
		Boolean userText = testContext.getLoginPageObject().UsernameTextExist();
		assertEquals(true,userText);

	}

	@Then("Username input field element should be present in the login page")
	public void username_input_field_element_should_be_present_in_the_login_page() 
	{
		Boolean UserExist = testContext.getLoginPageObject().UsernameExist();
		assertEquals(true,UserExist);

	}
	
	@Then("Password should be displayed above the second text field")
	public void should_be_displayed_above_the_second_text_field()
	{
		Boolean passwordText = testContext.getLoginPageObject().PasswordTextExist();
		assertEquals(true,passwordText);

	}

	@Then("Password input field element should be present in the login page")
	public void password_input_field_element_should_be_present_in_the_login_page() 
	{
		Boolean PassExist = testContext.getLoginPageObject().PasswordExist();
		assertEquals(true,PassExist);

	}

	@Then("Login button should be present in the login page")
	public void login_button_should_be_present_in_the_login_page()
	{
		Boolean PassExist = testContext.getLoginPageObject().LoginBtnExist();
		assertEquals(true,PassExist);
		//testContext.getDriver().close();
	}

	@Then("Forgot password link should present in the login page")
	public void forgot_password_link_should_present_in_the_login_page() 
	{
		Boolean PassExist = testContext.getLoginPageObject().ForgotpasswdExist();
		assertEquals(true,PassExist);

	}

	@Then("Eye Icon should be present in the password field")
	public void eye_icon_should_be_present_in_the_password_field() 
	{
		Boolean PassExist = testContext.getLoginPageObject().EyeIconExist();
		assertEquals(true,PassExist);

	}
	
	@Given("Admin is in Login Page")
	public void admin_is_in_login_page() 
	{
		//testContext.setDriver(BrowserSetUp()); 
		String LMSUrl = config.getString("url");
		testContext.getDriver().get(LMSUrl);
		testContext.InitializePageObject(testContext.getDriver());
		String currentURL = testContext.getLoginPageObject().getCurrentURL();
				
		assertEquals(LMSUrl,currentURL);	
	}

	@When("Admin clicks Login button after entering Valid Username and Valid Password")
	public void admin_clicks_login_button_after_entering_valid_username_and_valid_password() 
	{
	    String user_name = config.getString("username");
	    String passwd = config.getString("password");
	    testContext.getLoginPageObject().Login(user_name, passwd);
	}
	
	@Then("Successfully redirected to Base app Page")
	public void successfully_redirected_to_base_app_page() 
	{
		String currentURL = testContext.getLoginPageObject().getCurrentURL();
		String forgotPasswordURL = config.getString("basePageUrl");
		assertEquals(forgotPasswordURL,currentURL);

	}

	@When("Admin clicks Login button after entering Invalid Username and Invalid Password")
	public void admin_clicks_login_button_after_entering_invalid_username_and_invalid_password() 
	{
		String user_name = config.getString("invalid_username");
	    String passwd = config.getString("invalid_password");
	    testContext.getLoginPageObject().Login(user_name, passwd);
	}

	@When("Admin clicks Login button after entering Invalid\\/blank Username and Valid Password")
	public void admin_clicks_login_button_after_entering_invalid_blank_username_and_valid_password()
	{
		String user_name = config.getString("invalid_username");
	    String passwd = config.getString("password");
	    testContext.getLoginPageObject().Login(user_name, passwd);
	}

	@When("Admin clicks Login button after entering Valid Username and Invalid\\/blank Password")
	public void admin_clicks_login_button_after_entering_valid_username_and_invalid_blank_password() 
	{
		String user_name = config.getString("username");
	    String passwd = config.getString("invalid_password");
	    testContext.getLoginPageObject().Login(user_name, passwd);
	}

	@When("Admin clicks Login button after entering Invalid\\/blank Username and Invalid\\/blank Password")
	public void admin_clicks_login_button_after_entering_invalid_blank_username_and_invalid_blank_password()
	{
		String blankfield = " ";
	    testContext.getLoginPageObject().Login(blankfield, blankfield);
	}

	@Then("Error Message is appeared")
	public void error_message_is_appeared() 
	{
		String currentURL = testContext.getLoginPageObject().getCurrentURL();
		String LMSURL = config.getString("url");
		assertEquals(LMSURL,currentURL);
		//testContext.getDriver().close();
	}

	@When("Admin clicks on Forget Password Link")
	public void admin_clicks_on_forget_password_link() 
	{
	    testContext.getLoginPageObject().ForgotPasswd_Click();
	}
	
	@Then("Successfully redirected to Forgot Password Page")
	public void successfully_redirected_to_forgot_password_page() 
	{
		String currentURL = testContext.getLoginPageObject().getCurrentURL();
		String forgotPasswordURL = config.getString("forgotPasswordUrl");
		assertEquals(forgotPasswordURL,currentURL);
		
	}

}
