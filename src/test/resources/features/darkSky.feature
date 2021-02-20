@web @regression @darkSky
Feature: darkSky feature
  Background:
    Given I am on the darkSky home page

    #first scenario

    @darkSky-1
    Scenario: Verify invalid signup error message
      When I am on darkSky Register page
      When I click on Register button
      Then I verify i'm still on Register page

    @darkSky-2
    Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
      Then I verify current temp is not greater or less then temps from daily timeline

    @darkSky-3
    Scenario: Verify individual day temp timeline
      When I expand todays timeline
      Then I verify lowest and highest temp is displayed correctly

     @darkSky-4
     Scenario: Verify timline is displayed in correct format
       Then I verify timeline is displayed with two hours incremented


