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
    
Scenario: User Verify The SENSEX Current - Options - Calculation

When Navigate To Home Page to Navia
And User Click The Current "Sensex" Options
And User Verify The Margin,Charges and Available Margin Optins "BUY" Values
And User Verify The Margin,Charges and Available Margin Optins "SELL" Values
And User Delete The Stock In Watchlist
Then User Verify The Value Details    

Scenario: User Verify The NIFTY Current - Options - Calculation

When Navigate To Home Page to Navia
And User Click The Current "Nifty 50" Options
And User Verify The Margin,Charges and Available Margin Optins "BUY" Values
And User Verify The Margin,Charges and Available Margin Optins "SELL" Values
And User Delete The Stock In Watchlist
Then User Verify The Value Details

Scenario: User Verify The NIFTY Any - Equity - Calculation

When Navigate To Home Page to Navia
And User Select The "NIFTY" Option button
And User Select The Any Stock "AXISBANK-EQ" For NSE
And User Verify The Margin,Charges and Available Margin Optins "BUY" Values
And User Verify The Margin,Charges and Available Margin Optins "SELL" Values
Then User Verify The Value Details

Scenario: User Verify The SENSEX Any - Equity - Calculation

When Navigate To Home Page to Navia
And User Select The "SENSEX" Option button
And User Select The Any Stock "HDFCBANK-A" For BSE
And User Verify The Margin,Charges and Available Margin Optins "BUY" Values
And User Verify The Margin,Charges and Available Margin Optins "SELL" Values
Then User Verify The Value Details

Scenario: User Verify The NIFTY Current - Future - Calculation

When Navigate To Home Page to Navia
And User Click The Current "NIFTY" Future Option 
And User Select The Current "NSE" Future Option
And User Verify The Margin,Charges and Available Margin Futute "BUY" Values
And User Verify The Margin,Charges and Available Margin Futute "SELL" Values
Then User Verify The Value Details

Scenario: User Verify The SENSEX Current - Future - Calculation

When Navigate To Home Page to Navia
And User Click The Current "SENSEX" Future Option 
And User Select The Current "BSE" Future Option
And User Verify The Margin,Charges and Available Margin Futute "BUY" Values
And User Verify The Margin,Charges and Available Margin Futute "SELL" Values
Then User Verify The Value Details

Scenario: User Verify The MCX Current - Future - Calculation

When Navigate To Home Page to Navia
And User Click The Current "MCX" Future Option 
And User Select The Current "NSE" Future Option
And User Verify The Margin,Charges and Available Margin Futute "BUY" Values
And User Verify The Margin,Charges and Available Margin Futute "SELL" Values
Then User Verify The Value Details













#Scenario: User Verify The NSE Stock - Margin - Calculation
#
#When Navigate To Home Page to Navia
#And User Select The "NIFTY" Option button
#And User Select The Any Stock "ADANIPORTS" For NSE
#And User Verify The "ADANIPORTS" Stock Buy Values
#And User Verify The "ADANIPORTS" Stock Sell Values
#Then User Verify The Value Details
#
#Scenario: User Verify The BSE Stock - Margin - Calculation
#
#When Navigate To Home Page to Navia
#And User Select The "SENSEX" Option button
#And User Select The Any Stock "AXISBANK" For BSE
#And User Verify The "AXISBANK" Stock Buy Values
#And User Verify The "AXISBANK" Stock Sell Values
#Then User Verify The Value Details

