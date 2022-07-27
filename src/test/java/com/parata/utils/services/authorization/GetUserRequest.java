package com.parata.utils.services.authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parata.base.AutomationBase;
import com.parata.constants.CONSTANTS;
import com.parata.constants.ENDPOINTS;
import com.parata.models.authorizationservice.User;
import com.parata.utils.Tokenizer;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author MFU
 * 2/3/2021
 */
public class GetUserRequest extends AutomationBase
{

    public static void getUserRes() {
        requestSpec = getSpec(getApiGatewayforAuthServices(), Boolean.parseBoolean("false"));
        Response response =
                given().relaxedHTTPSValidation().
                        spec(requestSpec).header("Authorization", "Bearer " + Tokenizer.getGeneralInternalAdminToken()).
                        log().all().
                        /*if you need header you can write below.*/
                        when().
                        get(ENDPOINTS.GetUser1);
        response.prettyPrint();

        assertThat(response.statusCode()).as("Status Code").isEqualTo(200);
        assertThat(response.body().toString()).as("Response body").isNotEmpty();
    }

    public static void verifyUserIsAvailable(String userEmail, String orgName) {
        requestSpec = getSpec(getApiGatewayforAuthServices(), false);
        Response response =
                given().relaxedHTTPSValidation().
                        spec(requestSpec).header("Authorization", "Bearer " + Tokenizer.getGeneralInternalAdminToken()).
                        log().all().
                                when().
                        get(ENDPOINTS.UserEmail+userEmail);
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        String firstName = jsonPath.getString("firstName");
        System.out.println("firstName :"+firstName);
        String lastName = jsonPath.getString("lastName");
        System.out.println("lastName :"+lastName);

        assertThat(firstName).as("First Name").isEqualTo(CONSTANTS.FIRST_NAME);
        assertThat(lastName).as("Last Name").isEqualTo(CONSTANTS.LAST_NAME);

    }

    public static User GetUserForEmail(String email){
        requestSpec = getSpec(getApiGatewayforAuthServices(), false);
        Response response =
                given().relaxedHTTPSValidation().
                        spec(requestSpec).header("Authorization", "Bearer " + Tokenizer.getGeneralInternalAdminToken()).
                        log().all().
                        when().
                        get(ENDPOINTS.UserEmail+email);
        response.prettyPrint();

        User userForEmail = null;
        try{
            userForEmail = new ObjectMapper().readValue(response.asString(), User.class);
        }
        catch(Exception e){
            System.out.println(String.format("Error in get user for email %s, %s", email, e.getMessage()));
            return null;
        }

        return userForEmail;
    }

    public static void main(String[] args) {
        //GetUserForEmail("test@sss.com");
        verifyUserIsAvailable("uuu", "ss");
    }
}