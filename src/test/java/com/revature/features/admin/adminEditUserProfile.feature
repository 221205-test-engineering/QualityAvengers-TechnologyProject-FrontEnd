Feature: Edit user profile

  Background:
    Given User logged in as Admin
    Given Admin is on the Admin page

  Scenario: Positive profile edit
    When Admin clicks edit user profile
    Then Admin is on the edit user profile page
    When Admin change password
    When Admin change his own height in inches
    When Admin change his own weight in lbs
    When Admin inputs url of his profile picture
            """
            https://pixabay.com/illustrations/car-yellow-png-967387
            """

    When Admin checks checkbox
    When Admin clicks edit profile submit button
    Then A message should appear for verification
    When Admin verifies profile editing
    Then An message should appear for the successful profile update

  Scenario: Negative profile edit
    When Admin clicks edit user profile
    Then Admin is on the edit user profile page
    When Admin clicks username input form
    Then A message should appear that username cannot be changed
    When Admin change his own height in inches
    When Admin change his own weight in lbs
    When Admin unchecked display biometrics checkbox
    When Admin clicks edit profile submit button
    Then A message should appear for verification
    When Admin verifies profile editing
    Then An message should appear for the successful profile update

  Scenario: Profile edit cancel
    When Admin clicks edit user profile
    Then Admin is on the edit user profile page
    When Admin update his own height in inches
    """
    "75"
    """
    When Admin update his own weight in lbs
    """
    "180"
    """
    When Admin checks checkbox
    When Admin clicks edit profile submit button
    Then A message should appear for verification
    When Admin cancelled the profile edit
    Then It should clear edited values

