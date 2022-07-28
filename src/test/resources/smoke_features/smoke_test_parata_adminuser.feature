#Author Muhemmet UYAR
#09/17/2021
# Covers US 20929

@smoke_internal
Feature:Smoke Test Scenarios for Internal Parata Admin User
#Internal Admin User
  @smokedev @smokestg @smokeprod
  Scenario:Verify landing page is customer management
    Given user logged in TacoUI with "IM" credentials
    Then user should land "customer-management" page

  @smokedev @smokestg @smokeprod
  Scenario:Login as Parata admin on Stratus Portal (engineering testuser) and verify general
    Given user logged in TacoUI with "IM" credentials
    And " Add New Organization " "button" is visible and enabled
    And " Add New Site " "button" is visible and enabled
    And "Gayco" "org" is visible
    And "engineering testuser" "user" is visible

  @smokedev @smokestg @smokeprod
  Scenario:Login as Parata admin on Stratus Portal (engineering testuser) and verify Adding New Org
    Given user logged in TacoUI with "IM" credentials
    And user clicks " Add New Organization " "button"
    And " Add New Organization " "header" is visible
    And "Cancel" "button" is visible and enabled
    Then user clicks "Cancel" "button"

  @smokedev @smokestg @smokeprod
  Scenario:Login as Parata admin on Stratus Portal (engineering testuser) and verify User Management
    Given user logged in TacoUI with "IM" credentials
    And user clicks Settings Gear icon
    And "User Management" "button" is visible and enabled
    And user clicks "User Management" "button"
    And " User Management & Permission " "header" is visible
    And "Done" "button" is visible and enabled
    And "UserManagementSearch" "field" is visible
    And "Last Name" "field" is visible
    And "First Name" "field" is visible
    And "Email" "field" is visible
    And "Role" "field" is visible
    And "Invite User" "button" is visible and disabled
    And "Clear All >" "button" is visible and enabled
    And "Active Users" "button" is visible and enabled
    And "Inactive Users" "button" is visible and enabled
    And "ADMIN, Parata" "button" is visible
    And user can parse max fifty Alpha, Numeric, Special Characters to search box
    Then user clicks "Done" "button"


  @smokedev @smokestg @smokeprod
  Scenario:Login as Parata admin on Stratus Portal (engineering testuser) and verify User Management Search Field
    Given user logged in TacoUI with "IM" credentials
    And user clicks Settings Gear icon
    And user clicks "User Management" "button"
    And user parse "Admin", the word must be highlighted
    And user can parse max fifty Alpha, Numeric, Special Characters to search box
    Then user clicks "Done" "button"

  @smokedev @smokestg @smokeprod
  Scenario:Login as Parata admin on Stratus Portal (engineering testuser) and verify Request New Org Button working
    Given user logged in TacoUI with "IM" credentials
    And user clicks " Add New Site " "button"
    And " Add New Site " "header" is visible and enabled
    And "Request New Organization" "button" is visible and enabled
    And user clicked "RequestNewOrg" "button"
    Then user should see " Add New Organization "

  @smokedev @smokestg @smokeprod
  Scenario:Login as Parata admin on Stratus Portal (engineering testuser) and verify Add a new Site
    Given user logged in TacoUI with "IM" credentials
    And user clicks " Add New Site " "button"
    And " Add New Site " "header" is visible and enabled
    And "Request New Organization" "button" is visible and enabled
    And "Next" "button" is visible and disabled for parent
    And user clicks " Gayco " "button"
    Then user clicks "Next" "button"
    And "Site Name From Salesforce " "field" is visible
    And "FriendlyName" "field" is visible
    And "Last Name" "field" is visible
    And "First Name" "field" is visible
    And "Email" "field" is visible
    And "Role" "field" is visible
    And "Cancel" "button" is visible and enabled
    And "Back" "button" is visible and enabled
    And "Create New Site" "button" is visible
    Then user clicks "Cancel" "button"


  @smokedev @smokestg @smokeprod
  Scenario:Login as Parata admin on Stratus Portal (engineering testuser) and verify Row Header is Expanded and Site
    Given user logged in TacoUI with "IM" credentials
    And "Dublin" "siteOrg" is visible
    And user clicked "Dublin_arrow" "arrow"
    #And "Dublin" "siteOrg" is visible
    #And user clicked "Dublin_arrow" "arrow"
    And "OrgOnboardingTab" "field" is visible
    And "Friendly Name" "field" is visible
    And "System Type" "field" is visible
    And "Serial Number" "field" is visible
    And " Add " "field" is visible
    And user clicks "D-MnuCustomerManagement" "button"
    And user clicks "keyboard_arrow_down" "UserArrow"
    And user clicks " Logout " "button"
    Then user should land the page "https://frontend.stg.tacodevdomain.com/" or "https://frontend.dev.tacodevdomain.com/" or "https://stratus.parata.com/"


