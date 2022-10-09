Feature: Portolo Login Functionality

  @sanity
  Scenario: Successful Login with valid credentials
    Given User launch Chrome browser
    When User open the URL "https://portolo.azurewebsites.net/Account/Portolo"
    When User enters the Email as "mayank.kaushik@keyideasglobal.com" and Password as "Kaushik212021"
    And click on Login button
    Then Page title should be "Portolo - Portolo"
    When User click on Logout button
    And Close browser

  @regression
  Scenario Outline: Successful Login with valid credentials Data Driven Testing.
    Given User launch Chrome browser
    When User open the URL "https://portolo.azurewebsites.net/Account/Portolo"
    And User enters the Email as "<Email>" and Password as "<Password>"
    And click on Login button
    Then Page title should be "Portolo - Portolo"
    When User click on Logout button
    And Close browser

    Examples: 
      | Email                             | Password      |
      | mayank.kaushik@keyideasglobal.com | Kaushik212021 |
      | test2@test.com                    | Test1234      |
