#Author: Backyalakshmi Kalidass
#Date :19-Apr-2023

@SignUpFeature
Feature: Test DemoBlaze SignUp
   @SignupValidScenario
  Scenario Outline: DemoBlaze Sign Up with data table
    Given user is entering DemoBlaze url
    And user clicks on SignUp button
    When user enters valid "<username>" and "<password>"
    And user clicks on signup button
    Then signup successful alert displayed
    And user clicks on Ok button
Examples:
|username|password|
|amuthu|testpass|
|backya|password|
