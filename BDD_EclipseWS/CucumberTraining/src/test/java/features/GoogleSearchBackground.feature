@google @ui @regression
Feature: Google Search

  Background: 
    Given user is on google search page

  Scenario: User Print all the auto suggestions
    When user enter "synechron" in the search box
    Then google displayes auto suggestion
    And user print all the auto suggestion
    And close the browser

  Scenario: User Prints all the hyperlinks from Seach page
    When user enter "synechron" in the search box
    And click on search button
    Then google results are displayed
    And user prints all the hyperlinks from the results page
    And close the browser

  Scenario: User Prints all the hyperlinks that starts with Synechron
    When user enter "synechron" in the search box
    And click on search button
    Then google results are displayed
    And user prints only hyperlinks which are starting with "synechron"
    And close the browser

  Scenario: User Print all the auto suggestions
    When user enter "IBM" in the search box
    Then google displayes auto suggestion
    And user print all the auto suggestion
    And close the browser

  Scenario: User Prints all the hyperlinks that starts with "Wipro"
    When user enter "Wipro" in the search box
    And click on search button
    Then google results are displayed
    And user prints only hyperlinks which are starting with "Wipro"
    And close the browser
