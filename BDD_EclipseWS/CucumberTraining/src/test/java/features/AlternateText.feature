@regression @ui @uat @google
Feature: Google Searchword

  Scenario: User Prints all the hyperlinks from Seach page
    Given user is on yahoo search page
    When user enters "Synechron" in the search box
    And click on search button
    Then yahoo result are displayed
    And user print all the hyperlinks from the result page
    And close the browser
