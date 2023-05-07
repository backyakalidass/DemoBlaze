#Author: Backyalakshmi Kalidass
#StartedDate :24-Apr-2023
#CompletedDate : 30-Apr-2023

@LogInFeature 
Feature: Test DemoBlaze Login
   @LoginValidScenario 
  Scenario Outline: DemoBlaze Login with valid data
    Given user is entering DemoBlaze url for login
    And user clicks on Login link
    When user enters login "<username>" and "<password>"
    And user clicks on Login button
    Then verify and validate Welcome link displayed with username "<username>"
    And user clicks on Logout and verify Logout
    
 Examples:
|username|password|
|backya|password|
#|amuthu|testpass|
#|admin1214|121424|

 @LoginNoPasswordandNoUsername 
  Scenario Outline: DemoBlaze Login Validation with No Username and Password
    Given user is entering DemoBlaze url for login
    And user clicks on Login link
    When user clicks on Login button
    Then "<expectedalert>" alert displayed
    And user clicks on Ok button in alert
 Examples:
|expectedalert|
|Please fill out Username and Password.|

 @LoginNoUsername 
  Scenario Outline: DemoBlaze Login Validation with No Username
    Given user is entering DemoBlaze url for login
    And user clicks on Login link
    When user enters login password "<password>"
    And user clicks on Login button
    Then "<expectedalert>" alert displayed
    And user clicks on Ok button in alert
 Examples:
|password|expectedalert|
|password|Please fill out Username and Password.|

 @LoginNoPassword 
  Scenario Outline: DemoBlaze Login Validation with No Password
    Given user is entering DemoBlaze url for login
    And user clicks on Login link
    When user enters login username "<username>"
    And user clicks on Login button
    Then "<expectedalert>" alert displayed
    And user clicks on Ok button in alert
 Examples:
|username|expectedalert|
|amuthu|Please fill out Username and Password.|

 @LoginWrongPassword 
  Scenario Outline: DemoBlaze Login Validation with wrong Password
    Given user is entering DemoBlaze url for login
    And user clicks on Login link
    When user enters valid username "<username>" and wrong password "<password>"
    And user clicks on Login button
    Then "<expectedalert>" alert displayed
    And user clicks on Ok button in alert
 Examples:
|username|password|expectedalert|
|amuthu|a123|Wrong password.|

 @LoginWrongUsername 
  Scenario Outline: DemoBlaze Login Validation with wrong Username
    Given user is entering DemoBlaze url for login
    And user clicks on Login link
    When user enters wrong username "<username>" and valid password "<password>"
    And user clicks on Login button
    Then "<expectedalert>" alert displayed
    And user clicks on Ok button in alert
 Examples:
|username|password|expectedalert|
|amuthuSmile|testpass|User does not exist.|

 @LoginClosebutton 
  Scenario Outline: DemoBlaze Login Page Close button validation
    Given user is entering DemoBlaze url for login
    And user clicks on Login link
    When user enters login "<username>" and "<password>"
    And user clicks on Close button
    Then verify close action
Examples:
|username|password|
|amuthu|testpass|

 @LoginCloseIcon 
  Scenario: DemoBlaze Login Page Close Icon validation
    Given user is entering DemoBlaze url for login
    And user clicks on Login link
    When user clicks on Close Icon x
    Then verify close action
