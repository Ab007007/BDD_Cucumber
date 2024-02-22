@google
Feature: Print Suggestions from Google

  Background: 
    Given user is on google search page
	@smoke @ui
  Scenario: User Print all the auto suggestions as Map
    When user enter text in searchbox and print all the suggestion as Map
      | companyName |
      | IBM         |
      | Wipro       |
      | Synechron   |
      | Google      |
      | Amazon      |
    And close the browser

	@regression
  Scenario: User Print all the auto suggestions as List
    When user enter text in searchbox and print all the suggestion as List
      | IBM       |
      | Wipro     |
      | Synechron |
      | Google    |
      | Amazon    |
    And close the browser
