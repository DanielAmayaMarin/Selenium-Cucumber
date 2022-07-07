@Test
Feature: Test different actions on a sandbox paga.

  Rule: Se utiliza para exponer las regla que se desea probar

  Scenario: As a Test Enginner, I try out different actions on a sandbox page.
    Given I navigate to the sandbox page
    And select a value from the dropwdown


  Scenario: As a Test Engenner, I want to retrieve the value of an static table
    Given I navigate to the static table
    Then I can return the value i wanted
    And I can validate the table is displayed


  Scenario: As a Test Enginner, I want to validate that is present inside the list.
    Given I navigate to the list page
    When I search the list
    Then I can find the text in the list