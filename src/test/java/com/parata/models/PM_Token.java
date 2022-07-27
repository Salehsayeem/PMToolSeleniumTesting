package com.parata.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;


/**
 * @author MFU
 * 8/23/2020
 */

@lombok.Data
@Builder
public class PM_Token {
    @JsonProperty
    private String client_id;
    @JsonProperty
    private String client_secret;
    @JsonProperty
    private String audience;
    @JsonProperty
    private String grant_type;
    @JsonProperty
    private String username;
    @JsonProperty
    private String password;
    @JsonProperty
    private String realm;

}







