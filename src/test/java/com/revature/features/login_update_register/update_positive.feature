Feature: Update user data

Background:
    Given the employee is on their home page
    When the employee clicks on edit user profile

  Scenario: Update biometrics
    When the employee clicks on the checkbox next to display biometrics
    When the employee clicks on the submit button
    Then the employee should see an alert saying Are you sure you want to edit your user profile
    When the employee clicks ok
    Then the employee should see an alert saying update successful

  Scenario: Update height/weight
    When the user types in 80 for their height
    When the user types in 200 for their weight
    When the user clicks submit
    Then the employee should see an alert saying Are you sure you want to edit your user profile
    When the employee clicks ok
    Then the employee should see an alert saying update successful

  Scenario: Update profile picture
    When the user enters link for their profile picture
    When the user clicks submit
    Then the employee should see an alert saying Are you sure you want to edit your user profile
    When the employee clicks ok
    Then the employee should see an alert saying update successful

  Scenario: Update password
    When the employee types in pass1234
    When the user clicks submit
    Then the employee should see an alert saying Are you sure you want to edit your user profile
    When the employee clicks ok
    Then the employee should see an alert saying update successful