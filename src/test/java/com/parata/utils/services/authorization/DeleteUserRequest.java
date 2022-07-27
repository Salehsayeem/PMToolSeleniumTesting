package com.parata.utils.services.authorization;

import com.parata.base.AutomationBase;
import com.parata.constants.ENDPOINTS;
import com.parata.models.authorizationservice.User;
import com.parata.utils.Tokenizer;
import com.parata.utils.context.TestContext;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * @author GURU
 * 2/25/2021
 */
public class DeleteUserRequest extends AutomationBase {
    TestContext testContext;
/*    Given I have my valid Auth0 Token
    When I hit the "https://api.internal.dev.tacodevdomain.com/report-service/subscriptions/Active" endpoint
    Then I should receive the a list of active subscriptions for my account */

    public DeleteUserRequest() { }

    public DeleteUserRequest(TestContext context) {
        testContext = context;
    }

    public static void verifyUserExists(String userEmail) {
        requestSpec = getSpec(getApiGatewayforAuthServices(), false);
        Response response =
                given().relaxedHTTPSValidation().
                        spec(requestSpec).header("Authorization", "Bearer " + Tokenizer.getGeneralInternalAdminToken()).
                        log().all().
                        when().
                        get(ENDPOINTS.UserEmail+userEmail);
        response.prettyPrint();

    }

    public static void deleteUser(User user) {
        System.out.println(String.format("Deleting user %s", user.toString()));
        deleteUserWithId(user.getUserId());
        System.out.println(user+" deleted");
    }

    public static void deleteUserWithId(String userId) {
        if (userId != null) {
            System.out.println(String.format("Deleting user with user ID %s", userId));
            requestSpec = getSpec(getApiGatewayforAuthServices(), false);
            Response response =
                    given().relaxedHTTPSValidation().
                            spec(requestSpec).header("Authorization", "Bearer " + Tokenizer.getGeneralCreation_Token()).
                            log().all().
                            when().
                            delete(ENDPOINTS.UserDeleteUser+userId);
            response.prettyPrint();
        }else {
            System.out.println("User not found");
        }
    }
    public static void deleteUserWithEmail(String userEmail) {
        //Getting the userID from userEmail
        requestSpec = getSpec(getApiGatewayforAuthServices(), false);
        Response response =
                given().relaxedHTTPSValidation().
                        spec(requestSpec).header("Authorization", "Bearer " + Tokenizer.getGeneralCreation_Token()).
                        log().all().
                        when().
                        get(ENDPOINTS.UserEmail+userEmail);
        response.prettyPrint();

        //Using userID to hardDelete from DB and Auth0
        String userId=response.path("userId");
        if (userId != null) {
            System.out.println(String.format("Deleting user with user ID %s", userId));
            requestSpec = getSpec(getApiGatewayforAuthServices(), false);
            Response response1 =
                    given().relaxedHTTPSValidation().
                            spec(requestSpec).header("Authorization", "Bearer " + Tokenizer.getHardDeleteToken()).
                            log().all().
                            when().
                            delete(ENDPOINTS.UserDeleteUser+userId);
            if (response1.statusCode()==200){
                System.out.println(userEmail +" User deleted");
            }
            else {
                System.out.println("Something went wrong with deletion");
            }
        }else {
            System.out.println("User not found");
        }
    }

    public static void main(String[] args) {
        deleteUserWithEmail("muyar@parata.com");
       // Tokenizer.getHardDeleteToken();

    }
}