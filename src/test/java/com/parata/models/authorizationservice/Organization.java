package com.parata.models.authorizationservice;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties
@Data
@Getter
@NoArgsConstructor
public class Organization {
    @JsonProperty
    private String organizationId;
    @JsonProperty
    private String name;
    @JsonProperty
    private String salesforceName;
    @JsonProperty
    private Boolean is_Parent_Account;
    @JsonProperty
    private String parent_Account_Id;
    @JsonProperty
    private String parata_IM;
    @JsonProperty
    private String primary_Org_Admin;
    @JsonProperty
    private String parata_Support_Person;
    @JsonProperty
    private String startTime;
    @JsonProperty
    private String closingTime;
    @JsonProperty
    private int orgStatusId;
    @JsonProperty
    private String salesforceId;
    @JsonProperty
    private String customerNo;
    @JsonProperty
    private OrgStatus orgStatus;
    @JsonProperty
    private Boolean isInternal;
  /*  @JsonProperty
    private String createdBy;*/
    @JsonProperty
    private Boolean enabled;
    @JsonProperty
    private String lastActionDoneBy;
    @JsonProperty
    private String lastActionDoneOn;
    @JsonProperty
    private String lastActionDone;
    /*
"organizationId": "e9c62117-f8f4-456c-81c8-c7cf6557e8a7",
    "name": "Fenway Health - Parent",
    "is_Parent_Account": true,
    "parent_Account_Id": "e9c62117-f8f4-456c-81c8-c7cf6557e8a7",
    "parata_IM": "00000000-0000-0000-0000-000000000000",
    "primary_Org_Admin": "00000000-0000-0000-0000-000000000000",
    "parata_Support_Person": "00000000-0000-0000-0000-000000000000",
    "startTime": "00:00:00",
    "closingTime": "00:00:00",
    "orgStatusId": 1,
    "salesforceId": "0016000001FvhIPAAZ",
    "orgStatus": {
        "orgStatusId": 1,
        "name": "Initial",
        "description": "Sent Survey",
        "createdBy": "00000000-0000-0000-0000-000000000000",
        "enabled": true,
        "dateCreated": "2021-03-15T22:02:25.139032",
        "dateModified": "2021-03-15T22:02:25.139033"
    },
    "isInternal": false,
    "createdBy": "8db328df-c433-46b3-87ca-a1f3a4d4bd3b",
    "enabled": true,
    "dateCreated": "2021-06-04T16:13:37.786145",
    "dateModified": "2021-06-04T16:13:37.786148"

    */
}
