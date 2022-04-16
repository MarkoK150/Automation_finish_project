Feature: Test any function on product page

  Scenario Outline: Test breadcrumbs
    Given I have open Automation practice site
    And I click button T-Shirt
    And Check tittle text on open page "<tittle1>"
    And I click "<item1>" on breadcrumbs
    And Check tittle text on open page "<tittle2>"
    And I click "<item2>" on breadcrumbs
    And Check tittle text on open page "<tittle3>"
    When I click "<item3>" on breadcrumbs
    Then I have open Home Page "<url>"
    Examples:
      | tittle1  | item1 | tittle2 | item2 | tittle3 | item3          | url                                     |
      | T-SHIRTS | Tops  | TOPS    | Women | WOMEN   | Return to Home | http://automationpractice.com/index.php |


  Scenario Outline: Test SignOut button
    Given I have open Automation practice site
    And I click Sign In Button
    And I enter email address for SignIn
    And I enter password for SignIn
    And I click button for SignIn
    And I have open My account page "<url>"
    When I click button SignOut
    Then I have open Authentication page "<url2>"
    Examples:
      | url                                                           | url2                                                                              |
      | http://automationpractice.com/index.php?controller=my-account | http://automationpractice.com/index.php?controller=authentication&back=my-account |

  Scenario Outline: Test function View on Product page
    Given I have open Automation practice site
    And I click on button "<item>" in footer
    When I chose List option in function View
    Then Check the List option is turned on
    Examples:
      | item         |
      | Best sellers |
      | Specials     |



  Scenario Outline:  Add to Wishlist - positive scenario
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
    And I click Register button
    And I click on button "<item>" in footer
    And I chose List option in function View
    And I click on button Add to Wishlist first Product
    And I turn off message
    And I go to My Account Page
    When I click button My Wishlist
    Then I check number product in Wishlist "<numProduct>"
    Examples:
      | email        | firstName | lastName | myAddress | city   | state   | zipCode | phoneNumber | addressAlias | item     | numProduct |
      | @hotmail.com | Marko     | Markovic | MyAdd     | MyCity | Georgia | 12345   | 12346578    | Alias        | Specials | 1          |


  Scenario Outline: Add to Wishlist - negative scenario
    Given I have open Automation practice site
    And I click on button "<item>" in footer
    And I chose List option in function View
    When I click on button Add to Wishlist first Product
    Then I check displayed message about Wishlist "<msg>"
    Examples:
      | item         | msg                                            |
      | Best sellers | You must be logged in to manage your wishlist. |