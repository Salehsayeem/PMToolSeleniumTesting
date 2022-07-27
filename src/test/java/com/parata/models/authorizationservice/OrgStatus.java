package com.parata.models.authorizationservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@Getter
@NoArgsConstructor
public class OrgStatus {
    @JsonProperty
    private int orgStatusId;
    @JsonProperty
    private String name;
    @JsonProperty
    private String description;
    @JsonProperty
    private Boolean enabled;
    @JsonProperty
    private String lastActionDoneBy;
    @JsonProperty
    private String lastActionDoneOn;
    @JsonProperty
    private String lastActionDone;
    
    /*
"orgStatus": {
        "orgStatusId": 1,
        "name": "Initial",
        "description": "Sent Survey",
        "createdBy": "00000000-0000-0000-0000-000000000000",
        "enabled": true,
        "dateCreated": "2021-03-15T22:02:25.139032",
        "dateModified": "2021-03-15T22:02:25.139033"
    },
    */
}
