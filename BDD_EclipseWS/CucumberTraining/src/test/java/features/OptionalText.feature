@uat
Feature: Google Searchword

  Scenario: User Prints all the hyperlinks from Seach page
    Given user is on google search page
    When user enters "Synechron work life balance" in the search box
    And click on search button
    Then google result are displayed
    And user print all the hyperlinks from the result page
    And close the browser
