package com.parata.utils;

import com.parata.base.AutomationBase;
import com.parata.constants.GLOBAL;
import com.parata.models.UserToken;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * @author MFU
 * 2/3/2021
 */
public class Tokenizer extends AutomationBase {

    static String tokenString;
    static String hardTokenString = null;

    public static String getGeneralInternalAdminToken() {
        UserToken token;
        if (hardTokenString != null) {
            System.out.println("Returning cached hardTokenString: " + hardTokenString);
            return hardTokenString;
        }
        ConfigReader.readProperties("src/test/resources/configs/credentials.properties");
        switch (GLOBAL.APPLICATION_ENVIRONMENT.toUpperCase()) {
            case "STAGING":
            case "STAG":
            case "STG":
                token = UserToken.builder()
                        .client_id("GpyTud6g2JPfwPzRgilOWuJqZ0g5KLeo")
                        .client_secret("lp9Jfwo7wd32bndgDQc8wln6-8bHih5nPwE3v_t08l4r_vF8tmFYqH1boT-9nl21")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                       // .username("testuser_admin@parataqa.com")
                        .username("vdr_ssayeem@parata.com")
                        .password("1010997637@Hydrus").realm("parata-auth").build();
                requestSpec = getSpec("production_TokenStg", Boolean.parseBoolean("false"));
                System.out.println("Staging Token");
                break;
            case "PRODUCTION":
            case "PROD":
                token = UserToken.builder()
                        .client_id("GpyTud6g2JPfwPzRgilOWuJqZ0g5KLeo")
                        .client_secret("lp9Jfwo7wd32bndgDQc8wln6-8bHih5nPwE3v_t08l4r_vF8tmFYqH1boT-9nl21")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_admin@parataqa.com")
                        .password("everyA@0").realm("parata-auth").build();
                requestSpec = getSpec("production_TokenStg", Boolean.parseBoolean("false"));
                break;
            default:
                token = UserToken.builder()
                        .client_id("tx3EYHNsI4cmU7WHWtsiQyBZL1Qd4nY0")
                        .client_secret("k_sXqy-buOoFqHd_bd-eS_gHe1wFIE58C5b32LD1zqEkelm0SFv5vFcQuu8rTNXZ")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_admin@parataqa.com")
                        .password("everyA@09").realm("parata-auth").build();
                requestSpec = getSpec("production_Dev_Token", Boolean.parseBoolean("false"));
                System.out.println("DEV");
        }


        Response response =
                given().
                        spec(requestSpec).
                        /*if you need header you can write below.*/
                                body(token).
                        when().
                        post();
        tokenString = response.path("access_token");
        System.out.println("General Admin Token is " + tokenString);

        return tokenString;

    }


