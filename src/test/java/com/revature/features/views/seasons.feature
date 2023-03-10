Feature: Viewing all the seasons

  Scenario: Viewing all the schedules as a logged in user
    Given The user is logged in
    When The user presses the Seasons button
    Then The user will be able to see all the seasons

  #Scenario: Viewing all the schedules as an unregistered user
    #This scenario will fail as any user must log in or register to view anything
    #When The user presses the Seasons button
    #Then The user will be able to see all the seasons