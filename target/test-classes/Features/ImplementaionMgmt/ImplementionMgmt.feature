@atest
Feature: Base Functionality for Implementation Manager

  Background: user logged in
    Given user logged in TacoUI with "IM" credentials

  @positive @sanity
  Scenario:Verify selected project status should be reflect in filtered area
    When user clicks  ImplementaionMgmt icon
    Then user will land "im-tool" page
    And  user clicks Project Status dropdown
    And  select 'NotProcessed' project status
    Then user enters "131116" into the search bar for scearching customer
    Then user click import button







 

