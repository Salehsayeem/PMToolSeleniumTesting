package com.parata.steps;

import com.parata.base.AutomationBase;
import com.parata.constants.CONTEXT;
import com.parata.models.authorizationservice.*;
import com.parata.utils.context.TestContext;
import com.parata.utils.services.authorization.DeleteOrgRequest;
import com.parata.utils.services.authorization.DeleteUserRequest;
import io.cucumber.java.After;

/*
    Author JAS 03/09/2021

    Contains Cleanup steps that need access to the TestContext

    Cleanup steps should be gated behind @TestParameters given in the feature file based on the kind of cleanup required
*/

public class CleanupSteps extends AutomationBase {

    TestContext testContext;
/*    Given I have my valid Auth0 Token
    When I hit the "https://api.internal.dev.tacodevdomain.com/report-service/subscriptions/Active" endpoint
    Then I should receive the a list of active subscriptions for my account */

    public CleanupSteps() {
    }

    public CleanupSteps(TestContext context) {
        testContext = context;
    }


    /*
        Cleans up Scenario context objects USER_ID_TO_HARD_DELETE and USER_MODEL_TO_HARD_DELETE
        Only associate one, unless both represent different objects

        Only checks after test scenarios with the @DatabaseCleanup tag
    */

  /*  @After(value = "@EmailCleanup")
    public void HardDeleteUsers(String email, String sender) {
        email = "testuserparata@gmail.com";
        sender = "platform_noreply@parata.com";
        try {
            GMail.deleteEMailsBySender(email, sender);
        } catch (Exception e) {
            System.out.println("ERROR in Deleting emails from Gmail " + e.getMessage());
        }
    }*/


    @After(value = "@UserCleanup")
    public void HardDeleteUser() {
        try {
            String userEmail = testContext.getScenarioContext().getContext(CONTEXT.USER_EMAIL_TO_HARD_DELETE).toString();
            DeleteUserRequest.deleteUserWithEmail(userEmail);
        } catch (Exception e) {
            System.out.println("ERROR in HardDeleteUser with email: " + e.getMessage());
        }
        try {

            String userId = testContext.getScenarioContext().getContext(CONTEXT.USER_ID_TO_HARD_DELETE).toString();
            DeleteUserRequest.deleteUserWithId(userId);
        } catch (Exception e) {
            System.out.println("ERROR in HardDeleteUser with id: " + e.getMessage());
        }
        try {
            User user = (User) testContext.getScenarioContext().getContext(CONTEXT.USER_MODEL_TO_HARD_DELETE);
            DeleteUserRequest.deleteUser(user);
        } catch (Exception e) {
            System.out.println("ERROR in HardDeleteUser with model: " + e.getMessage());
        }
    }


    

    @After(value = "@OrganizationCleanup")
    public void HardDeleteOrganization() {
        String organiationId = testContext.getScenarioContext().getContext(CONTEXT.ORGANIZATION_ID_TO_HARD_DELETE).toString();
        try {
            DeleteOrgRequest.deleteOrganizationWithId(organiationId);
        } catch (Exception e) {
            System.out.println("ERROR in HardDeleteOrganization: " + e.getMessage());
        }
    }
}

