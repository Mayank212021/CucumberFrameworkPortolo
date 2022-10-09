Feature: Verify the email search functionality on User List Page.

  Background: Common  steps in all sceanrio
    Given User launch Chrome browser
    When User open the URL "https://portolo.azurewebsites.net/Account/Portolo"
    When User enters the Email as "mayank.kaushik@keyideasglobal.com" and Password as "Kaushik212021"
    And click on Login button
    Then Page title should be "Portolo - Portolo"


 @regression
  Scenario: Search user by Email on the user list page
    And click on Pages Menu Option
    And Select and Click User List option
    Then Enter "Test" in the Email field
    And click on search button
    Then User should found in the table
    And Close browser
