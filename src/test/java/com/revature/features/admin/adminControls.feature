Feature: Admin functionalities
  Background: User logged in to the Admin
              Admin is on the Admin page

    Scenario: Create game series
      When Admin clicks create button
      Then Admin should see list of options
      When Admin clicks game series
      Then Admin is on the create game series page

    Scenario: Create new admins
      When Admin clicks admins button
      Then Admin is on the create new admin page

    Scenario: Create new referees
      When Admin clicks referees button
      Then Admin is on create new referees page

