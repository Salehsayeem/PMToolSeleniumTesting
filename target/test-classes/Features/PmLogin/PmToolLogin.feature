@login @atest
Feature:Login and Logout funcationlity for Stratus Frontend
  @positive @sanity
  Scenario: Login to Taco UI with PM credentials
    Given user logged in TacoUI with "IM" credentials
    Then  logged in to Parata UI Website "ValidLastNameForGayco"
    And   user clicks login button



