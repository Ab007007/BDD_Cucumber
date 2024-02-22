@google @development 
Feature: Google Search

  Scenario: User Print all the auto suggestions
    Given pomuser is on google search page
    When pomuser enter synechron in the search box
    Then pomuser get auto suggestion
    And pomuser print all the auto suggestion
    And pomuser close the browser

  Scenario: User Print all the auto suggestions
    Given pomuser is on google search page
    When pomuser enter amazon in the search box
    Then pomuser get auto suggestion
    And pomuser print all the auto suggestion
    And fail the test
 