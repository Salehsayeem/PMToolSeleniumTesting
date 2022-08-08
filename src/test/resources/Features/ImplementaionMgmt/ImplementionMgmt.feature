@atest
Feature: Base Functionality for Implementation Manager


  @positive @sanity
  Scenario:Login to Taco UI with IM credentials and verify Implementation page
    Given user logged in TacoUI with "IM" credentials
    When user clicks ImplementaionMgmt icon
    Then user will land "im-tool" page


  @positive @sanity
  Scenario:Selected Project Status Should Be Reflect In Filtered Area With Search
    Given user logged in TacoUI with "IM" credentials
    When user clicks ImplementaionMgmt icon
    Then user will land "im-tool" page
    Then user clicks Project Status dropdown
    Then select 'NotProcessed' project status
    Then user enters "304949" into the search bar





 