    public static String getPM_Gayco_Token() {
        UserToken token;

        switch (GLOBAL.APPLICATION_ENVIRONMENT.toUpperCase()) {
            case "STAGING":
            case "STAG":
            case "STG":
                token = UserToken.builder()
                        .client_id("GpyTud6g2JPfwPzRgilOWuJqZ0g5KLeo")
                        .client_secret("lp9Jfwo7wd32bndgDQc8wln6-8bHih5nPwE3v_t08l4r_vF8tmFYqH1boT-9nl21")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_pm@gayco.com")
                        .password("everyA@09").realm("parata-auth").build();

                requestSpec = getSpec("production_TokenStg", Boolean.parseBoolean("false"));
                break;
            case "PRODUCTION":
            case "PROD":
                token = UserToken.builder()
                        .client_id("GpyTud6g2JPfwPzRgilOWuJqZ0g5KLeo")
                        .client_secret("lp9Jfwo7wd32bndgDQc8wln6-8bHih5nPwE3v_t08l4r_vF8tmFYqH1boT-9nl21")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_admin@parataqa.com")
                        .password("everyA@09").realm("parata-auth").build();
                requestSpec = getSpec("production_TokenStg", Boolean.parseBoolean("false"));
                break;
            default:
                token = UserToken.builder()
                        .client_id("tx3EYHNsI4cmU7WHWtsiQyBZL1Qd4nY0")
                        .client_secret("k_sXqy-buOoFqHd_bd-eS_gHe1wFIE58C5b32LD1zqEkelm0SFv5vFcQuu8rTNXZ")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_pm@gayco.com")
                        .password("everyA@09").realm("parata-auth").build();
                requestSpec = getSpec("production_Dev_Token", Boolean.parseBoolean("false"));
                System.out.println("DEV");

        }
        Response response =
                given().
                        spec(requestSpec).
                        /*if you need header you can write below.*/
                                body(token).
                        when().
                        post();
        tokenString = response.path("access_token");
        System.out.println("PM_Token for Gayco is " + tokenString);

        return tokenString;
    }
    public static String getPM_TestUser_Token() {
        UserToken token;

        switch (GLOBAL.APPLICATION_ENVIRONMENT.toUpperCase()) {
            case "STAGING":
            case "STAG":
            case "STG":
                token = UserToken.builder()
                        .client_id("GpyTud6g2JPfwPzRgilOWuJqZ0g5KLeo")
                        .client_secret("lp9Jfwo7wd32bndgDQc8wln6-8bHih5nPwE3v_t08l4r_vF8tmFYqH1boT-9nl21")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuserparata@gmail.com")
                        .password("yh_!0TbD").realm("parata-auth").build();

                requestSpec = getSpec("production_TokenStg", Boolean.parseBoolean("false"));
                break;
            case "PRODUCTION":
            case "PROD":
                token = UserToken.builder()
                        .client_id("GpyTud6g2JPfwPzRgilOWuJqZ0g5KLeo")
                        .client_secret("lp9Jfwo7wd32bndgDQc8wln6-8bHih5nPwE3v_t08l4r_vF8tmFYqH1boT-9nl21")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_admin@parataqa.com")
                        .password("everyA@09").realm("parata-auth").build();
                requestSpec = getSpec("production_TokenStg", Boolean.parseBoolean("false"));
                break;
            default:
                token = UserToken.builder()
                        .client_id("tx3EYHNsI4cmU7WHWtsiQyBZL1Qd4nY0")
                        .client_secret("k_sXqy-buOoFqHd_bd-eS_gHe1wFIE58C5b32LD1zqEkelm0SFv5vFcQuu8rTNXZ")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_pm@gayco.com")
                        .password("everyA@09").realm("parata-auth").build();
                requestSpec = getSpec("production_Dev_Token", Boolean.parseBoolean("false"));
                System.out.println("DEV");

        }
        Response response =
                given().
                        spec(requestSpec).
                        /*if you need header you can write below.*/
                                body(token).
                        when().
                        post();
        tokenString = response.path("access_token");
        System.out.println("PM_TestUser is " + tokenString);

        return tokenString;
    }

    public static String getIS_PU_Token() {

        UserToken token;

        switch (GLOBAL.APPLICATION_ENVIRONMENT.toUpperCase()) {
            case "STAGING":
            case "STAG":
            case "STG":
                token = UserToken.builder()
                        .client_id("GpyTud6g2JPfwPzRgilOWuJqZ0g5KLeo")
                        .client_secret("lp9Jfwo7wd32bndgDQc8wln6-8bHih5nPwE3v_t08l4r_vF8tmFYqH1boT-9nl21")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_is@pu.com")
                        .password("everyA@09").realm("parata-auth").build();

                requestSpec = getSpec("production_TokenStg", Boolean.parseBoolean("false"));
                break;
            case "PRODUCTION":
            case "PROD":
                token = UserToken.builder()
                        .client_id("GpyTud6g2JPfwPzRgilOWuJqZ0g5KLeo")
                        .client_secret("lp9Jfwo7wd32bndgDQc8wln6-8bHih5nPwE3v_t08l4r_vF8tmFYqH1boT-9nl21")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_is@pu.com")
                        .password("everyA@09").realm("parata-auth").build();

                requestSpec = getSpec("production_TokenProd", Boolean.parseBoolean("false"));
                break;
            default:
                token = UserToken.builder()
                        .client_id("tx3EYHNsI4cmU7WHWtsiQyBZL1Qd4nY0")
                        .client_secret("k_sXqy-buOoFqHd_bd-eS_gHe1wFIE58C5b32LD1zqEkelm0SFv5vFcQuu8rTNXZ")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_is@pu.com")
                        .password("everyA@09").realm("parata-auth").build();

                requestSpec = getSpec("production_Dev_Token", Boolean.parseBoolean("false"));
                System.out.println("DEV");
        }
        Response response =
                given().
                        spec(requestSpec).
                        /*if you need header you can write below.*/
                                body(token).
                        when().
                        post();
        tokenString = response.path("access_token");
        System.out.println("IS Token for PU is " + tokenString);

        return tokenString;
    }

