package com.parata.utils.services.authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parata.base.AutomationBase;
import com.parata.constants.ENDPOINTS;
import com.parata.models.authorizationservice.Organization;
import com.parata.utils.Tokenizer;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author GURU
 * 2/25/2021
 */
public class GetOrgRequest extends AutomationBase
{


    public static void verifyOrganizationIsAvailable(String orgName) {
        String apiGateway = getApiGatewayforAuthServices();
        System.out.println(apiGateway);
        // https://api.dev.tacodevdomain.com/authorization-service/organizations/Name/
        requestSpec = getSpec(getApiGatewayforAuthServices(), false);
        Response response =
                given().relaxedHTTPSValidation().
                        spec(requestSpec).header("Authorization", "Bearer " + Tokenizer.getGeneralInternalAdminToken()).
                        when().log().all().
                        get(ENDPOINTS.OrgName +orgName);
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        String organizationName = jsonPath.getString("name");
        System.out.println("organizationName :"+organizationName);

        assertThat(organizationName).as("Organization Name").isEqualTo(response.path("name"));

    }

    public static Organization GetOrganizationForName(String orgName){
        requestSpec = getSpec(getApiGatewayforAuthServices(), false);
        Response response =
                given().relaxedHTTPSValidation().
                        spec(requestSpec).header("Authorization", "Bearer " + Tokenizer.getGeneralCreation_Token()).
                        log().all().
                        when().
                        get("/organizations/Name/"+orgName);
        response.prettyPrint();
        System.out.println(response.statusCode());
        Organization orgForName = null;
        try{
            orgForName = new ObjectMapper().readValue(response.asString(), Organization.class);
        }
        catch(Exception e){
            System.out.println(String.format("Error in get organization for name %s, %s", orgName, e.getMessage()));
            return null;
        }

        return orgForName;
    }

    public static void main(String[] args) {
        verifyOrganizationIsAvailable("MMP");
    }
}