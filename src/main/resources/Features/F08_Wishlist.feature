@Regression
Feature:F08 | User select Wishlist
Scenario: verify that user can choose his favour product
  Given   User Search for products
  When    user clicks on wishlist
  Then   User confirm adding product to wishlist

  Scenario: verify that user can add his favour product in wishlist
    Given   User Search for products
    When    user clicks on wishlist
    And    User wait to be sure product to add
    And   User go to Wishlist Tab
    Then  User make sure about the quantity needed