    public static String getPM_PU_Token() {
        UserToken token;

        switch (GLOBAL.APPLICATION_ENVIRONMENT.toUpperCase()) {
            case "STAGING":
            case "STAG":
            case "STG":
                token = UserToken.builder()
                        .client_id("GpyTud6g2JPfwPzRgilOWuJqZ0g5KLeo")
                        .client_secret("lp9Jfwo7wd32bndgDQc8wln6-8bHih5nPwE3v_t08l4r_vF8tmFYqH1boT-9nl21")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_pm@pu.com")
                        .password("everyA@09").realm("parata-auth").build();

                requestSpec = getSpec("production_TokenStg", Boolean.parseBoolean("false"));
                break;
            case "PRODUCTION":
            case "PROD":
                token = UserToken.builder()
                        .client_id("GpyTud6g2JPfwPzRgilOWuJqZ0g5KLeo")
                        .client_secret("lp9Jfwo7wd32bndgDQc8wln6-8bHih5nPwE3v_t08l4r_vF8tmFYqH1boT-9nl21")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_is@pu.com")
                        .password("everyA@09").realm("parata-auth").build();
                requestSpec = getSpec("production_TokenStg", Boolean.parseBoolean("false"));
                break;
            default:
                token = UserToken.builder()
                        .client_id("tx3EYHNsI4cmU7WHWtsiQyBZL1Qd4nY0")
                        .client_secret("k_sXqy-buOoFqHd_bd-eS_gHe1wFIE58C5b32LD1zqEkelm0SFv5vFcQuu8rTNXZ")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_pm@pu.com")
                        .password("everyA@09").realm("parata-auth").build();

                requestSpec = getSpec("production_Dev_Token", Boolean.parseBoolean("false"));
                System.out.println("DEV");
        }
        Response response =
                given().
                        spec(requestSpec).
                        /*if you need header you can write below.*/
                                body(token).
                        when().log().all().
                        post();
        tokenString = response.path("access_token");
        System.out.println("PM Token for PU is " + tokenString);

        return tokenString;
    }

    public static String getIS_Token_Gayco() {
        UserToken token;

        switch (GLOBAL.APPLICATION_ENVIRONMENT.toUpperCase()) {
            case "STAGING":
            case "STAG":
            case "STG":
                token = UserToken.builder()
                        .client_id("GpyTud6g2JPfwPzRgilOWuJqZ0g5KLeo")
                        .client_secret("lp9Jfwo7wd32bndgDQc8wln6-8bHih5nPwE3v_t08l4r_vF8tmFYqH1boT-9nl21")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_is@gayco.com")
                        .password("everyA@09").realm("parata-auth").build();

                requestSpec = getSpec("production_TokenStg", Boolean.parseBoolean("false"));
                break;
            case "PRODUCTION":
            case "PROD":
                token = UserToken.builder()
                        .client_id("GpyTud6g2JPfwPzRgilOWuJqZ0g5KLeo")
                        .client_secret("lp9Jfwo7wd32bndgDQc8wln6-8bHih5nPwE3v_t08l4r_vF8tmFYqH1boT-9nl21")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_is@pu.com")
                        .password("everyA@09").realm("parata-auth").build();
                requestSpec = getSpec("production_TokenStg", Boolean.parseBoolean("false"));
                break;
            default:
                token = UserToken.builder()
                        .client_id("tx3EYHNsI4cmU7WHWtsiQyBZL1Qd4nY0")
                        .client_secret("k_sXqy-buOoFqHd_bd-eS_gHe1wFIE58C5b32LD1zqEkelm0SFv5vFcQuu8rTNXZ")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_is@gayco.com")
                        .password("everyA@09").realm("parata-auth").build();

                requestSpec = getSpec("production_Dev_Token", Boolean.parseBoolean("false"));
                System.out.println("DEV");
        }
        Response response =
                given().
                        spec(requestSpec).
                        /*if you need header you can write below.*/
                                body(token).
                        when().
                        post();
        tokenString = response.path("access_token");
        System.out.println("IS Token for Gayco is " + tokenString);

        return tokenString;
    }

