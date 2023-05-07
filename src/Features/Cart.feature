#Author: your.email@your.domain.com
#StartedDate :03-May-2023
#CompletedDate : 05-May-2023

@CartFeature 
Feature: DemoBlaze Cart Verification
  @AddProducttoCart 
   Scenario Outline: Verify DemoBlaze Product can be Added to cart
    Given user is entering DemoBlaze url
    And user successfully logeed in with valid "<username>" and "<password>"
    When user clicks on Laptop Product category
    And user clicks on a product from the products list
    And user clicks on Add to Cart button
    Then product added alert should be displayed
    And accepting the Product added Alert
    And click on Cart Link
    And product added should be displayed in cart
 Examples:
|username|password|
|backya|password|

  @AddMultipleProductstoCart 
   Scenario Outline: Verify multiple Products can be Added to cart
    Given user is entering DemoBlaze url
    And user successfully logeed in with valid "<username>" and "<password>"
    When user clicks on Laptop Product category
    And user clicks on a product from the products list
    And user clicks on Add to Cart button
    And product added alert should be displayed
    And accepting the Product added Alert
    And user clicks on Home Link
    And user clicks on Monitors Product category
    And user clicks on a monitor product from the products list
    And user clicks on Add to Cart button
    And product added alert should be displayed
    And accepting the Product added Alert
    Then click on Cart Link
    And product added should be displayed in cart
 Examples:
|username|password|
|backya|password|

 @DeleteProductfromCart 
   Scenario Outline: Verify product can be Deleted from DemoBlaze cart
    Given user is entering DemoBlaze url
    And user successfully logeed in with valid "<username>" and "<password>"
    When user clicks on Laptop Product category
    And user clicks on a product from the products list
    And user clicks on Add to Cart button
    And accepting the Product added Alert
    And click on Cart Link
    Then click on Delete Link
    And added product should be removed from cart
     Examples:
|username|password|
|backya|password|

@PlaceOrderValidation 
   Scenario Outline: Verify Place Order screen validation
    Given user is entering DemoBlaze url
    And user successfully logeed in with valid "<username>" and "<password>"
    When user clicks on Laptop Product category
    And user clicks on a product from the products list
    And user clicks on Add to Cart button
    And accepting the Product added Alert
    And click on Cart Link
    And click on Place Order button and Place Order form should be displayed
    And click on Purchase button
    Then please fill out  name and credit card alert message should be displayed and accept the alert
    And  enter credit card value
    And click on Purchase button
    And please fill out  name and credit card alert message should be displayed and accept the alert
    And remove credit card value and enter name 
    And click on Purchase button
    And please fill out  name and credit card alert message should be displayed and accept the alert
    And enter name and credit card
    And click on Purchase button
    And Thank You for your purchase message should be displayed    
 Examples:
|username|password|
|backya|password|

@PlaceOrderCloseValidation 
   Scenario Outline: Verify Place Order screen Close button and close icon validation
    Given user is entering DemoBlaze url
    And user successfully logeed in with valid "<username>" and "<password>"
    When user clicks on Laptop Product category
    And user clicks on a product from the products list
    And user clicks on Add to Cart button
    And accepting the Product added Alert
    And click on Cart Link
    And click on Place Order button and Place Order form should be displayed
    And click on Close button
    And place order form should be closed
    And click on Place Order button and Place Order form should be displayed
    And click on Close icon
    And place order form should be closed
  Examples:
|username|password|
|backya|password|

 @PlaceOrderinCart 
   Scenario Outline: Verify Place Order in DemoBlaze cart
    Given user is entering DemoBlaze url
    And user successfully logeed in with valid "<username>" and "<password>"
    When user clicks on Laptop Product category
    And user clicks on a product from the products list
    And user clicks on Add to Cart button
    And accepting the Product added Alert
    And click on Cart Link
    And click on Place Order button and Place Order form should be displayed
    And fill out all details in Place Order form
    Then Thank You for your purchase message should be displayed
    
 Examples:
|username|password|
|backya|password|



  @PlaceOrderforMultipleProducts 
   Scenario Outline: Verify Place Order for multiple products in DemoBlaze cart
    Given user is entering DemoBlaze url
    And user successfully logeed in with valid "<username>" and "<password>"
    When user clicks on Laptop Product category
    And user clicks on a product from the products list
    And user clicks on Add to Cart button
    And product added alert should be displayed
    And accepting the Product added Alert
    And user clicks on Home Link
    And user clicks on Monitors Product category
    And user clicks on a monitor product from the products list
    And user clicks on Add to Cart button
    And product added alert should be displayed
    And accepting the Product added Alert
    Then click on Cart Link
    And product added should be displayed in cart
    And click on Place Order button and Place Order form should be displayed
    And fill out all details in Place Order form
    Then Thank You for your purchase message should be displayed
 Examples:
|username|password|
|backya|password|

 @ThankyouPurchaseValidation 
   Scenario Outline: Verify Thank you for your Purchase screen details
    Given user is entering DemoBlaze url
    And user successfully logeed in with valid "<username>" and "<password>"
    When user clicks on Monitors Product category
    And user clicks on a monitor product from the products list
    And user clicks on Add to Cart button
    And accepting the Product added Alert
    And click on Cart Link
    And click on Place Order button and Place Order form should be displayed
    And fill out all details in Place Order form
    Then Thank You for your purchase message should be displayed
    And verify details displayed in Thank You for your purchase
    And verify Ok button is displayed in Thank you for your purchase and click on Ok button
 Examples:
|username|password|
|backya|password|
