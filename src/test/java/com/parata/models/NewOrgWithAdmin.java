package com.parata.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;


/**
 * @author MFU
 * 8/23/2020
 */

@lombok.Data
@Builder
public class NewOrgWithAdmin {
    @JsonProperty
    private String parentOrgName;
    @JsonProperty
    private String orgName;
    @JsonProperty
    private String roleName;
    @JsonProperty
    private String userFirstName;
    @JsonProperty
    private String userLastName;
    @JsonProperty
    private String userEmail;
}







