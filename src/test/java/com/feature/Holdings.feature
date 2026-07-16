Feature: Verify the Holding Calculations

Scenario: Calculate Current , Investment , Total P/V Value and P/V
Given User Navigate to Navia 
    When User Click login with client code
    And User Enter Client Code
    And User  Enter Password
    And User Click Agree CheckBox
    And User Click Login button
    And User Click Login Again
  
  Scenario: Calculate Current  
    When Navigate to home page
    And User Click Holdings
    And Verify Adding All Stock Investment Value is Equal to Investment Value
    And Verify Adding All Stock Curr Value is Equal to Current Value
    And Verify Adding All Stock P/L Value is Equal to P/L
    And Verify Adding All Stock Today P/L Value is Equal to Today P/L Value
    And Verify Calculate Current Value Subtract Investment Value Its Equal to P/L Value
    And Verify The All Stock Average Price Value Check
    And Verify The All Stock Current Value Check
    And Verify The All Stock P/L Value Check
    And Verify The All Stock Todays P/L Value Check
    And Verify The All Stock Info Percentage Value Check
    And Verify The All Stock Add The Basket
    And Verify The All Stock "BUY" Value Check in Holding Page
    And Verify The All Stock "SELL" Value Check in Holding Page
    And Verify The All Stock Filter Options and Top Options