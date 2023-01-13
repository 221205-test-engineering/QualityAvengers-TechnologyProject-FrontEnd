Feature: Viewing all the games

  Scenario: Viewing all the games as a logged in user
    Given The user is logged in
    When The user presses the Games button
    Then The user will be able to see all the games

  Scenario: Viewing all the games as an unregistered user
    #This scenario will fail as any user must log in or register to view anything
    When The user presses the Games button
    Then The user will be able to see all the games