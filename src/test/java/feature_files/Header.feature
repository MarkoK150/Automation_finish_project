Feature: Test Header on Automation practice site

  Scenario Outline: Testing menu Item "<item>" in Category "<category>"
    Given I have open Automation practice site
    When I click item "<item>" in category "<category>"
    Then Check tittle text "<tittleText>"

    Examples:
      | category | item            | tittleText      |
      | Women    | Tops            | TOPS            |
      | Women    | T-shirts        | T-SHIRTS        |
      | Women    | Blouses         | BLOUSES         |
      | Women    | Dresses         | DRESSES         |
      | Women    | Casual Dresses  | CASUAL DRESSES  |
      | Women    | Evening Dresses | EVENING DRESSES |


  Scenario Outline: Test button Dresses
    Given I have open Automation practice site
    When I hover button Dresses and click to item "<item>"
    Then Check tittle text on open page "<tittle>"
    Examples:
      | item            | tittle          |
      | Casual Dresses  | CASUAL DRESSES  |
      | Evening Dresses | EVENING DRESSES |
      | Summer Dresses  | SUMMER DRESSES  |


  Scenario: Test button T-Shirt
  Given I have open Automation practice site
  When I click button T-Shirt
  Then Check tittle text on open page "T-SHIRTS"



  Scenario Outline: Test search field with existing product "<product>"
    Given I have open Automation practice site
    And I enter product name "<product>" in search field
    Then Check results "<result>"
    Examples:
      | product                     | result                   |
      | FADED SHORT SLEEVE T-SHIRTS | Showing 1 - 1 of 1 item  |
      | Blouse                      | Showing 1 - 1 of 1 item  |
      | PRINTED CHIFFON DRESS       | Showing 1 - 2 of 2 items |
      | Printed Dress               | Showing 1 - 5 of 5 items |


  Scenario Outline: Test search field with not-existing product "<product>"
    Given I have open Automation practice site
    And I enter product name "<product>" in search field
    Then Check results for not-existing product "<result>"
    Examples:
      | product  | result                     |
      | Product1 | 0 results have been found. |
