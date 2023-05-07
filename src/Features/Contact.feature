#Author: Backyalakshmi Kalidass
#StartedDate :01-May-2023
#CompletedDate : 01-May-2023

@ContactFeature 
Feature: Test DemoBlaze Contact
   @ContactSendMessage 
  Scenario Outline: DemoBlaze Contact Send Message
    Given user is entering DemoBlaze url
    And user clicks on contact link
    When user enters contact email "<email>" and contact name "<name>" and message "<message>"
    And user clicks on Send message button
    Then "<expectedalert>" contact alert displayed
    And user accepts the alert
    
 Examples:
|email|name|message|expectedalert|
|backya@gmail.com|Backya|Test Message|Thanks for the message!!|
|amuthu@gmail.com|Amuthini|Hello Message|Thanks for the message!!|
|senthil@gmail.com|Senthil|Happy Message|Thanks for the message!!|

  @ContactClose 
  Scenario: DemoBlaze Contact Close button Validation
    Given user is entering DemoBlaze url
    And user clicks on contact link
    When user clicks on close button in contact page
    Then verify contact page close
    