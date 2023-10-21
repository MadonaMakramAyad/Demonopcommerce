@Regression
Feature: F02 | users could Login with his accounts
  Background: Navigate to Login Page
    Given user go to Login page

  Scenario: Guest could register with valid data successfully
    When user enters Email Address "test@gmail.com"
    And  User Clicks Password "123456"
    And  User Clicks on Login Button
    Then User Log in his account successfully

  Scenario Outline: Guest user could register with invalid data
    When User Enters email Address "<email>"
    And  User enters Password "<Password>"
    And  User Clicks on Login Button
    Then User Fail to go to his account
    Examples:
      | email            | Password |
      | Amit50@gmail.com | 123456   |
      | Amit90@gmail.com | asd123   |
