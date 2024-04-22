Feature: User Login to LMS Portal

  @Admin_Lands_On_LoginPage
  Scenario: Verify admin is able to land on home page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Login Page is displayed
    
  @LoginPage_Header
  Scenario: Verify the header of the login page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then "Sign in to continue" text should be displayed

  @VerifyText_above_FirstTextField
  Scenario: Verify text above the first text field
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Username should be displayed above the first text field

  @Username_InputField
  Scenario: Verify the Username input field 
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Username input field element should be present in the login page

  @VerifyText_above_SecondTextField
  Scenario: Verify text above the second text field
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Password should be displayed above the second text field

  @Password_InputField
  Scenario: Verify the Password input field 
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Password input field element should be present in the login page   
    
  @Verify_the_Login_button
  Scenario: Verify the Login button
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Login button should be present in the login page
    
  @Verify_the_Forgot_password_link 
  Scenario: Verify the Forgot password link 
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Forgot password link should present in the login page
    
  @Verify_the_eye_icon_is_present_in_the_password_field
  Scenario: Verify the eye icon is present in the password field 
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Eye Icon should be present in the password field
    
  @Validate_Login_with_valid_credentials
  Scenario: Validate Login with valid credentials
    Given Admin is in Login Page
    When Admin clicks Login button after entering Valid Username and Valid Password
    Then Successfully redirected to Base app Page
    
  @Validate_Login_Negative_Scenarios
  Scenario: Validate Login with invalid credentials
     Given Admin is in Login Page
     When Admin clicks Login button after entering Invalid Username and Invalid Password
     Then Error Message is appeared
     
  Scenario: Validate Login with empty/blank Username and valid password
     Given Admin is in Login Page
     When Admin clicks Login button after entering Invalid/blank Username and Valid Password
     Then Error Message is appeared
     
  Scenario: Validate Login with valid Username and empty/blank password
     Given Admin is in Login Page
     When Admin clicks Login button after entering Valid Username and Invalid/blank Password
     Then Error Message is appeared
     
  Scenario: Validate Login with empty/blank Username and empty/blank password
     Given Admin is in Login Page
     When Admin clicks Login button after entering Invalid/blank Username and Invalid/blank Password
     Then Error Message is appeared
     
  Scenario: Verify Forget Password Link
     Given Admin is in Login Page
     When Admin clicks on Forget Password Link
     Then Successfully redirected to Forgot Password Page


     
   