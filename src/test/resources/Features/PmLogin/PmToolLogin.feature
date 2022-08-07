@login
Feature:Login and Logout functionality for Stratus Frontend
  @positive @sanity
  Scenario: Login to Taco UI with PM credentials
    Given user logged in TacoUI with "IM" credentials
    And user clicks login button
    Then user should land the page "https://frontend.stg.tacodevdomain.com/"



