#Author Muhemmet UYAR
#06/10/2021
# Covers US 20929

@user @btest
Feature:Base Functionality for User Management as Implementation Manager 

  @positive @sanity 
  Scenario: Login to Taco UI with IM selected roles should be reflect in filtered area
    Given user logged in TacoUI with "IM" credentials
    When user clicks settings
    And user clicks User Management icon
    And user clicks roles dropdown
    When select "Implementation Manager" role
    Then user should see only "Implementation Manager" role in filter

#Covers US 20925
  @positive @sanity 
  Scenario: Login to Taco UI with IM user can search 50 characters
    Given user logged in TacoUI with "IM" credentials
    When user clicks settings
    And user clicks User Management icon
    Then user can parse max fifty Alpha, Numeric, Special Characters to search box

    #Covers US 20925
  @positive @sanity  @quarantined
  Scenario: Login to Taco UI with IM user should able to search in user management page
    Given user logged in TacoUI with "IM" credentials
    When user clicks settings
    And user clicks User Management icon
    And user parse "ADMIN", the word must be highlighted

    #Covers Sprint 56 - create a user
  @positive @sanity 
  Scenario: Login to Taco UI with IM and create a new user
    Given user logged in TacoUI with "IM" credentials
    And user with email address "testuserparata@gmail.com" does not exist
    And user with email address "testuserparata@gmail.com" does not have email from "platform_noreply@parata.com"
    And user clicks settings
    And user clicks User Management icon
    When user create a new user with "lastname","firstname","testuserparata@gmail.com","PTAC"
    Then AuthZero column should "not be" null for "testuserparata@gmail.com"

 #Covers US 29926
  @positive @sanity @UserCleanup 
  Scenario: Verify new non-parata user has Auth0 value
    Given user logged in TacoUI with "IM" credentials
    And user with email address "testuserparata@gmail.com" does not exist
    And user with email address "testuserparata@gmail.com" does not have email from "platform_noreply@parata.com"
    And user clicks settings
    And user clicks User Management icon
    When user create a new user with "Testlastname","Testfirstname","testuserparata@gmail.com","Implementation Manager"
    Then AuthZero column should "not be" null for "testuserparata@gmail.com"

 #Covers US 29926
  @positive @sanity 
  Scenario: Verify new parata user hasnt Auth0 value
    Given user logged in TacoUI with "IM" credentials
    And user with email address "testuserforauth0@parata.com" does not exist
    When user clicks settings
    And user clicks User Management icon
    When user create a new user with "Testlastname","Testfirstname","testuserforauth0@parata.com","PTAC"
    Then AuthZero column should "be" null for "testuserforauth0@parata.com"


  @positive @sanity @UserCleanup 
  Scenario: Verify new non-parata user receives invitation e-mail
    Given user logged in TacoUI with "IM" credentials
    And "testuserparata@gmail.com" inbox is not have an email subject with "Welcome to Parata Stratus" "Auth0 User Created."
    And user with email address "testuserparata@gmail.com" does not exist
    When user clicks settings
    And user clicks User Management icon
    When user create a new user with "Testlastname","Testfirstname","testuserparata@gmail.com","Implementation Manager"
    Then user should get invitation email with subject of "Welcome to Parata Stratus"

  #Covers US 20875
  @positive @sanity 
  Scenario: Inactivated users should not allow to login
    Given user logged in TacoUI with deactivated credentials
    Then display a warning message on login screen

#Covers Backlog Test Case 21572
  @positive @sanity 
  Scenario: Login to Taco UI with IM if user pars
    Given user logged in TacoUI with "IM" credentials
    When user clicks settings
    And user clicks User Management icon
    And user clicks role dropdown menu
    Then system should display same count of available external roles in Pg DB


  # Covers US 46439 Sprint 65 , 10/18/2021
  @positive @sanity  @quarantined
  Scenario: Login to Taco UI with IM and user should see toaster message with undo button for Admin User
    Given user logged in TacoUI with "IM" credentials
    Given "testuser_im@gmail.com" is active
    And user clicks Settings Gear icon
    And user clicks User Management icon
    And user clicks "testuser_im@gmail.com" "button"
    Then user clicks "inactivate" "button" and "undo" is available in toaster message
    And user clicks "testuser_im@gmail.com" "button"
    Then user clicks "reactivate" "button" and "User Inactivated" is available in toaster message


  @positive @sanity  @quarantined
  Scenario: Login to Taco UI with IM and user should see toaster message with undo button for Gayco User
    Given user logged in TacoUI with "GAYCOPM" credentials
    Given "testuser_lf@gayco.com" is active
    And user clicks Settings Gear icon
    And user clicks User Management icon
    And user clicks "testuser_lf@gayco.com" "button"
    Then user clicks "inactivate" "button" and "undo" is available in toaster message
    And user clicks "testuser_lf@gayco.com" "button"
    Then user clicks "reactivate" "button" and "User Inactivated" is available in toaster message


   # Covers US 46670 Sprint 65 , 10/25/2021
  @positive @sanity 
  Scenario: Login to Taco UI with IM and user should cannot inactivate self
    Given user logged in TacoUI with "IM" credentials
    And user clicks Settings Gear icon
    And user clicks User Management icon
    And user clicks "testuser_admin@parataa.com" "button"
    Then "inactivate" "button" is visible and disabled


