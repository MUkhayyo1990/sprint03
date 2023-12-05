@pre_approval
Feature: As a user applying for a mortgage loan, I want to fill out PreApproval Details

  Background:
    Given the user has successfully logged in with valid credentials

  Scenario: User tries to fillout pre approval window and land next page
    Given User on pre-approval page
    When User fills out personal info
    Then User should be able to move next page

