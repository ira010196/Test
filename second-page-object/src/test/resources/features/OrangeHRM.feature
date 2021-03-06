Feature: check the functionality of the main page

  Background: user logged in
    Given user on login page
    When user enters username and password
    And clicks on login button
    Then user is navigated on the home page

  Scenario: test the welcome-menu
    When user clicks welcome
    Then displayed welcome-menu


  Scenario Outline: test for editing in my timesheets
    And user clicks Time button
    And user on navigated on Time Page
    And user clicks Timesheets menu
    And user choose my Timesheets
    When user clicks on edit button
    And user inserts <Project Name>
    And user enters <Mon>, <Tue>, <Wed>, <Thu>, <Fri>, <Sat>, <Sun>
    And user selects <Activity Name>
    And clicks on save button
    Then displayed my changed Timesheet with parameter <Project Name> the same in example table

    Examples:
      | Project Name                                   | Mon | Tue | Wed | Thu | Fri | Sat | Sun | Activity Name |
      | Global Corp and Co - Global Software phase - 1 | 4   | 5   | 6   | 7   | 8   | 9   | 10  | Bug Fixes     |
      | Global Corp and Co - Global Software phase - 2 | 6   | 6   | 6   | 8   | 12  | 10  | 1   | Estimating    |
      | FreeWave Technologies, Inc. - FWT - Phase 1    | 5   | 10  | 4   | 24  | 0   | 2   | 26  | QA Testing    |