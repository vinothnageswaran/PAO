Feature: Vocera login

  Scenario: Vocera login Successful
    When I open "https://pch-vmp-test.health.wa.gov.au/" website
    Then I login using credentials "he119941" and "Password123"
    Then Click "Submit"
    Then verify the "Logon"

   Scenario Outline: Vocera login unsuccessful
    Given I open "https://pch-vmp-test.health.wa.gov.au/" website
  	When I login using credentials "<Username>" and "<Password>"
    And Click "Submit"
    Then verify the "Logon"
    
    Examples:
    |Username|Password1|
    |he119941|Password123|


    
    
    
    
    
    
    
    