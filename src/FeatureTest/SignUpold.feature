#Author: Backyalakshmi Kalidass
#Date :19-Apr-2023

@SignUpFeature
Feature: Test DemoBlaze SignUp
   @SignupValidScenario
  Scenario: DemoBlaze Sign Up with valid detials
    Given user is entering DemoBlaze url
    And user clicks on SignUp button
    When user enters valid username and password
    And user clicks on signup button
    Then signup successful alert displayed
    And user clicks on Ok button
    
     @SignupValidScenario
  Scenario: DemoBlaze Sign Up with valid detials
    Given user is entering DemoBlaze url
    And user clicks on SignUp button
    When user enters valid username and password
    And user clicks on signup button
    Then signup successful alert displayed
    And user clicks on Ok button

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
