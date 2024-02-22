#Author: aru03.info@gmail.com
@regression @somke @ui @formy
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
      | Madhu     | Jayanna  | Software Engineer | College     | Male              | 2-4        |
      | Sunil     | R        | Software Engineer | College     | Prefer not to say | 2-4        |
      | Nihar     | Panda    | Software Engineer | Grad School | Male              | 0-1        |
      | Mastan    | B        | Software Engineer | College     | Prefer not to say | 5-9        |
      | Yogi      | M        | Software Engineer | Grad School | Female            | 10+        |
