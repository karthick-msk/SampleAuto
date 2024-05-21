#The display count for tennis games in the sportsbook page does not accurately reflect the correct number of games for today, tomorrow, and the next 7 days

Feature: Tennis sportsbook bet functionality

Scenario: The display count for tennis games in the sportsbook page does not accurately reflect the correct number of games for today, tomorrow, and the next 7 days
  Given a user logs in to the haboom webpage
  When the user clicks the sportsbook tab and then clicks the in-play button
  And the user clicks the tennis bet
  Then the tennis bet number of games for today, tomorrow, and the next 7 days should reflect correctly