    public static String getIM_Internal_Token() {
        UserToken token;

        switch (GLOBAL.APPLICATION_ENVIRONMENT.toUpperCase()) {
            case "STAGING":
            case "STAG":
            case "STG":
                token = UserToken.builder()
                        //  .client_id("tx3EYHNsI4cmU7WHWtsiQyBZL1Qd4nY0")
                        //.client_secret("k_sXqy-buOoFqHd_bd-eS_gHe1wFIE58C5b32LD1zqEkelm0SFv5vFcQuu8rTNXZ")
                        .client_id("GpyTud6g2JPfwPzRgilOWuJqZ0g5KLeo")
                        .client_secret("lp9Jfwo7wd32bndgDQc8wln6-8bHih5nPwE3v_t08l4r_vF8tmFYqH1boT-9nl21")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("engineeringtestuser@parata.com")
                        .password("he@vyWhale32").realm("parata-auth").build();

                requestSpec = getSpec("production_TokenStg", Boolean.parseBoolean("false"));
                break;
            case "PRODUCTION":
            case "PROD":
                token = UserToken.builder()
                        .client_id("GpyTud6g2JPfwPzRgilOWuJqZ0g5KLeo")
                        .client_secret("lp9Jfwo7wd32bndgDQc8wln6-8bHih5nPwE3v_t08l4r_vF8tmFYqH1boT-9nl21")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_is@pu.com")
                        .password("everyA@09").realm("parata-auth").build();
                requestSpec = getSpec("production_TokenStg", Boolean.parseBoolean("false"));
                break;
            default:
                token = UserToken.builder()
                        .client_id("tx3EYHNsI4cmU7WHWtsiQyBZL1Qd4nY0")
                        .client_secret("k_sXqy-buOoFqHd_bd-eS_gHe1wFIE58C5b32LD1zqEkelm0SFv5vFcQuu8rTNXZ")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("engineeringtestuser@parata.com")
                        .password("he@vyWhale32").realm("parata-auth").build();
                requestSpec = getSpec("production_Dev_Token", Boolean.parseBoolean("false"));
                System.out.println("DEV");
        }
        Response response =
                given().
                        spec(requestSpec).
                        /*if you need header you can write below.*/
                                body(token).
                        when().
                        post();
        tokenString = response.path("access_token");
        System.out.println("PM_Token is " + tokenString);

        return tokenString;
    }

    public static String getPharmacyUnlimited_AustinPM_Token() {

        UserToken token;
        switch (GLOBAL.APPLICATION_ENVIRONMENT.toUpperCase()) {
            case "STAGING":
            case "STAG":
            case "STG":
                token = UserToken.builder()
                        .client_id("GpyTud6g2JPfwPzRgilOWuJqZ0g5KLeo")
                        .client_secret("lp9Jfwo7wd32bndgDQc8wln6-8bHih5nPwE3v_t08l4r_vF8tmFYqH1boT-9nl21")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_pm@pu.com")
                        .password("everyA@09").realm("parata-auth").build();

                requestSpec = getSpec("production_TokenStg", Boolean.parseBoolean("false"));
                System.out.println("STG");
                break;
            case "PRODUCTION":
            case "PROD":
                token = UserToken.builder()
                        .client_id("GpyTud6g2JPfwPzRgilOWuJqZ0g5KLeo")
                        .client_secret("lp9Jfwo7wd32bndgDQc8wln6-8bHih5nPwE3v_t08l4r_vF8tmFYqH1boT-9nl21")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_is@pu.com")
                        .password("everyA@09").realm("parata-auth").build();
                requestSpec = getSpec("production_TokenStg", Boolean.parseBoolean("false"));
                System.out.println("PROD");
                break;
            default:
                token = UserToken.builder()
                        .client_id("tx3EYHNsI4cmU7WHWtsiQyBZL1Qd4nY0")
                        .client_secret("k_sXqy-buOoFqHd_bd-eS_gHe1wFIE58C5b32LD1zqEkelm0SFv5vFcQuu8rTNXZ")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_pm@pu.com")
                        .password("everyA@09").realm("parata-auth").build();
                requestSpec = getSpec("production_Dev_Token", Boolean.parseBoolean("false"));
                System.out.println("DEV");
        }
        Response response =
                given().
                        spec(requestSpec).
                        /*if you need header you can write below.*/
                                body(token).
                        when().
                        post();
        tokenString = response.path("access_token");
        System.out.println("Pharmacy Unlimited token is " + tokenString);

        return tokenString;
    }

