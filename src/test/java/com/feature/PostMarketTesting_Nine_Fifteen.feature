Feature: Navia Online Trading Market Post Market Testing 

Scenario: Login Navia
    Given User Navigate to Navia 
    When User Click login with client code
    And User Enter Client Code
    And User  Enter Password
    And User Click Agree CheckBox
    And User Click Login button
    And User Click Otp Verification and enter manualy
    And User Click Login Again
    

Scenario: User Check  - F&O- functionality     
    When Navigate to home page
    When User Search "NIFTY" in Searchbox
    And User Click Futures
    And User mouse over "NIFTY" and click add icon
    And Symbol Has been Added Successfully Notification Shown
    And User Click Clear in search box
    And User Click "NIFTY"
    And User Click F&O
    And User Click Cancel button in Ready Made Pop up
    And User Click LTP
    And User Verify the Fluctuating
    
Scenario: User Check  - Save Strategy- functionality     
    When Navigate to home page 
    When User Search "NIFTY" in Searchbox
    And User Click Futures
    And User mouse over "NIFTY" and click add icon
    And Symbol Has been Added Successfully Notification Shown
    And User Click Clear in search box
    And User Click "NIFTY"
    And User Click F&O
    And User Click Cancel button in Ready Made Pop up
    And User Click LTP
    And User Select any Call LTP Buy
    And User Select any Put LTP Sell
    And User Click Save Strategy
    And User enter Strategy Name "testdata36"
    And User Click Save 
    And User Click Strategy Message ok
    And User Click Place Order 
    
 Scenario: User Check  - Ready Made- functionality    
    When Navigate to home page 
    When User Search "NIFTY" in Searchbox
    And User Click Futures
    And User mouse over "NIFTY" and click add icon
    And Symbol Has been Added Successfully Notification Shown
    And User Click Clear in search box
    And User Click "NIFTY"
    And User Click F&O
    And User Click Cancel button in Ready Made Pop up
    And User Click LTP
    And User Select any Call LTP Buy
    And User Select any Put LTP Sell
    And User click read made  
    And User Choose Ready made Strategy categories "Bearish"
    And User Select Strategy under categories "Put Ratio Back Spread"
    
    