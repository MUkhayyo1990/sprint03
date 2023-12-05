@Econsent
Feature: As a user should be able to put Econsent and move forward
  Background:
    Given the user has successfully logged in with valid credentials


  Scenario Outline:User puts his Econsent and move forward
    Given the user is on the eConsent page of the mortgage loan application
    When the user enters valid first name "<firstName>", last name "<lastName>", and email address "<email>"
    And the user reviews the necessary disclosures
    And the user selects the "Agree" radio button
    Then User should be able to move to Summary page

    Examples:
      |firstName   |lastName | email                |
      |John        | Doe     | john.doe@example.com |

  @regression
  @don't_agree
 Scenario: User disagrees with the terms and conditions

    And the email address is in a valid format
      |fairfax1988@gmail.com     | Doe     |  John   |
    And reads the necessary disclosures displayed on the page
    And explicitly selects the "Don't Agree" radio button
    Then the user should not be able to proceed, and an error should be displayed
#
#  Scenario: User tries to submit without providing required information
#    Given the user is on the E-Consent page of the mortgage application
#    When the user clicks on the Submit button without entering all required information
#    Then the user should see error messages indicating missing information
#
#  Scenario: User provides an invalid email address
#    Given the user is on the E-Consent page of the mortgage application
#    When the user enters their first name, last name, and an invalid email address
#    And reads the necessary disclosures displayed on the page
#    And selects the "Agree" radio button (selected by default)
#    And clicks on the Submit button
#    Then the user should see an error message indicating an invalid email address
#
#  Scenario: User navigates back to the previous page
#    Given the user is on the E-Consent page of the mortgage application
#    When the user clicks on the "Back" button
#    Then the user should be redirected to the previous page of the application