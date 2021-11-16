Feature: Test for adding a new employee to the employee list

  Background: person logged in
    Given person on the login page
    When person enters username and password
    And person clicks the login button
    Then person is navigated on the home page


  Scenario Outline: Test for adding a new employee to the employee list
    And user clicks the PIM button
    When user clicks the add button
    And user navigated on add employee form
    And person enters <First name>, <Middle name>, <Last name>, <Employee id>
    And clicks the save button
    And user located on personal details page
    And clicks the edit button
    And chooses <Marital Status> and chooses <Nationality>
    And person inserts <Date of birth>
    And clicks the save button on the Detail Page
    And clicks on the job page and navigated on the job page
    And presses the edit button
    And chooses <Job Title>, <Employment Status>, <Job Category>, <Sub Unit>, <Location>
    And user enters details about Employment <Contract Start Date>, <End Date>
    And clicks the save button on the Job Page
    And clicks on salary and navigated on the salary page
    And clicks the add button
    And selects <Pay Grade>, <Pay Frequency>, <Currency>
    And inserts <Salary Component>, <Amount>
    And clicks the save button on Salary Page
    Then on PIM main page enters <First name>, <Employee id> search him and after displayed added employee

    Examples:
      | First name | Middle name | Last name | Employee id | Date of birth | Contract Start Date | End Date   | Salary Component | Amount | Marital Status | Nationality | Job Title   | Employment Status   | Job Category  | Sub Unit          | Location             | Pay Grade | Currency             | Pay Frequency                  |
      | Alex       |             | Smith     | 1111        | 1990-11-09    | 2020-01-01          | 2021-11-11 | Basic Payment    | 40000  | Married        | Russian     | QA Engineer | Full-Time Contract  | Professionals | Quality Assurance | HQ - CA, USA         | Grade 1   | United States Dollar | Semi Monthly                   |
      | Olivia     | Rose        | Roberts   | 2222        | 1990-05-03    | 2019-08-11          |            | Basic Payment    | 50000  | Single         | American    | HR Manager  | Full-Time Permanent | Craft Workers | Human Resources   | Canadian Regional HQ | Grade 2   | United States Dollar | Monthly on first pay of month. |