# Covers US 30198 Sprint 65 , 10/25/2021 Automation Backlog
  @positive @sanity 
  Scenario: Verify the Organizations Details Menu options
    Given user logged in TacoUI with "IM" credentials
    Then  user should land "customer-management" page
    And user searches for "mmp"
    When user clicks "MMP-Pharm1_Detail_arrow" "arrow"
    Then display organization menu in Organizations Onboarding management Screen

  @positive @sanity 
  Scenario: Verify the Edit user functionality for internal users
    Given user logged in TacoUI with "IM" credentials
    And user with email address "testuserparata@gmail.com" does not exist
    And user clicks settings
    And user clicks User Management icon
    And user create a new user with "Testlastname","Testfirstname","testuserparata@gmail.com","Implementation Manager"
    And user clicks "testuserparata@gmail.com" "ellipse"
    And user clicks "Edit" "button"
    And user update Role "Admin User"
    Then user clicks "OK" "button" and "Role Updated Successfully!" is available in toaster message


  #Coverd Automation story 30205
  @positive @sanity 
  Scenario: Verify the User allow to enter maximum of 50 characters in search text field in customer flow
    Given user logged in TacoUI with "IM" credentials
    Then  user should land "customer-management" page
    And user clicked "MMP-Pharm1_Detail_arrow" "arrow"
    And user clicks "OrgUserManagementTab" "link"
    And user can parse max fifty Alpha, Numeric, Special Characters to search box

#Coverd Automation story 30205
  @positive @sanity 
  Scenario: Verify the Resend Invitation functionality in User Management & Permissions page in Organizations Details Menu
    Given user with email address "testuserparata@gmail.com" does not exist
    And user logged in TacoUI with "IM" credentials
    Then  user should land "customer-management" page
    And user clicked "MMP-Pharm1_Detail_arrow" "arrow"
    And user clicks "OrgUserManagementTab" "link"
    And user create a new user with "Testlastname","Testfirstname","testuserparata@gmail.com","Pharmacy Manager"
    And user clicks "testuserparata@gmail.com" "ellipse"
    And user clicks "Resend Invitation" "button"
    Then user should see "Resend Invitation successful!" toaster message

#Coverd Automation story 30205
  @positive @sanity 
  Scenario: Verify the UI fields for User Management & Permissions page for external customers
    Given user logged in TacoUI with "IM" credentials
    Then  user should land "customer-management" page
    And user clicked "MMP-Pharm1_Detail_arrow" "arrow"
    And user clicks "OrgUserManagementTab" "link"
    And "UserManagementSearch" "field" is visible
    And "Last Name" "field" is visible
    And "First Name" "field" is visible
    And "Email" "field" is visible
    And "Role" "field" is visible
    And "Invite User" "button" is visible and disabled
    And "Clear All >" "button" is visible and enabled
    And "Active Users" "button" is visible and enabled
    And "Inactive Users" "button" is visible and enabled




    #Covers Backlog Test Case 21566 -Quarantined while US is going updated
  #@positive @sanity
  #Scenario: Login to Taco UI with IM (Parata Admin) user can pars 50 characters to First Name Field
  #  Given user logged in TacoUI with "IM" credentials
   # When user clicks settings
    #And user clicks User Management icon
    #Then user can parse max fifty Alpha, Numeric, Special Characters to First Name Field box

   #Covers Backlog Test Case 21568
  #@positive @sanity
  #Scenario: Login to Taco UI with IM (Parata Admin) user can pars 50 characters to Last Name Field
   # Given user logged in TacoUI with "IM" credentials
    #When user clicks settings
    #And user clicks User Management icon
    #Then user can parse max fifty Alpha, Numeric, Special Characters to Last Name Field box

   #Covers Backlog Test Case 21569
  #@positive @sanity
  #Scenario: Login to Taco UI with IM (Parata Admin) user can pars 50 characters to Email Field
   # Given user logged in TacoUI with "IM" credentials
    #When user clicks settings
    #And user clicks User Management icon
    #Then user can parse max fifty Alpha, Numeric, Special Characters to Email Field box
   #Covers Backlog Test Case 21571

  #@positive @sanity
  #Scenario: Login to Taco UI with IM (Parata Admin) if user pars invalid Email format, warning should be displayed
    #Given user logged in TacoUI with "IM" credentials
   # When user clicks settings
    #And user clicks User Management icon
   # And user parse invalid email format
    #Then system should display warning text box