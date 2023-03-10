Feature: Captain functionalities
  As a captain
  The captain wants to be able to view other captains, games, series, venues and schedules and handle player's requests to join their team




  Scenario: View list of players requesting to join the team
    Given the captain is logged in to the system
    When the captain navigates to the approve or deny team request page
    Then a list of all players requesting to join the team should be displayed

  Scenario: View details of one player
    Given the captain is logged in to the system
    When the captain navigates to the approve or deny team request page
    Then a list of all players requesting to join the team should be displayed
    When the captain clicks on see the player
    Then the details of the selected player should be displayed

  Scenario Outline: Approve a player
    Given the captain is logged in to the system by using their "<username>" and "<password>"
    When the captain navigates to the approve or deny team request page
    Then a list of all players requesting to join the team should be displayed
    When the captain clicks on the approve button next to a player's name
    Then an alert says the approval has been successful
#    When the captain clicks OK
#    Then the request status changes to accepted
    Examples:
      | username | password |
      | Bobby202 |	pass123  |
      | Candice202|	pass123 |
      |Jessika202 |	pass123 |

  Scenario Outline: Deny a player
    Given the captain is logged in to the system by using their "<username>" and "<password>"
    When the captain navigates to the approve or deny team request page
    Then a list of all players requesting to join the team should be displayed
    When the captain clicks on the deny button next to a player's name
    Then an alert says the deny has been successful
#    Then the request status changes to denied

    Examples:
    | username | password |
    | Bobby202 |	pass123  |
    | Candice202|	pass123 |
    |Jessika202 |	pass123 |

