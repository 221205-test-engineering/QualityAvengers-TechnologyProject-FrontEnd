Feature: Admin Schedules games

  Background:
    Given User logged in as Admin

  Scenario: Schedule all games
    Given Admin is on the Admin page
    When Admin clicks schedule game button
    Then Admin is on the game schedule page
    When Admin select one of the venues options
    When Admin inputs a date to the date box
    When Admin select one of the season from the options
    When Admin select one of the sports from the options
    When Admin select one from the list of home teams
    When Admin select one from the list of away team
    When Admin clicks schedule button
#    Then A message appears showing game scheduled
    When Admin clicks back button from game schedule page
    Then Admin is on the Admin page



