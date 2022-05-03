Feature: Make a bouquet
  As a Customer
  I want to buy a bouquet
  So that I can make a present for someone I love

  Scenario: Make a simple bouquet
    Given "rose" costs 1.50 "eur"
    And crafting costs 35%
    When I request a bouquet with 12 "roses"
    Then the total price is 24.3 "eur"
