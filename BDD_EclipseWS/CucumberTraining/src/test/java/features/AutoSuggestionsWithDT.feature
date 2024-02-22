Feature: Print Suggestions from Google
@regression @ui @smoke @google
  Scenario: User Print all the auto suggestions as Map
    Given user is on google search page
    When user enter text in searchbox and print all the suggestion as Map
      | companyName |
      | IBM         |
      | Wipro       |
      | Synechron   |
      | Google      |
      | Amazon      |
    And close the browser
@regression @ui @smoke @google
  Scenario: User Print all the auto suggestions as List
    Given user is on google search page
    When user enter text in searchbox and print all the suggestion as List
      | IBM       |
      | Wipro     |
      | Synechron |
      | Google    |
      | Amazon    |
    And close the browser
