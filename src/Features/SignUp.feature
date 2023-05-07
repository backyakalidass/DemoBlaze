#Author: Backyalakshmi Kalidass
#StartedDate :19-Apr-2023
#CompletedDate : 24-Apr-2023

@SignUpFeature
Feature: Test DemoBlaze SignUp
   @SignupValidScenario 
  Scenario Outline: DemoBlaze Sign Up with data Examples
    Given user is entering DemoBlaze url
    And user clicks on SignUp button
    When user enters valid "<username>" and "<password>"
    And user clicks on signup button
    Then "<expectedalert>" alert displayed
    And user clicks on Ok button in alert
Examples:
|username|password|expectedalert|
|amuthu|testpass|Sign up successful.|
|backya|password|Sign up successful.|

 @SignupNoUsername 
  Scenario Outline: DemoBlaze Sign Up Validation
    Given user is entering DemoBlaze url
    And user clicks on SignUp button
    When user enters only password "<password>"
    And user clicks on signup button
    Then "<expectedalert>" alert displayed
    And user clicks on Ok button in alert
Examples:
|password|expectedalert|
|testpass|Please fill out Username and Password.|

 @SignupNoPassword 
  Scenario Outline: DemoBlaze Sign Up Validation
    Given user is entering DemoBlaze url
    And user clicks on SignUp button
    When user enters only username "<username>"
    And user clicks on signup button
    Then "<expectedalert>" alert displayed
    And user clicks on Ok button in alert
Examples:
|username|expectedalert|
|admin|Please fill out Username and Password.|

 @SignupNoPasswordandNoUsername 
  Scenario Outline: DemoBlaze Sign Up Validation
    Given user is entering DemoBlaze url
    And user clicks on SignUp button
    When user clicks on signup button
    Then "<expectedalert>" alert displayed
    And user clicks on Ok button in alert
 Examples:
|expectedalert|
|Please fill out Username and Password.|
    
     @SignupExistingUsernameandPassword 
 Scenario Outline: DemoBlaze Sign Up Validation
    Given user is entering DemoBlaze url
    And user clicks on SignUp button
    When user enters existing "<username>" and "<password>"
    And user clicks on signup button
    Then "<expectedalert>" alert displayed
    And user clicks on Ok button in alert
Examples:
|username|password|expectedalert|
|amuthu|testpass|This user already exist.|

@SignupClosebutton 
  Scenario Outline: DemoBlaze Login Page Close button validation
    Given user is entering DemoBlaze url
    And user clicks on SignUp button
    When user enters valid "<username>" and "<password>"
    And user clicks on Close button in SignUp
    Then verify close action in Signup
Examples:
|username|password|
|amuthu|testpass|

 @SignupCloseIcon
  Scenario: DemoBlaze Login Page Close Icon validation
   Given user is entering DemoBlaze url
    And user clicks on SignUp button
    When user clicks on Close Icon x in Signup
    Then verify close action in Signup

