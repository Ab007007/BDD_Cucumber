Feature: addition2
@non-ui @uat
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