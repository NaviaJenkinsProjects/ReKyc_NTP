Feature: Navia Online Trading Market Login 


Scenario: Login Navia
    Given User Navigate to Navia 
    When User Click login with client code
    And User Enter Client Code
    And User  Enter Password
    And User Click Agree CheckBox
    And User Click Login button
    And User Click Otp Verification and enter manualy
    And User Click Login Again

    
Scenario: AMO Orders All Stock and Featue & Options
    
    When Navigate to home page
    And User Click The "Test" Market watchlist
    And User Check The Current Stock to Market WatchList
    And User Click The "buy" Options in Market WatchList
    And User Modify The AMO Order
    And User All Type to Cancel The All AMO Orders
    
  