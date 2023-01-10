Feature: Admin Navigation through view buttons

  Background: User logged in as Admin
              Admin is on the Admin page

    Scenario: View Games
      When Admin clicks view games button
      Then Admin is on the view games page
      Then Admin should see all the games scheduled
      When Admin clicks show referees button
      Then Shows referee details
      When Admin clicks close button
      Then Referee details should close
      When Admin clicks back button
      Then Admin is on the Admin page

    Scenario: View Seasons
      When Admin clicks view seasons button
      Then Admin is on the view season page
      Then Admin should see all the seasons
      When Admin clicks back button
      Then Admin is on the Admin home page

    Scenario: View Venues
      When Admin clicks view venues button
      Then Admin is on the view venue page
      Then Admin should see all the venues
      When Admin clicks back button
      Then Admin is on the Admin page



