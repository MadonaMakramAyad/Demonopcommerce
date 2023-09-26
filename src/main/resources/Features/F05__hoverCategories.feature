@Regression
Feature: F01 hover | users hover over Menu products
  Background: Navigate to home Page
    Given User go to home Page and click on menu
  Scenario: Verify that user choose from the Menu
   When   User hover over Computer
   And   User  choose desktop tab
   And   User Open desktop page
   Then  User Sure over them