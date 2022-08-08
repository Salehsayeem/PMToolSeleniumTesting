@btest
Feature: Base Functionality For Import Wizard Mapping


  @positive @sanity
  Scenario:Verify Project Management Tool for Search and Display Customer Information
    Given user logged in TacoUI with "IM" credentials
    When user clicks ImplementaionMgmt icon
    Then user will land "im-tool" page
    Then user clicks Project Status dropdown
    Then select 'NotProcessed' project status
    Then user enters "304949" into the search bar


  @positive @sanity
  Scenario:Verify Import Wizard for Mapping imported columns
    Given user logged in TacoUI with "IM" credentials
    When user click import button
    Then user click browse button
    Then user click update button
    Then user clicks Production Drug dropdown
    Then select 'Product Name' from drug dropdown
    Then user clicks NDC from Drug dropdown
    Then select 'NDC11' NDC from drug dropdown
    Then user clicks Rx from drug dropdown
    Then select 'Rx Count' Rx from drug dropdown
    Then  user click next button