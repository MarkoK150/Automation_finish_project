Feature: Test footer

  Scenario Outline: Test newsletter with valid email address "<email>"
    Given I have open Automation practice site
    When I enter email address i filed Newsletter "<email>"
    Then Check displayed message about Newsletter "<msg>"
    Examples:
      | email        | msg                                                               |
      | @gmail.com   | Newsletter : You have successfully subscribed to this newsletter. |
      | @hotmail.com | Newsletter : You have successfully subscribed to this newsletter. |

  Scenario Outline: Test newsletter with invalid email address "<email>"
    Given I have open Automation practice site
    When I enter email address i filed Newsletter "<email>"
    Then Check displayed error message about Newsletter "<msg>"
    Examples:
      | email       | msg                                 |
      | gmail.com   | Newsletter : Invalid email address. |
      | @gmailcom   | Newsletter : Invalid email address. |
      | @gmail,com  | Newsletter : Invalid email address. |
      | @gmail..com | Newsletter : Invalid email address. |