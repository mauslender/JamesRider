@android
Feature: Profile

  Scenario: Edit profile
    Given I am on the Start screen
    And I click on the Get Started button
    And I am on the login page
    When I click on the Country Code dropdown
    When I set the Country Code to " Afghanistan (+93)"
    When I enter phone number "701111112"
    And I click on the Continue button
    And I enter validation code "123456"
    And I click on the Continue button
    Then I should see Permissions page
    When I click on the Location permission button
    And I click on The Notifications permission button
    And I click on the Continue button on the permissions page
    Then I should see the Main screen
    When I click on the Main Menu button
    And I click on the current profile name
    And I update the First Name to "Matias"
    And I update the Last Name to "Auslender"
    And I click on the Done button
    Then I should see that the current profile name is "Matias Auslender"
