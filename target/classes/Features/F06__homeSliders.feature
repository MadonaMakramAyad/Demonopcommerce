@Regression
Feature: P06 HomeSlider| user show slider for seeing products

 Scenario: first slider is clickable on home page
    Given   User select first slider
    When    User go to on first products page
    Then    User order number of iPhone

 Scenario: Second slider is clickable on home page
  Given   User select Second slider
  When    User go to on second products page
  Then    User order number of nokia lamia