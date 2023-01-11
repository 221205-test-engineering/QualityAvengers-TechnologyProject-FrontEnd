Feature: Admin Schedules games

  Background:
    Given User logged in as Admin

  Scenario: Schedule all games
    Given Admin is on the Admin page
    When Admin clicks schedule game button
    Then Admin is on the game schedule page

  Scenario: Time and Location
    When Admin clicks venue list options
    Then Admin should be able to select one of the venues option
    When Admin clicks date button
    Then Admin should be able to select a date from the date panel appears
    Then Date and current time should appear at date input form
    When Admin selects a time to change
    Then Time should be changed based on the time selected
    When Admin clicks clear on the date panel
    Then The date form should clear the date and time selected
    When Admin clicks today button
    Then Todays date and current time should appear at date input form
    When Admin clicks the months and year button to change
    Then Months and years panel should appear
    When Admin select one each from the years and months
    Then The corresponding year and month should be selected at the date form

  Scenario: Sports and series
    When Admin clicks list of season
    Then Admin should be able select one of the seasons option
    When Admin clicks list of sports
    Then Admin should be able to select one of the sports

  Scenario: Teams
    When Admin clicks list of home teams
    Then Admin should be able to select one from the options
    When Admin clicks list of away team
    Then Admin should be able to select one of from the options
    When Admin clicks schedule button
    Then A message appears showing game scheduled should appear
    When Admin clicks back button
    Then Admin is on the Admin page



