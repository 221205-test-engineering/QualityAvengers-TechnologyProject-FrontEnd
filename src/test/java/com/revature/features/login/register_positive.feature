Feature: Register new player

Scenario: Register with valid inputs
    Given the user is on the register page
    When the user types in itsHighNoon for their username
    When the user types in deadEye for their password
    When the user types in 80 for their height
    When the user types in 200 for their weight
    When the user clicks on the checkbox next to display biometrics
    When the user clicks submit
    Then the user should see an alert saying registration successful

