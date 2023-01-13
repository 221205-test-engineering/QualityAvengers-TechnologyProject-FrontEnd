Feature: Login 

  Scenario Outline: Login with correct credentials
    Given The employee is on the login page
    When  The employee types "<username>" into username input
    When The employee types "<password>" into password input
    When The employee clicks on the login button
    Then the employee should be on the "<role>" page
    Then The employee should see their name "<username>" 

    Examples:
      | username   | password | role    |
      | Bobby202   | pass123  | Player  |
      | TopDawg    | sicem    | Admin   |
      | cindy101   | pass123  | Referee |