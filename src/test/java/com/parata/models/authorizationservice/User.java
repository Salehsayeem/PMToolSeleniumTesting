package com.parata.models.authorizationservice;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@Getter
@NoArgsConstructor
public class User {
    @JsonProperty
    private String userId;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String auth0UserId;
    @JsonProperty
    private String email;
    @JsonProperty
    private Boolean eulA_Accepted;
    @JsonProperty
    private String eulA_Accepted_On;
    @JsonProperty
    private Boolean enabled;
    @JsonProperty
    private String lastActionDoneOn;
    @JsonProperty
    private String lastActionDone;
    @JsonProperty
    private String userName;
    @JsonProperty
    private String lastActionDoneBy;

}
