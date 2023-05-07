#Author: Backyalakshmi Kalidass
#StartedDate :02-May-2023
#CompletedDate : 01-May-2023

@HomePageAfterLoginFeature 
Feature: DemoBlaze Home Page Validation after Login
   @HomePageDisplayValidation 
  Scenario Outline: DemoBlaze Home Page Display
    Given user is entering DemoBlaze url
    And user successfully logeed in with valid "<username>" and "<password>"
    When verify categories list options
    Then verify previous and next buttons available     
Examples:
|username|password|
|amuthu|testpass|

   @HomePageDisplayProductsCountValidation 
  Scenario Outline: DemoBlaze Home Page Display Product Count Validation
    Given user is entering DemoBlaze url
    And user successfully logeed in with valid "<username>" and "<password>"
    When verify number of product display in first page
    Then click on next button
    And verify number of products in second page
    And click on previous button
 Examples:
|username|password|
|amuthu|testpass|

 
    