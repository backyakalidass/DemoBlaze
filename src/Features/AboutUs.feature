#Author: Backyalakshmi Kalidass
#StartedDate :01-May-2023
#CompletedDate : 01-May-2023

@AboutUsFeature 
Feature: Test DemoBlaze About Us
   @AboutUsPlayScenario  
  Scenario: AboutUs Video Play scenario
    Given user is entering DemoBlaze url
    And user clicks on AboutUs link
    When user clicks on play Video button
    Then verify video played  
    
  @AboutUsVideoPauseScenario 
  Scenario: AboutUs Video Pause scenario
    Given user is entering DemoBlaze url
    And user clicks on AboutUs link
    When user clicks on play Video button
    And user clicks on video pause button
    Then verify video pause 
    
  @AboutUsVideoUnPauseScenario 
  Scenario: AboutUs Video UnPause scenario
    Given user is entering DemoBlaze url
    And user clicks on AboutUs link
    When user clicks on play Video button
    And user clicks on video pause button
    And user clicks on video unpause or play button
    Then verify video unpause 
    
     @AboutUsVideoFullScreenScenario 
  Scenario: AboutUs Video Full Screen scenario
    Given user is entering DemoBlaze url
    And user clicks on AboutUs link
    When user clicks on play Video button
    And user clicks on full screen button
    Then verify video full screen 
    
  @AboutUsVideoNonFullScreenScenario 
  Scenario: AboutUs Video Non Full Screen scenario
    Given user is entering DemoBlaze url
    And user clicks on AboutUs link
    When user clicks on play Video button
    And user clicks on full screen button
    And user clicks on non full screen button
    Then verify video non full screen 
    
  @AboutUsCloseScenarioAfterPlayingVideo 
  Scenario: AboutUs Video Close scenario after playing video
    Given user is entering DemoBlaze url
    And user clicks on AboutUs link
    When user clicks on play Video button
    And user clicks on Close button in AboutUs Page
    Then About Us Page is closed
    
  @AboutUsCloseScenarioBeforePlayingVideo 
  Scenario: AboutUs Video Close scenario before playing video
    Given user is entering DemoBlaze url
    And user clicks on AboutUs link
    When user clicks on Close button in AboutUs Page
    Then About Us Page is closed
    
  
    
  


 