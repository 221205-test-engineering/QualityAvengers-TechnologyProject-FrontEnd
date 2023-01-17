Feature: Player functionalities
  As a player
  The player wants to be able to login to the system and update their own personal information
  So that they can keep their profile up to date and manage their responsibilities as a player

#5

  Scenario: View captains of each team
    Given the player is logged in to the system
    Then the player is on the player page
    When the player clicks on the team application button
    Then a list of teams should be displayed
    When the player clicks on see the captain
    Then the team's captain information should be displayed in a section
    When the player clicks on the close button
    Then the section disappear

#4

  Scenario: Apply to join a team
    Given the player is logged in to the system
    Given the player is on the team application page
    Given the player is not in a team
    Then a list of teams should be displayed
    When the player select a team from the dropdown menu
    And clicks apply
    Then an alert says the application has been successful
    Then the application status changes to pending

#2