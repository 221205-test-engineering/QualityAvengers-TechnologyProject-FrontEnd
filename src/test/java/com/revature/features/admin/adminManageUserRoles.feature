Feature: Admin manage user roles

  Scenario: Managing user roles
    Given User logged in as Admin
    Given Admin is on the Admin page
    When Admin clicks manage user roles button
    Then Admin is on the User Manager page
    When Admin clicks Demote To Player button
    Then The role should be demoted to player
    When Admin clicks Promote To Referee button
    Then The role should be promoted to referee
    When Admin clicks Promote To Admin button
    Then The role should be promoted to Admin
    When Admin clicks Demote To Referee button
    Then The role should be demoted to referee
    When Admin clicks back button
    Then Admin is in the Admin page
