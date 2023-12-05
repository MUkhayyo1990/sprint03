@credit_Report
Feature: As a user should be able to put CreditReport and move forward
  Background:
    Given the user has successfully logged in with valid credentials

  Scenario: User puts his CreditReport and move forward
    Given User in CreditReport page
    When User puts his/her CreditReport
    Then User should be able to move to Econsent page