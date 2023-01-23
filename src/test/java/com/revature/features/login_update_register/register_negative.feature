Feature: Register new player

  Scenario: Register with invalid inputs
    Given the user is on the register page
    When the user types in " " for their username
    When the user clicks submit
    Then the user should see an alert saying fields incomplete
