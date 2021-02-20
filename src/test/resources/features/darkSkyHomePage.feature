@web @regression @darkSky
Feature: Dark sky feature

  Background:
    Given I am on Darksky Home Page


  #1
  Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
    Then I verify current temp is not greater or less then temps from daily timeline
  #2
  Scenario: Verify timline is displayed in correct format
    Then I verify timeline is displayed with two hours incremented
  #3
  Scenario: Verify individual day temp timeline
    When I expand today"s timeline
    Then I verify lowest and highest temp is displayed correctly
  #4
  @DarkSkyRegistration
  Scenario: Verify invalid signup error message
    When I click on Dark Sky API link
    And I click on Sign Up button
    And I click on register button
    Then I verify I am on Register page by asserting Register header