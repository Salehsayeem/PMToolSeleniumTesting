Feature: Test drive PM to Import Wizard Screen 1

  Scenario: Drive Project Manager to Customer List Page
    When PM Selects NotProcessed From Project Status Dropdown
    Then User will get Customer List Whose Status is Not Processed
    When PM Select a Customer from List and Selects Import
    Then User will Redirect to Import Wizard Page
    When PM Uploads File
    And Map Columns As Expectation
    And Click On Next button
    Then User Will Redirect to Import Wizard 2
    And File Status Will be Changed to InProcessed

