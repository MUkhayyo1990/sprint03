 @personal_info
Feature: As a user should be able to fill out personal info and move next page

  Background:
    Given the user has successfully logged in with valid credentials

  Scenario: User completes personal info and move next window
    Given User on personal info page
    When User completes full personal info
    Then User should be able to move expense page