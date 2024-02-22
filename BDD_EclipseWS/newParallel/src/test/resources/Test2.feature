Feature: User Registration

  Scenario Outline: Successful Registration of User in Formy App
    Given User is on formy form page
    When User enter firstname <firstname>
    And user enter lastname <lastname>
    And user enter jobtitle <jobtitle>
    And select <education> details
    And select the <sex> type
    And user provide total <experience>
    And select the current date
    And click on submit button
    Then user validate the success message

    Examples: 
      | firstname | lastname | jobtitle          | education   | sex               | experience |
      | Aravinda  | B        | Trainer           | College     | Male              | 10+        |
      | Basava    | Raj      | Employee          | High School | Male              | 5-9        |
    