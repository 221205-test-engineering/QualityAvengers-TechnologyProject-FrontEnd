Feature: Player functionalities
  As a player
  The player wants to be able to login to the system and update their own personal information
  So that they can keep their profile up to date and manage their responsibilities as a player


  Scenario: View captains of each team
    Given the player is logged in to the system
    Then the player is on the player page
    When the player clicks on the team application button
    Then a list of teams should be displayed
    When the player clicks on see the captain
    Then the team's captain information should be displayed in a section
    When the player clicks on the close button
    Then the section disappear

#4

  Scenario Outline: Apply to join a team
    Given the player is logged in to the system by using their "<username>" and "<password>"
    Given the player is on the team application page
    Given the player is not in a team
    Then a list of teams should be displayed
    When the player select a team from the dropdown menu
    And clicks apply
    Then an alert says the application has been successful
#    Then the application status changes to pending

  Examples:
  | username | password |
#  | eegdell0 |	DyAU3y5hLA|
#  |slafoy1   |	3hOS1nh|
#  |mgoodhay2 |	FHsI2MXUb|
#  |phanrott3 |	rVufrSxG |
#  |margo23   |	eCItXyih    |
#  |cmeekings6|	Ft2RahrB    |
#  |rscreas8  |	gMhQ8W5ZObv |
#  |cwippermann9|	AFUp4lI0lOMS|
#  |mreddicka   |	EOG8Mb      |
#  |backermannb |	dDk0hto     |
#  |chutablec   |	swB1brkS2   |
#    |rlegerwoodd|	uAs0Kf  |
#  |bbettensone|	b2fAvPuM|
#  |odowellf   |	MOXvFNcR|
#  |acolcloughg|	jxvh2PvoO5y|
#  |wpaumierh  |	a9myRNBCGR |
  |t1        |	pass123  |
  |t2        |	pass123  |
  |t3        |	pass123  |
  |t4	       |pass123   |
  |t5	       |pass123   |

#2