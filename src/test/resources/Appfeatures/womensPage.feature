
Feature: Womens page feature

Background:
Given user has already logged in to application
|username|password|
|thanya@gmail.com|12345|

Scenario: Womens page title
    When user click on womens tab
  	Then page title should be "Women - My Store"
  	
Scenario: Womens page menu
		When user hover on womens tab
		Then menus should be displayed as below
		 |TOPS|
     |DRESSES|
    And womens menu section count should be 2

Scenario: Womens page Tops sub-menu
		When user hover on womens tab
		Then Tops subMenus should be displayed as below
		 |T-shirts|
     |Blouses|
    And womens Top menu section count should be 2
    
Scenario: Womens page Dresses sub-menu
		When user hover on womens tab
		Then Dresses subMenus should be displayed as below
		 |Casual Dresses|
     |Evening Dresses|
     |Summer Dresses|
    And womens Dresses menu section count should be 3
