package com.parata.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;


/**
 * @author MFU
 * 8/23/2020
 */

@lombok.Data
@Builder
public class GET_User_Request {
    @JsonProperty
    private String client_id;


}







