Feature: Login

  Scenario Outline: Login with incorrect credentials
    Given The employee is on the login page
    When  The employee types "<username>" into username input
    When The employee types "<password>" into password input
    When The employee clicks on the login button
    Then the employee should see an alert saying user does not exist

    Examples:
      | username   | password |
      | blah       | blah     |
