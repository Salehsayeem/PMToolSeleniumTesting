package com.parata.utils.services.authorization;

import com.parata.base.AutomationBase;
import com.parata.constants.ENDPOINTS;
import com.parata.utils.Tokenizer;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * @author GURU
 * 2/25/2021
 */
public class DeleteOrgRequest extends AutomationBase
{

    public static void deleteOrganizationWithId(String orgId){
        System.out.println(String.format("Deleting organization with organization ID %s", orgId));
        requestSpec = getSpec(getApiGatewayforAuthServices(), false);
        Response response =
                given().relaxedHTTPSValidation().
                        spec(requestSpec).header("Authorization", "Bearer " + Tokenizer.getHardDeleteToken()).
                        log().all().
                        when().
                        delete(ENDPOINTS.UserDeleteOrg+orgId);
        response.prettyPrint();
        System.out.println(response.statusCode());

    }

}