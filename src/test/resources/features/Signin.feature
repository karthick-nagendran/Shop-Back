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

  @3 @reset
  Scenario: I want to verify the shop back go screen
    Given I login to the app
    When I click on ShopBack GO button
    And I click on Deny button
    # or Allow
    Then I should see the shop back go screen

  @4 @reset
  Scenario: I want to see the detail screen of the first result from shop back go
    Given I login to the app
    And I click on ShopBack GO button
    And I click on Deny button
    #or Allow
    And I should see the shop back go screen
    When I click on first result from shop back go result
    Then I should see the text Outlet Details

  @5 @reset
  Scenario: I want to see Rides screen
    Given I login to the app
    When I click on Rides button
    Then I should see the text HAIL A RIDE

  @6 @reset
    Scenario: I want to see Dining screen
    Given I login to the app
    When I click on Dining button
    Then I should see the text Dining