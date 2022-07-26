package com.parata.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

/**
 * @author MFU
 * 9/2/2020
 */
public class RestUtil {

    public static String				ENDPOINT;
    public static RequestSpecBuilder	requestBuilder;
    public static RequestSpecification	requestSpec;
    public static ResponseSpecBuilder responseBuilder;
    public static ResponseSpecification responseSpec;


    public static void setEndpoint (String strEndpoint)
    {
        ENDPOINT = strEndpoint;
    }

    public static RequestSpecification getRequestSpecification (String strBaseURI)
    {
        requestBuilder = new RequestSpecBuilder();
        requestBuilder.setBaseUri (strBaseURI);
        requestBuilder.setContentType (ContentType.JSON);
        requestSpec = requestBuilder.build ();

        return requestSpec;
    }
    public static ResponseSpecification getResponseSpecification (boolean isNegative)
    {
        responseBuilder = new ResponseSpecBuilder ();
        //responseBuilder.expectContentType (ContentType.JSON);
        //responseBuilder.expectContentType("application/json");
        if (isNegative == true)
        {
            responseBuilder.expectStatusCode(Matchers.not(200));
            System.out.println("This is a negative test! Response status code is not 200, which is expected.");
        }
        else
        {
            responseBuilder.expectStatusCode (200);
        }


        responseSpec = responseBuilder.build ();

        return responseSpec;
    }

}
