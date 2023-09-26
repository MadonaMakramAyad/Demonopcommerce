@Regression
Feature: F03 Currencies | users could choose his currencies
  Background: Navigate to currencies categories
    Given  User got to Currencies Categories
Scenario: Guest could choose his currencies successfully
  When      User Select from Currencies
  And      User finds four Products with Euro currencies
  Then     User Checks that all products contains Euro sign