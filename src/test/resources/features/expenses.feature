@expenses
Feature: As a user should be able to put expenses and move forward
  Background:
    Given the user has successfully logged in with valid credentials

  Scenario: User puts his expenses and move forward
    Given User in expenses page
    When User puts his/her expenses
    Then User should be able to move to Employement page