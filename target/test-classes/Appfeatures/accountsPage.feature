
Feature: Accounts page feature

Background:
Given user has already logged in to application
|username|password|
|thanya@gmail.com|12345|
 
  Scenario: Accounts page title
    Given user is on Accounts page
    When user gets title of the page
  	Then page title should be "My account - My Store"


  Scenario: Accounts section count
    Given user is on Accounts page
    Then user gets accounts section 
      |ORDER HISTORY AND DETAILS|
      |MY CREDIT SLIPS|
      |MY ADDRESSES|
      |MY PERSONAL INFORMATION|
      |MY WISHLISTS|
    And accounts section count should be 5
    
    
   Scenario: Accounts section message
   	Given user is on Accounts page
   	Then accounts section message should be "Welcome to your account. Here you can manage all of your personal information and orders."
   	
