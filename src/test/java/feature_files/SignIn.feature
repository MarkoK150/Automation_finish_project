Feature: Create account

  Scenario Outline: Positive scenario - entered all mandatory fields
    Given I have open Automation practice site
    And I click Sign In Button
    And I enter email address for create new account "<email>"
    And I enter First Name "<firstName>"
    And I enter Last Name "<lastName>"
    And I enter password
    And I enter address "<myAddress>"
    And I enter City "<city>"
    And I chose State "<state>"
    And I enter zip code "<zipCode>"
    And I enter phone number "<phoneNumber>"
    And I enter address alias "<addressAlias>"
    When I click Register button
    Then I have open My account page "<url>"
    Examples:
      | email      | firstName | lastName | myAddress  | city    | state   | zipCode | phoneNumber | addressAlias | url                                                           |
      | @gmail.com | Marko     | Markovic | MojaAdresa | MojGrad | Georgia | 78945   | 123456789   | addressAlias | http://automationpractice.com/index.php?controller=my-account |


  Scenario Outline: Negative scenario - entered used email address
    Given I have open Automation practice site
    And I click Sign In Button
    When I enter e-mail address
    Then Check message "<msg>"
    Examples:
      | msg                                                                                                                  |
      | An account using this email address has already been registered. Please enter a valid password or request a new one. |


  Scenario Outline: Negative scenarios - form for registration
    Given I have open Automation practice site
    And I click Sign In Button
    And I enter email address for create new account "<email>"
    And I enter First Name "<firstName>"
    And I enter Last Name "<lastName>"
    And I enter password
    And I enter address "<myAddress>"
    And I enter City "<city>"
    And I chose State "<state>"
    And I enter zip code "<zipCode>"
    And I enter phone number "<phoneNumber>"
    And I enter address alias "<addressAlias>"
    When I click Register button
    Then Check show message "<messageError>"
    Examples:
      | email      | firstName | lastName | myAddress  | city | state   | zipCode | phoneNumber | addressAlias | messageError       |
      | @gmail.com |           |          |            |      | -       |         |             |              | There are 8 errors |
      | @gmail.com | Marko     |          |            |      | -       |         |             |              | There are 7 errors |
      | @gmail.com | Marko     |          |            |      | -       |         | 123456789   |              | There are 6 errors |
      | @gmail.com | Marko     | Markovic |            |      | -       | 1245    | 123456789   |              | There are 5 errors |
      | @gmail.com |           | Markovic |            |      | -       | 1245    | 123456789   |              | There are 6 errors |
      | @gmail.com | Marko     | Markovic | My address |      | Florida | 1245    | 123456789   | alias        | There are 2 errors |
      | @gmail.com | Marko     |          | address    | city | Florida | 12455   | 123456789   | alias        | There is 1 error   |
      | @gmail.com | Marko     | Markovic | address    | city | Florida | 12455   | 123456789   |              | There is 1 error   |


  Scenario Outline: Enter email address for create account - negative scenario
    Given I have open Automation practice site
    And I click Sign In Button
    When I enter email address for create new account "<email>"
    Then Check show message error "<errorMsg>"
    Examples:
      | email       | errorMsg               |
      | @gmail..com | Invalid email address. |
      | @gmail,.com | Invalid email address. |
      | @@gmail.com | Invalid email address. |











