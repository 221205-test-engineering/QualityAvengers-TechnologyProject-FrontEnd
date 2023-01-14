Feature: Create a season

  Scenario: Add new season
    Given User logged in as Admin
    Given Admin is on the Admin page
    When Admin clicks add season button
    Then Admin is on the season scheduler page
    Then Admin should be able to see current seasons
    When Admin inputs a new season
    """
    Summer 2023 Special Season Baseball
    """
    When Admin clicks add season submit button
    Then New scheduled season should appear at the end of list of seasons
    When Admin clicks add season back button
    Then Admin is on the Admin page
