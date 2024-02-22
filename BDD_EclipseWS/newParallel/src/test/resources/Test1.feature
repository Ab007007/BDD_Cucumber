Feature: Google Search

  Scenario: User Print all the auto suggestions
    Given user is on google search page
    When user enter synechron in the search box
    Then google displayes auto suggestion
    And user print all the auto suggestion
    And close google browser

  Scenario: User Prints all the hyperlinks from Seach page
    Given user is on google search page
    When user enter synechron in the search box
    And click on search button
    Then google results are displayed
    And user prints all the hyperlinks from the results page
    And close google browser

