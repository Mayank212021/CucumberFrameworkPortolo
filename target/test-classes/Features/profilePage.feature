Feature: Edit Profile Functionality

  Background: Common  steps in all sceanrio
    Given User launch Chrome browser
    When User open the URL "https://portolo.azurewebsites.net/Account/Portolo"
    When User enters the Email as "mayank.kaushik@keyideasglobal.com" and Password as "Kaushik212021"
    And click on Login button
    Then Page title should be "Portolo - Portolo"

  @sanity
  Scenario: Change the City of the user
    And click on My Pages Menu Option
    And Select and Click on My Profile option
    And Click on the Edit button
    Then Change the City  to "Chandigrah"
    And Click on Apply button
    When User click on Logout button
    And Close browser

 