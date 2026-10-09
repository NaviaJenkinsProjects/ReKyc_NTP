Feature: Buyback Login Functionality and Access Flow

  Scenario: Successful login with valid Mobile Number and MPIN
    Given User is on the Buyback Login Page
    When  User enters valid UCC Number "63748379"
    And   User enters valid DOB "17/05/2001"
    And   User clicks the Login button
    Then  User should be successfully logged in
    And   User should see the Buyback Dashboard



