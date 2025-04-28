Feature: Add bets

  Scenario: Add random live sport bet
    Given I am successfully logged in with valid username and password
    When I navigate to Live from burger menu
    And I choose sport with more than 5 events
    And I place a bet with odd value between 1.25 and 5.00
    Then I verify bet slip value is "1"
    And I am successfully logged out