
Feature: Navia the Application

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

   
Scenario: User Verify The Market Depth - Stock - functionality

When Navigate To Home Page
And User click the search box
And User Search any "RELIANCE-A" Script by "BSE"
And User Navigate The "BSE" and "RELIANCE INDUSTRIES LTD" Stock 
And User Verify The "BSE" Market Depth Options "Today Open" Value
And User Verify The "BSE" Market Depth Options "Yesterday close" Value
And User Verify The "BSE" Market Depth Options Days Range "Low" Value
And User Verify The "BSE" Market Depth Options Days Range "High" Value
And User Verify The "BSE" Market Depth Options year Range "Low" Value
And User Verify The "BSE" Market Depth Options year Range "High" Value
And User Verify The "BSE" Market Depth Options Daily price range "Min" Value
And User Verify The "BSE" Market Depth Options Daily price range "Max" Value
Then User Close The Current Window

Scenario: User Verify The Market Depth - Stock - functionality

When Navigate To Home Page
And User click the search box
And User Search any "BEL-EQ" Script by "NSE"
And User Navigate The "NSE" and "BEL" Stock 
And User Verify The "NSE" Market Depth Options "Today Open" Value
And User Verify The "NSE" Market Depth Options "Yesterday close" Value
And User Verify The "NSE" Market Depth Options Days Range "Low" Value
And User Verify The "NSE" Market Depth Options Days Range "High" Value
And User Verify The "NSE" Market Depth Options year Range "Low" Value
And User Verify The "NSE" Market Depth Options year Range "High" Value
And User Verify The "NSE" Market Depth Options Daily price range "Min" Value
And User Verify The "NSE" Market Depth Options Daily price range "Max" Value
Then User Close The Current Window
Then  Next Page Shown



Scenario: User Verify The Market Depth - Feature - functionality

When Navigate To Home Page
And User click the search box
And User Search any "CRUDEOIL" Script by "MCX"
And User Navigate The "MCX" and "CRUDEOIL" Stock 
And User Verify The "MCX" Market Depth Options "Today Open" Value
And User Verify The "MCX" Market Depth Options "Yesterday close" Value
And User Verify The "MCX" Market Depth Options Days Range "Low" Value
And User Verify The "MCX" Market Depth Options Days Range "High" Value
Then User Close The Current Window


Scenario: User Verify The Market Depth - Stock - functionality

When Navigate To Home Page
And User Open The Current "Nifty 50" Stike 
And User Verify The "NFO" Market Depth Options "Today Open" Value
And User Verify The "NFO" Market Depth Options "Yesterday close" Value
And User Verify The "NFO" Market Depth Options Days Range "Low" Value
And User Verify The "NFO" Market Depth Options Days Range "High" Value
