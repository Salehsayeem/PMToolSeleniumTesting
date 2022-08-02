@btest
Feature: Base functionality for Implemention Management

  @positive @sanity
  Scenario:Validate the Settings Gear Icon menu
    Given user logged in TacoUI with "IM" credentials
    When  user clicks  ImplementaionMgmt icon
    Then  user should land "im-tool" page
    Then  user clicks Project Status dropdown
    And   select 'NotProcessed' project status

 

