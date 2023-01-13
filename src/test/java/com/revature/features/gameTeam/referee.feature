Feature: Referee functionalities
  As a referee
  The referee wants to be able to login to the system and update their own personal information
  So that they can keep their profile up to date and manage their responsibilities as a referee

#10

  Scenario: Choose upcoming games to officiate
    Given the referee is logged in to the system
    When the referee click on the edit officiating choice button
    Then the referee should be on the officiating choice page
    When the referee input the id of the game he wants to officiate
    And click the submit button
    Then an alert says the application has been successful

  Scenario: Edit scorecard for a game
    Given the referee is logged in to the system
    When the referee clicks on the officiate games button
    Then the referee should see a list of games they've chosen to officiate
    When the referee clicks on the update scores button
    Then a modal should appear with a scorecard
    When makes changes to the scorecard
    And clicks the save button
    Then an alert says the score has been updated successfully
    Then the scorecard for the game should be updated with the referee's changes