    public static String getGeneralCreation_Token() {
        UserToken token;

        switch (GLOBAL.APPLICATION_ENVIRONMENT.toUpperCase()) {
            case "STAGING":
            case "STAG":
            case "STG":
                token = UserToken.builder()
                        .client_id("GpyTud6g2JPfwPzRgilOWuJqZ0g5KLeo")
                        .client_secret("lp9Jfwo7wd32bndgDQc8wln6-8bHih5nPwE3v_t08l4r_vF8tmFYqH1boT-9nl21")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_admin@parataa.com")
                      //  .username("testuser_admin@parataqa.com")
                        .password("everyA@09").realm("parata-auth").build();

                requestSpec = getSpec("production_TokenStg", Boolean.parseBoolean("false"));
                System.out.println("STAGING");
                break;
            case "PRODUCTION":
            case "PROD":
                token = UserToken.builder()
                        .client_id("GpyTud6g2JPfwPzRgilOWuJqZ0g5KLeo")
                        .client_secret("lp9Jfwo7wd32bndgDQc8wln6-8bHih5nPwE3v_t08l4r_vF8tmFYqH1boT-9nl21")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_is@pu.com")
                        .password("everyA@09").realm("parata-auth").build();
                requestSpec = getSpec("production_TokenStg", Boolean.parseBoolean("false"));
                break;
            default:
                token = UserToken.builder()
                        .client_id("tx3EYHNsI4cmU7WHWtsiQyBZL1Qd4nY0")
                        .client_secret("k_sXqy-buOoFqHd_bd-eS_gHe1wFIE58C5b32LD1zqEkelm0SFv5vFcQuu8rTNXZ")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_admin@parataa.com")
                        //  .username("testuser_admin@parataqa.com")
                        .password("everyA@09").realm("parata-auth").build();
                requestSpec = getSpec("production_Dev_Token", Boolean.parseBoolean("false"));
                System.out.println("DEV");
        }
        Response response =
                given().
                        spec(requestSpec).
                        /*if you need header you can write below.*/
                                body(token).log().all().
                        when().
                        post();
        tokenString = response.path("access_token");
        System.out.println("General Creation Token " + tokenString);

        return tokenString;
    }

    public static String getHardDeleteToken() {
        UserToken token;

        switch (GLOBAL.APPLICATION_ENVIRONMENT.toUpperCase()) {
            case "STAGING":
            case "STAG":
            case "STG":
                token = UserToken.builder()
                        .client_id("GpyTud6g2JPfwPzRgilOWuJqZ0g5KLeo")
                        .client_secret("lp9Jfwo7wd32bndgDQc8wln6-8bHih5nPwE3v_t08l4r_vF8tmFYqH1boT-9nl21")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_admin@parataa.com")
                        //  .username("testuser_admin@parataqa.com")
                        .password("everyA@09").realm("parata-auth").build();

                requestSpec = getSpec("production_TokenStg", Boolean.parseBoolean("false"));
                break;
            case "PRODUCTION":
            case "PROD":
                token = UserToken.builder()
                        .client_id("GpyTud6g2JPfwPzRgilOWuJqZ0g5KLeo")
                        .client_secret("lp9Jfwo7wd32bndgDQc8wln6-8bHih5nPwE3v_t08l4r_vF8tmFYqH1boT-9nl21")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_is@pu.com")
                        .password("everyA@09").realm("parata-auth").build();
                requestSpec = getSpec("production_TokenStg", Boolean.parseBoolean("false"));
                break;
            default:
                token = UserToken.builder()
                        .client_id("tx3EYHNsI4cmU7WHWtsiQyBZL1Qd4nY0")
                        .client_secret("k_sXqy-buOoFqHd_bd-eS_gHe1wFIE58C5b32LD1zqEkelm0SFv5vFcQuu8rTNXZ")
                        .audience("https://m2maspnet/api")
                        .grant_type("http://auth0.com/oauth/grant-type/password-realm")
                        .username("testuser_admin@parataa.com")
                        //  .username("testuser_admin@parataqa.com")
                        .password("everyA@09").realm("parata-auth").build();
                requestSpec = getSpec("production_Dev_Token", Boolean.parseBoolean("false"));
                System.out.println("DEV");
        }
        Response response =
                given().
                        spec(requestSpec).
                        /*if you need header you can write below.*/
                                body(token).
                        when().
                        post();
        tokenString = response.path("access_token");
        System.out.println("General Hard Delete token is " + tokenString);

        return tokenString;

    }


    public static void main(String[] args) {
        /*getPM_Gayco_Token();
        getPM_PU_Token();
        getIS_Token_Gayco();
        getIS_PU_Token();

        getHardDeleteToken();
        getPharmacyUnlimited_AustinPM_Token();
        */
    //    getPM_TestUser_Token();
        getPM_Gayco_Token();
       // getPM_PU_Token();
      getGeneralInternalAdminToken();
      getIM_Internal_Token();
    }
}