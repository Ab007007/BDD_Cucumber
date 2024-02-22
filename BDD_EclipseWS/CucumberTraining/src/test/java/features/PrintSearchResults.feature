@google @ui @smoke
Feature: Google Searchword

  Scenario Outline: User Prints all the hyperlinks from Seach page
    Given user is on google search page
    When user enters <text> in the search box
    And click on search button
    Then google result are displayed
    And user print all the hyperlinks from the result page
    And close the browser

    Examples: 
      | text      |
      | synechron |
      | yahoo     |
      | amazon    |
      | ibm       |
      | wipro     |
      | oracle    |
