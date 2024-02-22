@formy
Feature: Register multiple Users

	@regression @ui
  Scenario: Register the user and validate success message
    Given User is on formy form page
    When user enters and submit all the required values and validate success messsage as list
      | AravindaList | B       | Trainer           | College     | Male              | 10+ |
      | BasavaList   | Raj     | Employee          | High School | Male              | 5-9 |
      | MadhuList    | Jayanna | Software Engineer | College     | Male              | 2-4 |
      | SunilList    | R       | Software Engineer | College     | Prefer not to say | 2-4 |
      | NiharList    | Panda   | Software Engineer | Grad School | Male              | 0-1 |
      | MastanList   | B       | Software Engineer | College     | Prefer not to say | 5-9 |
      | YogiList     | M       | Software Engineer | Grad School | Female            | 10+ |
    And close the browser

	@smoke @ui
  Scenario: Register the user and validate success message
    Given User is on formy form page
    When user enters and submit all the required values and validate success messsage as Map
      | firstname | lastname | jobtitle          | education   | sex               | experience |
      | Aravinda  | B        | Trainer           | College     | Male              | 10+        |
      | Basava    | Raj      | Employee          | High School | Male              | 5-9        |
      | Madhu     | Jayanna  | Software Engineer | College     | Male              | 2-4        |
      | Sunil     | R        | Software Engineer | College     | Prefer not to say | 2-4        |
      | Nihar     | Panda    | Software Engineer | Grad School | Male              | 0-1        |
      | Mastan    | B        | Software Engineer | College     | Prefer not to say | 5-9        |
      | Yogi      | M        | Software Engineer | Grad School | Female            | 10+        |
    And close the browser
