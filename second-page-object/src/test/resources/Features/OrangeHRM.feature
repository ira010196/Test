Feature: check the functionality of the main page

  Background: user logged in
    Given user on login page
    When user enters username and password
    And clicks on login button
    Then user is navigated on the home page

  Scenario: test the welcome-menu
    When user clicks welcome
    Then displayed welcome-menu


  Scenario: check my Time Sheets
    When user clicks Time button
    And user on navigated on Time Page
    And user clicks Timesheets menu
    And user choose my Timesheets
    Then displayed on page Timesheet for Week

