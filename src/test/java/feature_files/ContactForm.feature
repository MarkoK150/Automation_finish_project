Feature: Test Contact Form on Automation practice

  Scenario Outline: Positive scenario
    Given I have open Automation practice site
    And I click on ContactUs button
    And Subject Heading - choose option "<option>"
    And I enter email address "<email>"
    And I enter ordered reference "<orderedReference>"
    And I write message "<textMessage>"
    When I click Send button
    Then Check displayed message after send message "<messageContactUs>"
    Examples:
      | option           | email       | orderedReference | textMessage | messageContactUs                                     |
      | Webmaster        | a@gmail.com | text             | text text   | Your message has been successfully sent to our team. |
      | Webmaster        | a@gmail.com |                  | text text   | Your message has been successfully sent to our team. |
      | Customer service | a@gmail.com | text             | text text   | Your message has been successfully sent to our team. |
      | Customer service | a@gmail.com |                  | text text   | Your message has been successfully sent to our team. |


  Scenario Outline: Negative scenario
    Given I have open Automation practice site
    And I click on ContactUs button
    And Subject Heading - choose option "<option>"
    And I enter email address "<email>"
    And I write message "<textMessage>"
    When I click Send button
    Then Check displayed error message "<messageContactUs>"
    Examples:
      | option       | email        | textMessage | messageContactUs                                |
      | -- Choose -- | a@gmail.com  | text text   | Please select a subject from the list provided. |
      | -- Choose -- |              | text text   | Invalid email address.                          |
      | Webmaster    | gmail.com    | text text   | Invalid email address.                          |
      | Webmaster    | a@gmail.com  |             | The message cannot be blank.                    |
      | -- Choose -- |              |             | Invalid email address.                          |
      | -- Choose -- | gmail.com    |             | Invalid email address.                          |
      | Webmaster    | a@gmail..com | text text   | Invalid email address.                          |



