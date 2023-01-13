Feature: Admin manage user roles

  Scenario: Managing user roles
    Given User logged in as Admin
    Given Admin is on the Admin page
    When Admin clicks manage user roles button
    Then Admin is on the User Manager page
    Then Admin can see all the users list
    When Admin clicks Demote To Player button
    Then The role should be demoted to player
    When Admin clicks Promote To Referee button
    Then The role should be promoted to referee
    When Admin clicks Promote To Admin button
    Then The role should be promoted to Admin
    When Admin clicks demote from Admin to player button
    Then The role should be demoted to player
    When Admin clicks user roles back button
    Then Admin is on the Admin page
