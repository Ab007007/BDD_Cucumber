@regression @non-ui @uat
Feature: Addition of two numbers

  Scenario Outline: Successfull Addition
    Given user has two numbers
    When user add <num1> and <num2>
    Then sum of two numbers is <result>

    Examples: 
      | num1 | num2 | result |
      |    4 |    6 |     10 |
      |   14 |   26 |     40 |
      |    4 |  633 |    637 |
      |  444 |    6 |    450 |
      |  4.4 |  6.5 |   10.9 |
      |  454 |  6.6 |  460.6 |

  Scenario: UnSuccessfull Addition
    Given user has two numbers
    When user add 55 and 55
    Then sum of two numbers is not equal to 122.0

  Scenario: Division Demo
    Given user has two numbers
    When user divide 15 and 12
    Then user may get float 1.0

  Scenario: Successfull Addition
    Given user has two numbers
    When user add 3.5 and 5.5
    Then sum of two numbers is 9.0
