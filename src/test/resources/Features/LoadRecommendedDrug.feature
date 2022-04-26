Feature: Test drive an user to recommended drug list

  Scenario: Load recommended drug list for a specific customer
    When User is on Pm Tool Customer list screen
    Then User select a customer
    And select Import Button
    Then User can browse files from their computer
    And User choose a file and upload
    And Map dropdown with specific excel column and hit next button
    When User select device type and configuration type
    And exclude otc,schedule and unit of usage
    And hits import button
    Then user is navigated to load recommended drug page
