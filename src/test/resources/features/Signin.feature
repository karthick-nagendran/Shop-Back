Feature: Login to the app

  @reset @1
  Scenario: I want to login to the app
    Given I am on App launch screen
#    Then I click on Select button
    Then I login to the app

    @2 @reset
  Scenario: I want to logout from Application
    Given I am on App launch screen
    And I login to the app
    When I logout from app
    Then I should see the text Sign up with email
