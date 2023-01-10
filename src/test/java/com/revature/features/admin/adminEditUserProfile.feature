Feature: Edit user profile

  Background:
    Given User logged in as Admin
    Given Admin is on the Admin page

  Scenario: Positive profile edit
    When Admin clicks edit user profile
    Then Admin is on the edit user profile page
    When Admin change password
    When Admin change his own height(inches)
    When Admin change his own weight(lbs)
    When Admin inputs url of his profile picture
            """
            C:/Users/Soni Mohandas/Pictures/One_horned.png
            """

    When Admin checks checkbox
    When Admin clicks submit button
    Then A message should appear for verification
    When Admin clicks ok
    Then An alert should appear for the successful profile update

  Scenario: Negative profile edit
    When Admin clicks edit user profile
    Then Admin is on the edit user profile page
    When Admin clicks username input form
    Then A message should appear that username cannot be changed
    When Admin change his own height(inches)
    When Admin change his own weight(lbs)
    When Admin unchecked display biometrics checkbox
    When Admin clicks submit button
    Then A message should appear for verification
    When Admin clicks ok
    Then An message should appear for the successful profile update



