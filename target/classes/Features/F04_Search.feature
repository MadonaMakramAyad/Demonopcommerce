@Regression
Feature: F03 Search | users could search items in home Page
  Background: Navigate to Search Page
    Given  User go to home Page and Click on Search Bar

  Scenario Outline: Verify that User can search for "book" items
    When    In the search Bar, User Search for "<items>"
    And    User Clicks on Search Bar
    Then   User go to List of "<items>"
    Examples:
      | items  |
      | book   |
      | laptop |
      | nike   |
  Scenario Outline: Verify that Page contains Sku
    When    In the search Bar, User Search for "<items>"
    And    User Clicks on Search Bar
    And    User go to List of "<items>"
    And   User clicks on each "<items>"
    Then  User verify existence for Sku
    Examples:
      | items     |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |