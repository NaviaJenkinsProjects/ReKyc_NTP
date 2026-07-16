Feature: Check the ReKyc Functionality in Dashboard


Scenario: Login Navia
    Given User Navigate to Navia 
    When User Click login with client code
    And User Enter Client Code
    And User  Enter Password
    And User Click Agree CheckBox
    And User Click Login button
    And User Click Otp Verification and enter manualy
    And User Click Login Again 
    
    
Scenario: User Check Rekyc all the Functionality

When Navigate to home page
When User mouse over Dashboard
And User click the Re-EKyc 
And User Scroll Down and Click Account Eye Icon
And User Click Phone Edit Icon and Check
And User Click Account Edit Icon
And User Click Bank Details Edit Icon
And User Select The Email Option
And User Click The Income Declaration Option
And User Click The DDPI 