Feature: Dashboard Tools Functionality

Scenario: Login Navia
    Given User Navigate to Navia 
    When User Click login with client code
    And User Enter Client Code
    And User  Enter Password
    And User Click Agree CheckBox
    And User Click Login button
    And User Click Otp Verification and enter manualy
    And User Click Login Again
    
    
        Scenario: Verify Bondss

    When Navigate to home page
    And User MouseOver Dashboard and Click Tools  
    And user Mouse Over The Element 
    And User Click Tools "Bonds"   
    And User Select The Bonds and close the window
    
    Scenario: Verify Stock Advisory

    When Navigate to home page
    And User MouseOver Dashboard and Click Tools  
    And user Mouse Over The Element 
    And User Click Tools "Stock Advisory"   
    And User Select The Stock Advisory and close the window
    
    Scenario: Verify Portfolio Health Check

    When Navigate to home page
    And User MouseOver Dashboard and Click Tools  
    And user Mouse Over The Element 
    And User Click Tools "Portfolio Health Check"   
    And User Select The Portfolio Health Check and close the window
    
    Scenario: Verify Corporate FDs

    When Navigate to home page
    And User MouseOver Dashboard and Click Tools  
    And user Mouse Over The Element 
    And User Click Tools "Corporate FDs"   
    And User Select The Corporate FDs and close the window
    

    
     Scenario: Verify InstaOptions

    When Navigate to home page
    And User MouseOver Dashboard and Click Tools  
    And user Mouse Over The Element 
    And User Click Tools "InstaOptions" 
    And User Select The InstaOptions and close the window
    
    
Scenario: Verify Ban List
    
    When Navigate to home page
    And User MouseOver Dashboard and Click Tools
    And user Mouse Over The Element
    And User Click Tools "Ban List"
    And User getting Securities in Ban Data
    And User Click Possible Entrance
    And User Click Possible Exits
    And User Search Symbols "BPCL" 
    And User Click Clear in Search Symbols
    And User Click All and getting data of stock , Previous and Current
    

    
Scenario: Verify Global

    When Navigate to home page
    And User MouseOver Dashboard and Click Tools
    And user Mouse Over The Element
    And User Click Tools "Global"  
    And User Verify Global Page
    
Scenario: Verify Buy Back
    
    When Navigate to home page
    And User MouseOver Dashboard and Click Tools
    And user Mouse Over The Element
    And User Click Tools "Buy Back"  
    And User Verify Buy Back Page
    

 
Scenario: Verify Demo Videos

    When Navigate to home page
    When User MouseOver Dashboard and Click Tools
    And user Mouse Over The Element
    And User Click Tools "Demo Videos" 
    And User Scroll Down and Up Verify Navia App Demo Videos Logo
    
        

    
  Scenario: Verify World Market

    When Navigate to home page
    And User MouseOver Dashboard and Click Tools
    And user Mouse Over The Element
    And User Click Tools "World Market"
    And User Select world indices , commodities ,  forex or crypto "Forex"
    And User Choose 1day , 1month , 3month , 1year , 5year or All "5Y"
    
    Scenario: Verify Blogs

    When Navigate to home page
    And User MouseOver Dashboard and Click Tools  
    And user Mouse Over The Element 
    And User Click Tools "Blogs" 
    And User Verify Blog Page Loading
    
    
  
    
    
    

    