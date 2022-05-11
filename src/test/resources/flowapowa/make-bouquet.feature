Feature: Make a bouquet
  As a Customer
  I want to buy a bouquet
  So that I can make a present for someone I love

  Guidelines:
    Currency euros. We don't use currency for simplicity.
    Interface of FlowaPowa::main accepts recipe strings like "rose:12;daisy:15;foliage:1;"
    Flower names in singular
    Sort of Hexagonal Architecture

  Scenario: Make a simple bouquet
    Given "rose" costs 1.50
    And crafting adds 35%
    When I request a bouquet with 12 "rose"
    Then the receipt looks like
    """
    Rose        12   1.50   18.00
    Crafting                 6.30
    -----------------------------
    Total                   24.30

    """

  Scenario: Make a complex bouquet
    Given "rose" costs 1.50
    And "daisy" costs 0.80
    And crafting adds 35%
    When I request a bouquet with 12 "rose" and 16 "daisy"
    Then the receipt looks like
    """
    Rose        12   1.50   18.00
    Daisy       16   0.80   12.80
    Crafting                10.78
    -----------------------------
    Total                   41.58

    """
