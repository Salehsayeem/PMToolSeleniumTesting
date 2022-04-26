Feature: Test login functionalities of PM Tool

  Scenario: validate login functionality of PM Tool app is working
    Given open chrome browser
    And user is on PM Tool  main page
    And select login link/button
    When user enters a parata Email Address and hits login button
    And enters microsoft password
    And hits sign in button
    And Stay signed in on microsoft
    Then user is navigated to im-tool page

