#Author: aru03.info@gmail.com
@formy @ui @smoke @regression
Feature: User Registration

  Scenario: Successful Registration of User in Formy App
    Given User is on formy form page
    When User enter user firstname
    And user enter user lastname
    And user enter jottitle
    And select education details
    And select the sex type
    And user provide total experience
    And select the current date
    And click on submit button
    Then user validate the success message
