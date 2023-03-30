Feature: Portolo Login Functionality

  @sanity
  Scenario: Successful Login with valid credentials
    Given User launch Chrome browser
    When User open the URL "https://crisi.azurewebsites.net/"
    Then Click on the Signin Button
    When User enters the Email as "123" and Password as "Test@1234"
    And click on Login button
    Then Page title should be "Portolo | Home"
    When User click on Logout button
    And Close browser

  @regression
  Scenario Outline: Successful Login with valid credentials Data Driven Testing.
    Given User launch Chrome browser
    When User open the URL "https://crisi.azurewebsites.net/"
    And User enters the Email as "<Email>" and Password as "<Password>"
    And click on Login button
    Then Page title should be "Portolo | Home"
    When User click on Logout button
    And Close browser

    Examples: 
      | Email                             | Password      |
      | mayank.kaushik@keyideasglobal.com | Kaushik212021 |
      | test2@test.com                    | Test1234      |
