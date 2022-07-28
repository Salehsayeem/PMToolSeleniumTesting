#Author Muhemmet UYAR
#09/17/2021
# Covers US 20929

@smoke_external
Feature:Smoke Test Scenarios for external PM user

#External PM User for Gayco

  @smokedev @smokestg @smokeprod
  Scenario:Login as PM for Gayco on Stratus Portal and verify Landing page is Reports screen
    Given user logged in TacoUI with "GAYCOIS" credentials
    Then user should land "reportsubscription" page

  @smokedev @smokestg @smokeprod
  Scenario:Login as PM for Gayco on Stratus Portal and verify several elements with pharmacy peek panel
    Given user logged in TacoUI with "GAYCOPM" credentials
    And "Inventory" "button" is visible and enabled
    And "Reports" "button" is visible and enabled
    And "report-subscription-search" "button" is visible and enabled
   # And " Hourly Pouch Count " "field" is visible
   # And " Dispensing Ratios " "field" is visible
   # And " Daily Packager Utilization " "field" is visible
    And clicked the top chevron on the pharmacy panel
    Then panel collapsed for the user


  @smokedev @smokeprod
  Scenario:Login as PM for Gayco on Stratus Portal and verify reports available
    Given user logged in TacoUI with "GAYCOPM" credentials
    #And user should see 11 reports under the reports
    When user searches for "Daily"
    Then user should see 4 "Daily" reports
    And user clicks "report-subscription-search-clear" "x button"
    Then user should see reports under the reports page

  @smokestg
  Scenario:Login as PM for Gayco on Stratus Portal and verify reports available
    Given user logged in TacoUI with "GAYCOPM" credentials
    #And user should see 11 reports under the reports
    When user searches for "Daily"
    Then user should see 5 "Daily" reports
    And user clicks "report-subscription-search-clear" "x button"
    Then user should see reports under the reports page

  @smokedev @smokestg @smokeprod
  Scenario Outline:Login as PM for Gayco on Stratus Portal and verify Reports are proper
    Given user logged in TacoUI with "GAYCOPM" credentials
    And user clicks "<ReportName>" "report" from table
    And "<LinkText>" "header" is visible
    And clicked the top chevron on the pharmacy panel
    Then panel collapsed for the user

    Examples:
    |ReportName                              |LinkText                             |
    | Trayset Downtime Report               |Trayset Downtime Report               |
    | Hourly Pouch Count Report             |Hourly Pouch Count Report             |
    | Canister Refill Downtime Report       |Canister Refill Downtime Report       |
#    | Formulary Balance Report              |Formulary Balance Report              |
    | Daily Packager Utilization Report     |Daily Packager Utilization Report     |
    | Daily Patient Count Report            |Daily Patient Count Report            |
    | Dispensed Medication Report           |Dispensed Medication Report           |
    | Daily Pouch Count Report              |Daily Pouch Count Report              |
    | Order Statistics Report               |Order Statistics Report               |
    | Daily Average % Canister Fill Report  |Daily Average % Canister Fill Report  |
    | Expiring Medication Report            |Expiring Medication Report            |


  @smokedev @smokestg @smokeprod
  Scenario:Login as PM for Gayco on Stratus Portal and verify Inventory Menu
    Given user logged in TacoUI with "GAYCOPM" credentials
    And user clicks "Inventory" "button"
    And "Inventory" "field" is visible
    And "Drug Name " "field" is visible
    And "NDC" "field" is visible
    And "Manufacturer" "field" is visible
    And "Avg. Daily Disp" "field" is visible
    And "Current Inv" "field" is visible
    And "ACETAMINOPHEN 325MG" "field" is visible
    And clicked the top chevron on the pharmacy panel
    Then panel collapsed for the user

  @smokedev @smokestg @smokeprod
  Scenario:Login as PM for Gayco on Stratus Portal and verify gear icon
    Given user logged in TacoUI with "GAYCOPM" credentials
    When user clicks settings
    Then display User Management option in Settings Gear Icon menu
    And user clicks User Management icon
    And " User Management & Permission " "header" is visible and enabled
    And "Last Name" "field" is visible
    And "First Name" "field" is visible
    And "Email" "field" is visible
    And "Role" "field" is visible
    And "Clear All >" "button" is visible and enabled
    And "Invite User" "buton" is visible and disabled
    And "Active Users" "field" is visible
    And "Inactive Users" "field" is visible
    And "Done" "button" is visible
    And user clicks "Done" "button"
    And user clicks "keyboard_arrow_down" "arrow"
    And user clicks " Logout " "button"
    Then user should land the page "https://frontend.stg.tacodevdomain.com/" or "https://frontend.dev.tacodevdomain.com/" or "https://stratus.parata.com/"

#  @smokedev @smokestg @smokeprod
#  Scenario: Login and verify Tab order and accessibility
#    Given user logged in TacoUI with "GAYCOPM" credentials
#    And user perform tab
#    And user perform tab and enter
#    # Then "SCRIPT MANAGEMENT" "header" is visible
#   # Then "BATCH MANAGER" "header" is visible
#    And user perform tab and enter
#    Then "Reports" "header" is visible
#    #And user perform tab
#    And user perform tab and enter
#    Then "User Management" "button" is visible
#    And user perform tab and enter
#    Then " Logout " "button" is visible
#    And user perform tab
#    And user type "Hourly" in search box
#    Then user should see "Hourly" is highlighted

  @smokedev @smokestg @smokeprod
  Scenario: Login and verify Tab order and accessibility
    Given user logged in TacoUI with "GAYCOPM" credentials
    And user perform tab
   # And user perform tab and enter
    #Then "BATCH MANAGER" "header" is visible
    And user perform tab
    #And user perform tab and enter
    #Then "Reports" "header" is visible
    #And user perform tab
    And user perform tab and enter
    Then "User Management" "button" is visible
    And user perform tab and enter
    Then " Logout " "button" is visible
    And user perform tab
    And user perform tab
    And user type "Hourly" in search box
    Then user should see "Hourly" is highlighted

  @smokedev @smokestg
  Scenario: Login and verify Tab order and accessibility with arial label
    Given user logged in TacoUI with "GAYCOPM" credentials
    Then webelement "Inventory" has aria-label "Inventory" matched
    #Then webelement "Batches" has aria-label "Batches" matched
    #Then webelement "Script Mgmt" has aria-label "Script Mgmt" matched
    Then webelement "Reports" has aria-label "Reports" matched

  @smokeprod
  Scenario: Login and verify Tab order and accessibility with arial label
    Given user logged in TacoUI with "GAYCOPM" credentials
    Then webelement "Inventory" has aria-label "Inventory" matched
    #Then webelement "Batches" has aria-label "Batches" matched
    Then webelement "Reports" has aria-label "Reports" matched

