@Regression
Feature: F01 Register | users could register with new accounts
  Background: Navigate to Register Page
    Given user go to register page

  Scenario: Guest could register with valid data successfully
    When user Selects Gender
    And  User enters First name "automation5"
    And  User enters Last name "tester5"
    And  User Selects Day Of Birth "10"
    And  USer Selects Month of Birth "September"
    And  User Selects Year of Birth "1994"
    And  User Enters email Address "test@gmail.com"
    And  User enters Password "123456"
    And  User enters confirm password "123456"
    And  User Clicks on Register Button
    Then User creates his account successfully

