Feature: Downtime Login Validation - Navia Mobile App



  Scenario: Successful login with valid credentials during downtime
  
    When  User Enter Client Code "63748379"
    And   User Enter valid DOB "17/05/2001"
    And   User Click Agree CheckBoxs
    And   User Enter valid OTP
    Then  User should see Home Dashboard
    And   User should see Downtime message on Dashboard

    
    
    
    