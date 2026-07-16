Feature: Price Alert the Application

 Scenario: Login Navia
    Given User Navigate to Navia 
    When User Click login with client code
    And User Enter Client Code
    And User  Enter Password
    And User Click Agree CheckBox
    And User Click Login button
    And User Click Otp Verification and enter manualy
    And User Click Login Again
    Then  Next Page Shown
    
Scenario: User Check Default MarketWatch List View functionality

When Navigate To Home Page
And User Check The "NIFTY" Default MarketWatch "NSE" List
And User Check The "SENSEX" Default MarketWatch "BSE" List
And User Check The "BANKNIFTY" Default MarketWatch "NSE" List
And User Check The "FINNIFTY" Default MarketWatch "NSE" List  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    