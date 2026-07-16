Feature: Navia Online Trading Market Post Market Testing Nine FourtyFive Testing

Scenario: Login Navia
    Given User Navigate to Navia 
    When User Click login with client code
    And User Enter Client Code
    And User  Enter Password
    And User Click Agree CheckBox
    And User Click Login button
    And User Click Otp Verification and enter manualy
    And User Click Login Again
  
  
Scenario: User Check  - Buy Back- functionality   
    When Navigate to home page 
    And User MouseOver Dashboard and Click Tools
    And user Mouse Over The Element
    And User Click Tools "Buy Back"  
    And User Verify Buy Back Page
    
Scenario: User Check  - Stock- functionality     
    When Navigate to home page 
    And User click the search box
    And User Search any "TCS-A" Script
    And User Mouse Over and Add a Script

Scenario: User Check The Basket - CREATE - functionality

When Navigate to home page   
And User MouseOver Dashboard and Click Tools button
And User Click The Basket button
And User Click The Tools Add Bseket button
And User Enter The Tools Basket "TEST" Name
#And User Enter The Tools "Testing Purpose" Description
And User Click The Tools "Create Basket" button and close
Then  Next Page Shown
    
Scenario: User Check  - Basket- functionality    
    When Navigate to home page 
    And User mouse the scrip Selected "TCS-A" 
    And User Click the Buy scrip for Selected "TCS-A" Scrip
    And User Click Market then Limit
    And User Select Qty "2"
    And User Click Basket Icon
    And User Choose Basket "BASKET"
    And User Navigate to Basket and Click My Baskets 
    And User Click Place Order for Particular "BASKET" Baskets
    And User Execute following orders
    
    
    
    

    
    