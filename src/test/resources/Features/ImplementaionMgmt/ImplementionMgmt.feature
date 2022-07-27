Feature: Base functionality for Implemention Management

  @positive @sanity
  Scenario:Validate the Settings Gear Icon menu
    Given user logged in TacoUI with "GAYCOPM" credentials
    When user clicks implemention mgt button
    Then display implemention management page