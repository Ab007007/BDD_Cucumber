@non-ui @smoke
Feature: Generate Mulitplication Table

  Scenario: Table for a number 10 
    Given user has a 10
    When a table for numbers is generated
    Then the application prints the table generated

   Scenario: Table for a number 20 
    Given user has a 20
    When a table for numbers is generated
    Then the application prints the table generated

  Scenario: Table for a number 30 
    Given user has a 30
    When a table for numbers is generated
    Then the application prints the table generated

  Scenario: Table for a number 25 
    Given user has a 25
    When a table for numbers is generated
    Then the application prints the table generated

  Scenario: Table for a number 55 
    Given user has a 55
    When a table for numbers is generated
    Then the application prints the table generated

 