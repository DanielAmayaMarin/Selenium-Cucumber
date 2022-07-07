@Test
Feature: Test Google search functionality

  Scenario Outline: As a user I enter a search criteria in Google
    Given I am on the Google search page
    When I enter a search criteria <text>
    And click on the search button
    Then the results match the criteria <text>

    Examples:
    |text|
    |Argentina|