# language: en
# encoding: utf-8

Feature: Search

  @Search
  Scenario: Search for a tv show and check its tomatoes average
    Given the user searches for "Bridgerton"
    When the user selects it inside the tv shows area
    Then tomatoes average should be "83%"

  @Search
  Scenario: Search the highest rated movie starred by an Actor
    Given the user searches for "Angelina Jolie"
    When the user selects the actress name inside the celebrities section
    Then the highest rated movie starred by her should be "The Breadwinner (2017)"
