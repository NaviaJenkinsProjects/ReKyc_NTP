Feature: Check the Analysis Functionality in Dashboard


Scenario: Login Navia
    Given User Navigate to Navia 
    When User Click login with client code
    And User Enter Client Code
    And User  Enter Password
    And User Click Agree CheckBox
    And User Click Login button
    And User Click Otp Verification and enter manualy
    And User Click Login Again
    
Scenario: User Check Analysis in Dashboard

When Navigate to home page
#When User mouse over Dashboard
#And User click the Analysis
And User Select The "RELIANCE-EQ" Stock and Naviagate to Analysis page 
#And User click filter 
#And User Filter Dividend "1"
#And User Filter Value "2"
#And User Filter Future "3"
#And User Filter Past "4"
#And User Filter Health "5"
#And User Click View More 
##And User Scroll Down to the End
#And User Click Stock Overview
And User Click Recent News & Updates
And User Click About the Company
And User Click Fundamental Summary
And User Click Key valuation Music
And User Click Price to earnings ratio vs peers
And User Click Price to earnings ratio vs industry
And User Click Earnings and Revenue History
And User Click Past Earnings Growth Earnings
And User Click Return on Equity
And User Scroll Down to the End
And User Click Ownership
And User Scroll Down to the End
And User Click Leadership Team
And User Scroll Down to the End
And User Click Management
And User Scroll Down to the End
And User Click Dividend
And User Scroll Down to the End
And User Click Balance Sheet
And User Scroll Down to the End
And User Click Financial Health
And User Scroll Down to the End
And User Click Return on Assets
And User Scroll Down to the End
And User click Trading View
