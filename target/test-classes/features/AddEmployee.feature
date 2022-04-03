Feature: Employee search

  Background:
    And user is logged in with valid admin credentials
    When user clicks on PIM option
    And user clicks on Add Employee button

  @1234
  Scenario: first scenario of adding the employee
    When user enters firstname middlename and lastname
    And user clicks on save button
    Then employee added successfully

  @1235
  Scenario: adding an employee from feature file
    When user enters "Andrea12" "Christina" and "Qulebras"
    And user clicks on save button
    Then employee added successfully

  @1234
  Scenario: second scenario of adding the employee
    And user enters firstname middlename and lastname
    When user deletes employee id
    And user clicks on save button
    Then employee added successfully

  @1234
  Scenario: third scenario of adding the employee
    And user enters firstname middlename and lastname
    And user selects checkbox
    When user enters username password and confirm password
    And user clicks on save button
    Then employee added successfully

  @examples
  Scenario Outline: adding an employee from feature file
    When user enters "<firstName>" "<middleName>" and "<lastName>" an the employee
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstName | middleName | lastName |
      | mimo87    | meme       | mamam    |
      | nuni67    | nina       | nonoo    |
      | pjpo57    | pipo       | papap    |


    @datatable
  Scenario: adding an employee using data table
    When I add multiple employee and verify them that user has been added successfully
      | firstName | middleName | lastName |
      | mimo87    | meme       | mamam    |
      | nuni67    | nina       | nonoo    |
      | pjpo57    | pipo       | papap    |
      | nun23g    | nina       | nonoo    |
      | pjpasd    | pipo       | papap    |

@exel
Scenario: adding an employee from exel file
  When user adds multiple employees from exel file using "EmployeeData" sheet and verify the added employee


