Feature: Buy product

  Scenario Outline: I buy product "<product>"
    Given I have open Automation practice site
    And I click Sign In Button
    And I enter email address for SignIn
    And I enter password for SignIn
    And I click button for SignIn
    And I enter product name "<product>" in search field
    And I add to cart product
    And I click button Proceed to checkout
    And I continue shopping and I click Proceed to checkout
    And Click button Proceed to checkout again
    And Click I agree to the terms of service and click proceed to checkout
    And Before paying, I check the product "<product> "in the cart and choose Pay by check (payment method)
    When I click button confirm my order
    Then check displayed message about payment "<msg>"
    Examples:
      | product                     | msg                                 |
      | Blouse                      | Your order on My Store is complete. |
      | Faded Short Sleeve T-shirts | Your order on My Store is complete. |


  Scenario Outline: I Buy product "<product>" - another way
    Given I have open Automation practice site
    And I click Sign In Button
    And I enter email address for SignIn
    And I enter password for SignIn
    And I click button for SignIn
    And I enter product name "<product>" in search field
    And I chose product and click button more
    And Quantity product change to two and I click button Add to cart
    And I click button Proceed to checkout
    And I continue shopping and I click Proceed to checkout
    And Click button Proceed to checkout again
    And Click I agree to the terms of service and click proceed to checkout
    And Before paying, I check the product "<product>"in the cart and choose Pay by check (payment method)
    When I click button confirm my order
    Then check displayed message about payment "<msg>"
    Examples:
      | product                     | msg                                 |
      | Blouse                      | Your order on My Store is complete. |
      | Faded Short Sleeve T-shirts | Your order on My Store is complete. |


  Scenario Outline: I buy product using filters
    Given I have open Automation practice site
    And I click Sign In Button
    And I enter email address for SignIn
    And I enter password for SignIn
    And I click button for SignIn
    And I click item "<item>" in category "<category>"
    And In filter "<nameFilter>" I click "<optionFilter>"
    And In filter "<nameFilter2>" I click "<optionFilter2>"
    And I add to cart product
    And I click button Proceed to checkout
    And I continue shopping and I click Proceed to checkout
    And Click button Proceed to checkout again
    And Click I agree to the terms of service and click proceed to checkout
    And I choose Pay by check (payment method)
    When I click button confirm my order
    Then check displayed message about payment "<msg>"
    Examples:
      | item           | category | nameFilter | optionFilter | nameFilter2  | optionFilter2 | msg                                 |
      | Summer Dresses | Women    | Size       | M            | Compositions | Viscose       | Your order on My Store is complete. |
      | Summer Dresses | Women    | Size       | M            | Availability | In stock       | Your order on My Store is complete. |


  Scenario Outline: Add to cart product "<product>" and delete product from cart
    Given I have open Automation practice site
    And I enter product name "<product>" in search field
    And I add to cart product
    And I click button Continue shopping
    And I click to Shopping cart
    And I check number product in cart "<numProduct>"
    And I delete product in cart
    When I click to Shopping cart
    Then Check Shopping cart "<msg>"
    Examples:
      | product | numProduct | msg                          |
      | Blouse  | 1 Product  | Your shopping cart is empty. |
