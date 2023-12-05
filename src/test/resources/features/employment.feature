@employment
Feature: As a user applying for a mortgage loan, I want to provide my employment
  and income details to the bank, so that they can evaluate my eligibility for
  a loan.

  Background:
    Given the user has successfully logged in with valid credentials

  Scenario: User puts his/her employment and income info
    Given User in Employement page
    When User completes employement and income info
    Then User should be able to move to credit report page